package by.chertko.delivery.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "deliveries")
public class Delivery extends BaseEntity {
    @Column(name = "delivery_name", nullable = false)
    private String name;

    @Column(name = "delivery_description")
    private String description;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Task{" +
                "id: " + super.getId() + ", " +
                "name: " + name + "}";
    }
}
