package idat.edu.pe.apiPetit.Entity;

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
    @Column(name = "name", nullable = false, length = 10, unique = true)
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "state", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Quote> quotes = new ArrayList<>();
    @OneToMany(mappedBy = "state", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Adoption> adoptions  = new ArrayList<>();

    public State() {
    }

    public State(Integer idState, String name) {
        this.idState = idState;
        this.name = name;
    }

    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
