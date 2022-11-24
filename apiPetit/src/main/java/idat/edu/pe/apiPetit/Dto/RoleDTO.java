package idat.edu.pe.apiPetit.Dto;

import javax.validation.constraints.NotEmpty;

public class RoleDTO {

    private Integer id;
    @NotEmpty(message = "El campo rol es obligatorio!")
    private String role;

    public RoleDTO() {
    }

    public RoleDTO(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
