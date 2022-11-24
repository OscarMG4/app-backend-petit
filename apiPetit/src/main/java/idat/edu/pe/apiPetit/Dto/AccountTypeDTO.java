package idat.edu.pe.apiPetit.Dto;

import javax.validation.constraints.NotEmpty;

public class AccountTypeDTO {
    private Integer id;
    @NotEmpty(message = "El campo tipo de cuenta es obligatorio!")
    private String accountType;

    public AccountTypeDTO() {
    }

    public AccountTypeDTO(Integer id, String accountType) {
        this.id = id;
        this.accountType = accountType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
