package idat.edu.pe.apiPetit.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "types_services")
public class TypeService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTypeService;
    @Column(name = "name", nullable = false, length = 20, unique = true)
    private String name;
    @OneToMany(mappedBy = "typeService", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Quote> quotes = new ArrayList<>();

    public TypeService() {
    }

    public TypeService(Integer idTypeService, String name) {
        this.idTypeService = idTypeService;
        this.name = name;
    }

    public Integer getIdTypeService() {
        return idTypeService;
    }

    public void setIdTypeService(Integer idTypeService) {
        this.idTypeService = idTypeService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
