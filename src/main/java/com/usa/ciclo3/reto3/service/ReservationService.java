package com.usa.ciclo3.reto3.service;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> tmpreservation = reservationRepository.getReservation(reservation.getIdReservation());
            if (tmpreservation.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> tmpreservation = reservationRepository.getReservation(reservation.getIdReservation());
            if (!tmpreservation.isEmpty()) {
                return reservationRepository.save(reservation);
            }
        }
        return null;
    }

    public boolean deleteReservation(int id){
        boolean Boolean=getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return Boolean;

    public ReportsStatus reporteStatusServicio (){
        List<Reservation>completed= reservationRepository.ReservationStatusRepository("completed");
        List<Reservation>cancelled= reservationRepository.ReservationStatusRepository("cancelled");
        return new ReportsStatus(completed.size(), cancelled.size() );
    }

    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepository.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }

    public List<ReportsClient> reporteClientsService(){
        return reservationRepository.getClientsRepository();
    }
}