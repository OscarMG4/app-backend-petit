package idat.edu.pe.apiPetit.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPet;
    @Column(name = "typePet", nullable = false, length = 10)
    @NotBlank
    private String typePet;
    @Column(name = "name", nullable = false, length = 10)
    @NotBlank
    private String name;
    @Column(name = "sex", nullable = false, length = 10)
    @NotBlank
    private String sex;
    @Column(name = "race", nullable = false, length = 10)
    @NotBlank
    private String race;
    @Column(name = "age", nullable = false, length = 10)
    @NotBlank
    private String age;
    @OneToMany(mappedBy = "pet", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Adoption> adoptions = new ArrayList<>();

    public Pet() {
    }

    public Pet(Integer idPet, String typePet, String name, String sex, String race, String age) {
        this.idPet = idPet;
        this.typePet = typePet;
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.age = age;
    }

    public Integer getIdPet() {
        return idPet;
    }

    public void setIdPet(Integer idPet) {
        this.idPet = idPet;
    }

    public String getTypePet() {
        return typePet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Adoption> getAdoptions() {
        return adoptions;
    }

    public void setAdoptions(List<Adoption> adoptions) {
        this.adoptions = adoptions;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
