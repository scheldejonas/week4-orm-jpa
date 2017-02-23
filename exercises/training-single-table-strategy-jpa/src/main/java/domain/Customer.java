package domain;

import javax.persistence.*;

/**
 * Created by scheldejonas on 22/02/2017.
 */
@Entity
@Table(name = "Customer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price")
    private int price;

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

}
