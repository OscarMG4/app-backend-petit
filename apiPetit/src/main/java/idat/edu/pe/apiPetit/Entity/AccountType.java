package idat.edu.pe.apiPetit.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts_types")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAccountType;
    @Column(name = "account_type", nullable = false, unique = true)
    @NotBlank
    private String accountType;
    @OneToMany(mappedBy = "accountType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Account> accounts = new ArrayList<>();

    public AccountType() {
    }

    public AccountType(Integer idAccountType, String accountType) {
        this.idAccountType = idAccountType;
        this.accountType = accountType;
    }

    public Integer getIdAccountType() {
        return idAccountType;
    }

    public void setIdAccountType(Integer idAccountType) {
        this.idAccountType = idAccountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
