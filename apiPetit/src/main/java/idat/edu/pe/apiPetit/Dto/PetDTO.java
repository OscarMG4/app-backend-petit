package idat.edu.pe.apiPetit.Dto;

import idat.edu.pe.apiPetit.Entity.Adoption;

import java.util.List;

public class PetDTO {
    private Integer id;
    private String name;
    private String sex;
    private String race;
    private String age;
    private List<Adoption> adoptions;

    public PetDTO() {
    }

    public PetDTO(Integer id, String name, String sex, String race, String age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Adoption> getAdoptions() {
        return adoptions;
    }

    public void setAdoptions(List<Adoption> adoptions) {
        this.adoptions = adoptions;
    }
}
