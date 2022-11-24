package idat.edu.pe.apiPetit.Dto;

import javax.validation.constraints.NotEmpty;

public class AdoptionDTO {
    private Integer id;
    @NotEmpty(message = "El campo descripción es obligatorio!")
    private String description;

    public AdoptionDTO() {
    }

    public AdoptionDTO(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
