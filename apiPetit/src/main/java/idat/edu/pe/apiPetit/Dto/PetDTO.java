package idat.edu.pe.apiPetit.Dto;

import javax.validation.constraints.NotEmpty;

public class PetDTO {
    private Integer id;
    @NotEmpty(message = "El campo nombre es obligatorio!")
    private String name;
    @NotEmpty(message = "El campo sexo es obligatorio!")
    private String sex;
    @NotEmpty(message = "El campo raza es obligatorio!")
    private String race;
    @NotEmpty(message = "El campo edad es obligatorio!")
    private String age;
    private byte[] photo;

    public PetDTO() {
    }

    public PetDTO(Integer id, String name, String sex, String race, String age, byte[] photo) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.age = age;
        this.photo = photo;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

}
