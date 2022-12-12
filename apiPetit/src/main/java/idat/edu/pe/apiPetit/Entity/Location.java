package idat.edu.pe.apiPetit.Entity;

import javax.persistence.*;

@Entity
@Table(name = "locationes")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String latitude;
    private String length;

    @ManyToOne
    @JoinColumn(
            name = "id_user",
            nullable = false,
            unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_user) references users(id_user)")
    )
    private User user;

    public Location() {

    }

    public Location(Integer id, String latitude, String length, User user) {
        this.id = id;
        this.latitude = latitude;
        this.length = length;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
