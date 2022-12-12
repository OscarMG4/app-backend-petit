package idat.edu.pe.apiPetit.Dto;

import idat.edu.pe.apiPetit.Entity.Adoption;
import idat.edu.pe.apiPetit.Entity.Quote;

import java.util.List;

public class StateDTO {
    private Integer id;
    private String state;
    private List<Quote> quotes;
    private List<Adoption> adoptions;

    public StateDTO() {
    }

    public StateDTO(Integer id, String state) {
        this.id = id;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public List<Adoption> getAdoptions() {
        return adoptions;
    }

    public void setAdoptions(List<Adoption> adoptions) {
        this.adoptions = adoptions;
    }
}
