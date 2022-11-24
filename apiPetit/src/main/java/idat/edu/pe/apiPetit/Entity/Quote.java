package idat.edu.pe.apiPetit.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuote;
    @Column(name = "date_issued", nullable = false)
    private LocalDateTime dateIssued;
    @Column(name = "date_attention", nullable = false, unique = true)
    private LocalDateTime dateAttention;
    @Column(name = "price", nullable = false)
    private Double price;
    @ManyToOne
    @JoinColumn(
            name="id_service_type",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_service_type) references services_types(id_service_type)"))
    private ServiceType serviceType;
    @ManyToOne
    @JoinColumn(
            name="id_user",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_user) references users(id_user)"))
    private User user;
    @ManyToOne
    @JoinColumn(
            name="id_state",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_state) references states(id_state)"))
    private State state;

    public Quote() {
    }

    public Quote(Integer idQuote, LocalDateTime dateIssued, LocalDateTime dateAttention, Double price, ServiceType serviceType, User user, State state) {
        this.idQuote = idQuote;
        this.dateIssued = dateIssued;
        this.dateAttention = dateAttention;
        this.price = price;
        this.serviceType = serviceType;
        this.user = user;
        this.state = state;
    }

    public Integer getIdQuote() {
        return idQuote;
    }

    public void setIdQuote(Integer idQuote) {
        this.idQuote = idQuote;
    }

    public LocalDateTime getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDateTime dateIssued) {
        this.dateIssued = dateIssued;
    }

    public LocalDateTime getDateAttention() {
        return dateAttention;
    }

    public void setDateAttention(LocalDateTime dateAttention) {
        this.dateAttention = dateAttention;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ServiceType getTypeService() {
        return serviceType;
    }

    public void setTypeService(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
