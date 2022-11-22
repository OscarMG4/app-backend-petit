package idat.edu.pe.apiPetit.Dto;

import idat.edu.pe.apiPetit.Entity.Quote;

import java.util.List;

public class ServiceTypeDTO {

    private Integer id;
    private String serviceType;
    private List<Quote> quotes;
    public ServiceTypeDTO() {
    }

    public ServiceTypeDTO(Integer id, String serviceType) {
        this.id = id;
        this.serviceType = serviceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
