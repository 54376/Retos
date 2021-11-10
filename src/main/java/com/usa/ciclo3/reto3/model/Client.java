package com.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String  email;
    private String password;
    private String  name;
    private Integer age;
    /**
     * Relación muchos a uno con la tabla de mensajes
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;
    /**
     * Relación muchos a uno con la tabla de reservaciones
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;
    /**
     * getIdClient()
     * Esta función retorna el id del cliente
     * @return
     */
    public Integer getIdClient() {
        return idClient;
    }
    /**
     * setIdClient()
     * Esta función envia el id del cliente
     * @param idClient
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
    /**
     * getEmail()
     * Esta función retorna el correo
     * @return
     */
    public String getEmail() {
        return email;
    }
    /**
     * setEmail()
     * Esta función envia el correo
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * getName()
     * Esta función retorna el nombre
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * setName()
     * Esta función envia el nombre
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getPassword()
     * Esta función retorna la contraseña
     * @return
     */
    public String getPassword() {
        return password;
    }
    /**
     * setPassword()
     * Esta función envia el contraseña
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * getAge()
     * Esta función retorna la edad
     * @return
     */
    public Integer getAge() {
        return age;
    }
    /**
     * setAge()
     * Esta función envia la edad
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * getMessages()
     * Esta función retorna los mensajes
     * @return
     */
    public List<Message> getMessages() {
        return messages;
    }
    /**
     * setMessages()
     * Esta función envia los mensajes
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     * getReservations()
     * Esta función retorna las reservaciones
     * @return
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    /**
     * setReservations()
     * Esta función envia las reservaciones
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
