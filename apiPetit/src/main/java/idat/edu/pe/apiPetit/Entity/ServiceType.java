package idat.edu.pe.apiPetit.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "services_types")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service_type")
    private Integer idServiceType;
    @Column(name = "service_type", nullable = false, length = 20, unique = true)
    @NotBlank
    private String serviceType;
    @OneToMany(mappedBy = "serviceType", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch= FetchType.EAGER)
    private List<Quote> quotes = new ArrayList<>();

    public ServiceType() {
    }

    public ServiceType(Integer idServiceType, String serviceType) {
        this.idServiceType = idServiceType;
        this.serviceType = serviceType;
    }

    public Integer getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(Integer idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
