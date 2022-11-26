package idat.edu.pe.apiPetit.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAccount;
    @Column(name = "email", nullable = false, length = 50, unique = true)
    @NotBlank
    private String email;
    @Column(name = "pass", nullable = false)
    @NotBlank
    private String pass;
    @ManyToOne
    @JoinColumn(
            name="id_account_type",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_account_type) references accounts_types(id_account_type)"))
    private AccountType accountType;
    @ManyToOne
    @JoinColumn(
            name="id_user",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_user) references users(id_user)"))
    private User user;
    @OneToMany(mappedBy = "account", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch= FetchType.EAGER)
    private List<Role> roles  = new ArrayList<>();

    public Account() {
    }

    public Account(Integer idAccount, String email, String pass, AccountType accountType, User user) {
        this.idAccount = idAccount;
        this.email = email;
        this.pass = pass;
        this.accountType = accountType;
        this.user = user;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
