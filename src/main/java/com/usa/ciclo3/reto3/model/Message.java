package com.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="message")

public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String  messageText;
    /**
     * Relación muchos a uno con la tabla de cuatrimotos
     */
    @ManyToOne
    @JoinColumn(name="idQuadbike")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Quadbike quadbike;
    /**
     * Relación muchos a uno con la tabla de clientes
     */
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Client client;
    /**
     * getIdMessage()
     * Esta función retorna el id de mensaje
     * @return
     */
    public Integer getIdMessage() {
        return idMessage;
    }
    /**
     * setIdMessage()
     * Esta función envia el id de mensaje
     * @param idMessage
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }
    /**
     * getMessageText()
     * Esta función retorna el mensaje de texto
     * @return
     */
    public String getMessageText() {
        return messageText;
    }
    /**
     * setMessageText()
     * Esta función envia el mensaje de texto
     * @param messageText
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    /**
     * getQuadbike()
     * Esta función retorna la cuatrimoto
     * @return
     */
    public Quadbike getQuadbike() {
        return quadbike;
    }
    /**
     * setQuadbike()
     * Esta función envia la cuatrimoto
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
}