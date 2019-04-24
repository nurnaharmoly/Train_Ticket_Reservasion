package com.example.trainreservation.jasper;

import com.example.trainreservation.entity.Reservation;
import com.example.trainreservation.entity.SeatOrCabin;
import com.example.trainreservation.repo.ReservationRepo;
import com.example.trainreservation.repo.SeatOrCabinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("reserveService")
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReservationRepo reservationRepo;


    @Override
    public List<Map<String, Object>> reservetionreport() {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Reservation reservation : reservationRepo.findAll()) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id", reservation.getId());
            item.put("noOffSeats", reservation.getNoOffSeats());
            item.put("unitPrice", reservation.getUnitPrice());
            item.put("totalPrice", reservation.getTotalPrice());
            item.put("journyDate", reservation.getJournyDate());
            //item.put("taskCriticalLevel", task.getTaskCriticalLevel().getLevel());
            // item.put("projectModule", task.getProjectModule().getTitle());
            // item.put("company", task.getCompany().getCompanyName());
//            item.put("dependentTaskStatus", task.isDependentTaskStatus());
            result.add(item);
        }
        return result;
    }
}

