package idat.edu.pe.apiPetit.Dto;

public class PublicRequestDTO {
    private Integer idUser;
    private String names;
    private String lastNames;
    private String dni;
    private String phone;
    private byte[] photo;
    private Integer idAccount;
    private String email;
    private String password;
    private Integer idAccountType;

    public PublicRequestDTO() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdAccountType() {
        return idAccountType;
    }

    public void setIdAccountType(Integer idAccountType) {
        this.idAccountType = idAccountType;
    }

    public PublicRequestDTO(Integer idUser, String names, String lastNames, String dni, String phone, byte[] photo, Integer idAccount, String email, String password, Integer idAccountType) {
        this.idUser = idUser;
        this.names = names;
        this.lastNames = lastNames;
        this.dni = dni;
        this.phone = phone;
        this.photo = photo;
        this.idAccount = idAccount;
        this.email = email;
        this.password = password;
        this.idAccountType = idAccountType;
    }
}
