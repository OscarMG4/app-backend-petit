package idat.edu.pe.apiPetit.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pets_types")
public class PetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPetType;
    @Column(name = "pet_type", nullable = false, unique = true)
    private String petType;
    @JsonBackReference
    @OneToMany(mappedBy = "petType", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Pet> pets = new ArrayList<>();
    public PetType() {
    }

    public PetType(Integer idPetType, String petType) {
        this.idPetType = idPetType;
        this.petType = petType;
    }

    public Integer getIdPetType() {
        return idPetType;
    }

    public void setIdPetType(Integer idPetType) {
        this.idPetType = idPetType;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
