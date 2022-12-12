package idat.edu.pe.apiPetit.Dto;

import javax.validation.constraints.NotEmpty;

public class PetTypeDTO {
    private Integer id;
    @NotEmpty(message = "El campo tipo de mascota es obligatorio!")
    private String petType;

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

}
