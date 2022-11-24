package idat.edu.pe.apiPetit.Dto;

import javax.validation.constraints.NotEmpty;

public class StateDTO {
    private Integer id;
    @NotEmpty(message = "El campo estado es obligatorio!")
    private String state;

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

}
