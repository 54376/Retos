package com.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="quadbike")
public class Quadbike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  name;
    private String  brand;
    private Integer year;
    private String  description;
    /**
     * Relación muchos a uno con la tabla de categoría
     * una categoría contiene una cuatrimoto y una cuatrimoto pertenece a una categoría
     */
    @ManyToOne
    @JoinColumn(name="idCategory")
    @JsonIgnoreProperties("quadbikes")
    private Category category;
    /**
     * Relación muchos a uno con la tabla de mensajes
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Message> messages;
    /**
     * Relación muchos a uno con la tabla de reservaciones
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Reservation> reservations;
    /**
     * getId()
     * Esta función retorna el id
     * @return
     */
    public Integer getId() {
        return id;
    }
    /**
     * setId()
     * Esta función envia el id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * getBrand()
     * Esta función retorna la marca
     * @return
     */
    public String getBrand() {
        return brand;
    }
    /**
     * setBrand()
     * Esta función envia la marca
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     * getDescription()
     * Esta función retorna la descripción
     * @return
     */
    public String getDescription() {
        return description;
    }
    /**
     * setDescription()
     * Esta función envia la descripción
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * getYear()
     * Esta función retorna el año
     * @return
     */
    public Integer getYear() {
        return year;
    }
    /**
     * setYear()
     * Esta función envia el año
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
     * getCategory()
     * Esta función retorna la categoría
     * @return
     */
    public Category getCategory() {
        return category;
    }
    /**
     * setCategory()
     * Esta función envia la categoría
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
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