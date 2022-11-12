package idat.edu.pe.apiPetit.Dto;

public class AccountDTO {
    private Integer id;
    private String email;
    private String pass;

    public AccountDTO() {
    }

    public AccountDTO(Integer id, String email, String pass) {
        this.id = id;
        this.email = email;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
