package idat.edu.pe.apiPetit.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idState;
    @Column(name = "state", nullable = false, length = 15, unique = true)
    @NotBlank
    private String state;
    @OneToMany(mappedBy = "state", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Quote> quotes = new ArrayList<>();
    @OneToMany(mappedBy = "state", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Adoption> adoptions  = new ArrayList<>();

    public State() {
    }

    public State(Integer idState, String state) {
        this.idState = idState;
        this.state = state;
    }

    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
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
