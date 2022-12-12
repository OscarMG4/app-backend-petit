package idat.edu.pe.apiPetit.Dto;

import idat.edu.pe.apiPetit.Entity.ServiceType;
import idat.edu.pe.apiPetit.Entity.State;

import java.time.LocalDateTime;

public class QuoteResponseDTO {
    private Integer id;
    private LocalDateTime dateIssued;
    private LocalDateTime dateAttention;
    private Double price;

    private ServiceType serviceType;

    private State state;

    public QuoteResponseDTO() {
    }

    public QuoteResponseDTO(Integer id, LocalDateTime dateIssued, LocalDateTime dateAttention, Double price, ServiceType serviceType, State state) {
        this.id = id;
        this.dateIssued = dateIssued;
        this.dateAttention = dateAttention;
        this.price = price;
        this.serviceType = serviceType;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDateTime dateIssued) {
        this.dateIssued = dateIssued;
    }

    public LocalDateTime getDateAttention() {
        return dateAttention;
    }

    public void setDateAttention(LocalDateTime dateAttention) {
        this.dateAttention = dateAttention;
    }

    public Double getPrice() {
        return price;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
