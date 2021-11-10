package com.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date    startDate;
    private Date    devolutionDate;
    private String  status = "created";
    /**
     * Relación muchos a uno con la tabla de cuatrimotos
     */
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"reservations"})
    private Quadbike quadbike;
    /**
     * Relación muchos a uno con la tabla de mensajes
     */
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client  client;

    private  String score;
    /**
     * getIdReservation()
     * Esta función retorna el id de la reservación
     * @return
     */
    public Integer getIdReservation() {
        return idReservation;
    }
    /**
     * setIdReservation()
     * Esta función envia el id de la reservación
     * @param idReservation
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    /**
     * getStartDate()
     * Esta función retorna la fecha de inicio
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * setStartDate()
     * Esta función envia la fecha de inicio
     * @param startDate
     */
    public void setStarDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * getDevolutionDate()
     * Esta función retorna la fecha de devolución
     * @return
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }
    /**
     * setDevolutionDate()
     * Esta función envia la fecha de devolución
     * @param devolutionDate
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    /**
     * getStatus()
     * Esta función retorna el estado de la reservación
     * @return
     */
    public String getStatus() {
        return status;
    }
    /**
     * setStatus()
     * Esta función envia el estado de la reservación
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * getQuadbike()
     * Esta función retorna la quatrimoto
     * @return
     */
    public Quadbike getQuadbike() {
        return quadbike;
    }
    /**
     * setQuadbike()
     * Esta función envia la quatrimoto
     * @param quadbike
     */
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }
    /**
     * getClient()
     * Esta función retorna el cliente
     * @return
     */
    public Client getClient() {
        return client;
    }
    /**
     * setClient()
     * Esta función envia el cliente
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }
    /**
     * getScore()
     * Esta función retorna la puntuación
     * @return
     */
    public String getScore() {
        return score;
    }
    /**
     * setScore()
     * Esta función envia la puntuación
     * @param score
     */
    public void setScore(String score) {
        this.score = score;
    }
}