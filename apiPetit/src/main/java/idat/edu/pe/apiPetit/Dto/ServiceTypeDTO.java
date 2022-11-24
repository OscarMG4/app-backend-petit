package idat.edu.pe.apiPetit.Dto;


import javax.validation.constraints.NotEmpty;

public class ServiceTypeDTO {

    private Integer id;
    @NotEmpty(message = "El campo tipo de servicio es obligatorio!")
    private String serviceType;
    public ServiceTypeDTO() {
    }

    public ServiceTypeDTO(Integer id, String serviceType) {
        this.id = id;
        this.serviceType = serviceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

}
