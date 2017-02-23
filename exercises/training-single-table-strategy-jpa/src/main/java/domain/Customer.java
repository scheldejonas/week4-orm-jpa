package domain;

import javax.persistence.*;

/**
 * Created by scheldejonas on 22/02/2017.
 */
@Entity
@Table(name = "CUSTOMER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PRICE")
    private int price;
    @Column(name = "FIRST_NAME")
    private String firstName;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
