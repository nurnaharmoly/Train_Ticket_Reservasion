package com.example.trainreservation.controller;

import com.example.trainreservation.entity.Role;
import com.example.trainreservation.entity.User;
import com.example.trainreservation.repo.RoleRepo;
import com.example.trainreservation.repo.UserRepo;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class LoginController {

    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;


    @Autowired
    private PasswordEncoder passwordEncoder;
    private static String USER_NAME = "molynur570";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "0987&654321"; // GMail password

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)){
           return "redirect:/";
        }
        return "signin";
    }


    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }


    @GetMapping(value = "/signup")
    public String viewSignUp(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }

    @PostMapping(value = "/signup")
    public String add(@Valid User user, BindingResult result, Model model, HttpServletRequest request){
        String username = user.getEmail().split("\\@")[0];
        user.setUserName(username);
        user.setEnabled(false);
        Set<Role> roles=new HashSet<>();
        roles.add(new Role(6L));
        user.setRegiDate(new Date());
        user.setRoles(roles);
        user.setConfirmationToken(UUID.randomUUID().toString());

        if(result.hasErrors()){
            model.addAttribute("rejectMsg","opps, Something Wrong");
            return "signup";
        }
        if(repo.existsByEmail(user.getEmail())){
            model.addAttribute("rejectMsg","Already Have This Entry");
            return "signup";
        }else{

            this.repo.save(user);
            //email sending
            String appUrl = request.getScheme() + "://" + request.getServerName()+":"+"8008";
            String from = USER_NAME;
            String pass = PASSWORD;
            String[] to = {user.getEmail()}; // list of recipient email addresses
            String subject = "Registration Confirmation";
            String body = "To confirm your e-mail address, please click the link below:\n"
                    + appUrl + "/confirm?token=" + user.getConfirmationToken();

            sendFromGMail(from, pass, to, subject, body);

            model.addAttribute("successMsg", "A confirmation e-mail has been sent to " + user.getEmail());
        }

        return "signup";
    }




//    @PostMapping(value = "/forget")
//    public String forget(@RequestParam(value = "email") String email, Model model, HttpServletRequest request) {
//
//
//
//        if (!repo.existsByEmail(email)) {
//            model.addAttribute("rejectMsg", "This email addresss is not associated with US");
//            return "forget";
//        } else {
//            Optional<User> user1=repo.findByEmail(email);
//            //email sending
//            // 172.16.185.51
//            //String appUrl = request.getScheme() + "://" + request.getServerName()+":"+"8008";
//            String appUrl = request.getScheme() + "://" + request.getRemoteAddr() + ":" + "8008";
//            System.out.println("appUrl: " + appUrl);
//            String from = USER_NAME;
//            String pass = PASSWORD;
//            String[] to = {email}; // list of recipient email addresses
//            String subject = "Got Your Password";
//            String body = "To confirm your e-mail address, please click the link below:\n"
//                    + appUrl + "/confirm?token=" + user1.get().getConfirmationToken();
//
//            sendFromGMail(from, pass, to, subject, body);
//            repo.setTokenExpiredByEmail(false,email);
//            model.addAttribute("successMsg", "An e-mail has been sent to " + email);
//        }
//
//
//        return "forget";
//    }
//
//    @GetMapping(value = "/forget")
//    public String viewForgetPassword(Model model) {
//        model.addAttribute("user", new User());
//        return "forget";
//    }
//
//
//





    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.GET)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam("token") String token) {

        User user = repo.findByConfirmationToken(token);

        if (user == null) { // No token found in DB
            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
        } else { // Token found
            modelAndView.addObject("confirmationToken", user.getConfirmationToken());
        }

        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.POST)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        modelAndView.setViewName("confirm");

        Zxcvbn passwordCheck = new Zxcvbn();

        Strength strength = passwordCheck.measure(requestParams.get("password"));

        if (strength.getScore() < 3) {
            //modelAndView.addObject("errorMessage", "Your password is too weak.  Choose a stronger one.");
            bindingResult.reject("password");

            redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

            modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
            //	System.out.println(requestParams.get("token"));
            return modelAndView;
        }

        // Find the user associated with the reset token
        User user = repo.findByConfirmationToken(requestParams.get("token"));

        // Set new password
        user.setPassword(passwordEncoder.encode(requestParams.get("password")));

        // Set user to enabled
        user.setEnabled(true);

        // Save user
        repo.save(user);

        modelAndView.addObject("successMessage", "Your password has been set!");
        return modelAndView;
    }
    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("molynur570@gmail.com", "MOLY LLC."));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Email sending Success!!!");
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
