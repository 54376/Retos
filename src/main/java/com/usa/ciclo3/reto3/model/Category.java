package com.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/** Definición de objeto para generar la relación **/

@Entity
@Table(name= "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  name;
    private String  description;
    /**
     * Relación muchos a uno con la tabla de cuatrimotos
     * una categoría contiene varias cuatrimotos y cada cuatrimoto pertenece a una categoría
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Quadbike> quadbikes;
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
     * getDescription()
     * Esta función retorna el descripción
     * @return
     */
    public String getDescription() {
        return description;
    }
    /**
     * setDescription()
     * Esta función envia el descripción
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * getQuadbikes()
     * Esta función retorna las cuatrimotos
     * @return
     */
    public List<Quadbike> getQuadbikes() {
        return quadbikes;
    }
    /**
     * setQuadbikes()
     * Esta función envia las cuatrimotos
     * @param quadbikes
     */
    public void setQuadbikes(List<Quadbike> quadbikes) {
        this.quadbikes = quadbikes;
    }
}