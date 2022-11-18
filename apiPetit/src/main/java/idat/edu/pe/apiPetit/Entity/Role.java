package idat.edu.pe.apiPetit.Entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRole;
    @Column(name = "role", nullable = false, unique = true, length = 15)
    private String role;

    public Role() {
    }

    public Role(Integer idRole, String role) {
        this.idRole = idRole;
        this.role = role;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
