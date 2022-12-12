package idat.edu.pe.apiPetit.Dto;

public class UbicacionDTO {
    private Integer idAdoption;
    private String cliente;
    private String name;
    private String latitude;
    private String length;

    public UbicacionDTO() {
    }

    public UbicacionDTO(Integer idAdoption, String cliente, String name, String latitude, String length) {
        this.idAdoption = idAdoption;
        this.cliente = cliente;
        this.name = name;
        this.latitude = latitude;
        this.length = length;
    }

    public Integer getIdAdoption() {
        return idAdoption;
    }

    public void setIdAdoption(Integer idAdoption) {
        this.idAdoption = idAdoption;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
