package idat.edu.pe.apiPetit.Dto;

import java.time.LocalDateTime;

public class QuoteDTO {
    private Integer id;
    private LocalDateTime dateIssued;
    private LocalDateTime dateAttention;

    private String typeService;
    private Double price;

    public QuoteDTO() {
    }

    public QuoteDTO(Integer id, LocalDateTime dateIssued, LocalDateTime dateAttention, String typeService, Double price) {
        this.id = id;
        this.dateIssued = dateIssued;
        this.dateAttention = dateAttention;
        this.typeService = typeService;
        this.price = price;
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

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
