package idat.edu.pe.apiPetit.Entity;

import javax.persistence.*;

@Entity
@Table(name = "adoptions")
public class Adoption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdoption;
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @ManyToOne
    @JoinColumn(
            name="id_user",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_user) references users(id_user)"))
    private User user;
    @ManyToOne
    @JoinColumn(
            name="id_pet",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_pet) references pets(id_pet)"))
    private Pet pet;
    @ManyToOne
    @JoinColumn(
            name="id_state",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_state) references states(id_state)"))
    private State state;

    public Adoption() {
    }

    public Adoption(Integer idAdoption, String description, User user, Pet pet, State state) {
        this.idAdoption = idAdoption;
        this.description = description;
        this.user = user;
        this.pet = pet;
        this.state = state;
    }

    public Integer getIdAdoption() {
        return idAdoption;
    }

    public void setIdAdoption(Integer idAdoption) {
        this.idAdoption = idAdoption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
