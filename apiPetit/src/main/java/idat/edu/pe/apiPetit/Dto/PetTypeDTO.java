package idat.edu.pe.apiPetit.Dto;

import idat.edu.pe.apiPetit.Entity.Pet;

import java.util.List;

public class PetTypeDTO {
    private Integer id;
    private String petType;
//    private List<Pet> pets;

    public PetTypeDTO() {
    }

    public PetTypeDTO(Integer id, String petType) {
        this.id = id;
        this.petType = petType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }
//
//    public List<Pet> getPets() {
//        return pets;
//    }
//
//    public void setPets(List<Pet> pets) {
//        this.pets = pets;
//    }
}
