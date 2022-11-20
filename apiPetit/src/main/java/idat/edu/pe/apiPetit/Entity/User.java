package idat.edu.pe.apiPetit.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    @Column(name = "names", nullable = false, length = 40)
	@NotBlank
    private String names;
    @Column(name = "lastNames", nullable = false, length = 40)
	@NotBlank
    private String lastNames;
    @Column(name = "dni", nullable = false, length = 8, unique = true)
	@NotBlank
    private String dni;
    @Column(name = "phone", nullable = false, length = 9)
	@NotBlank
    private String phone;
    @Column(name = "photo", nullable = false, length = 100000)
    private byte[] photo;
	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<Account> accounts = new ArrayList<>();
	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<Adoption> adoptions = new ArrayList<>();
	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<Quote> quotes = new ArrayList<>();

	public User() {
	}

	public User(Integer idUser, String names, String lastNames, String dni, String phone, byte[] photo) {
		this.idUser = idUser;
		this.names = names;
		this.lastNames = lastNames;
		this.dni = dni;
		this.phone = phone;
		this.photo = photo;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
