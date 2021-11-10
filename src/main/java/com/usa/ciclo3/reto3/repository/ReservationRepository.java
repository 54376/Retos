package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.crudrepository.ReservationCrudRepository;
import com.usa.ciclo3.reto3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation>ReservationStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> ReservationTiempoRepositorio(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }

    public List<CounterClients> getClientsRepository(){
        List<CounterClients> res =new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){

            res.add(new CounterClients((long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }
}