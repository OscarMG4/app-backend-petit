package idat.edu.pe.apiPetit.Dto;


public class UserDTO {

    private Integer id;
    private String names;
    private String lastNames;
    private String dni;
    private String phone;
    private Byte photo;
    
	public UserDTO() {
	}

	public UserDTO(Integer id, String names, String lastNames, String dni, String phone, Byte photo) {
		this.id = id;
		this.names = names;
		this.lastNames = lastNames;
		this.dni = dni;
		this.phone = phone;
		this.photo = photo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Byte getPhoto() {
		return photo;
	}

	public void setPhoto(Byte photo) {
		this.photo = photo;
	}
}
