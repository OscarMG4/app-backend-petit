package idat.edu.pe.apiPetit.Dto;

import javax.validation.constraints.NotEmpty;

public class UserDTO {

	private Integer id;
	@NotEmpty(message = "El campo nombres es obligatorio!")
    private String names;
	@NotEmpty(message = "El campo apellidos es obligatorio!")
    private String lastNames;
	@NotEmpty(message = "El campo dni es obligatorio!")
    private String dni;
	@NotEmpty(message = "El campo celular es obligatorio!")
    private String phone;
    private byte[] photo;
    
	public UserDTO() {
	}

	public UserDTO(Integer id, String names, String lastNames, String dni, String phone, byte[] photo) {
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
