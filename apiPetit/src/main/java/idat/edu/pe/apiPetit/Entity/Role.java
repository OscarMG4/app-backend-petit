package idat.edu.pe.apiPetit.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRole;
    @Column(name = "role", nullable = false, unique = true, length = 15)
    @NotBlank
    private String role;
    @ManyToOne
    @JoinColumn(
            name="id_account",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_account) references accounts(id_account)"))
    private Account account;

    public Role() {
    }

    public Role(Integer idRole, String role, Account account) {
        this.idRole = idRole;
        this.role = role;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
