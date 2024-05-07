package br.insper.demo.delivery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



import java.time.LocalDateTime;

@Entity
public class Delivery {
    private LocalDateTime startDate;
    private String origin;
    private String destination;
    private Double travelHours;
    private Double travelKm;
    private Double totalPrice;
    private String status;
    private Integer deliveryManId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Delivery(String origin, String destination, Double travelHours, Double travelKm, Double totalPrice, String status, Integer deliveryManId) {
        this.startDate = LocalDateTime.now();
        this.origin = origin;
        this.destination = destination;
        this.travelHours = travelHours;
        this.travelKm = travelKm;
        this.totalPrice = totalPrice;
        this.status = status;
        this.deliveryManId = deliveryManId;
    }

    public Delivery() {
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getTravelHours() {
        return travelHours;
    }

    public void setTravelHours(Double travelHours) {
        this.travelHours = travelHours;
    }

    public Double getTravelKm() {
        return travelKm;
    }

    public void setTravelKm(Double travelKm) {
        this.travelKm = travelKm;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDeliveryManId() {
        return deliveryManId;
    }

    public void setDeliveryManId(Integer deliveryManId) {
        this.deliveryManId = deliveryManId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
