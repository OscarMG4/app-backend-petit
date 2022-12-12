package idat.edu.pe.apiPetit.Dto;

import idat.edu.pe.apiPetit.Entity.User;

public class LocalizationDTO {
    private Integer id;
    private String latitude;
    private String length;

    public LocalizationDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
