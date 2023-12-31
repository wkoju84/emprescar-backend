package br.com.emprescar.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date pickupDate;
    private Date dropoffDate;

    @ManyToOne
    Product product;

    @ManyToOne
    Customer customer;

    public Booking() {
    }

    public Booking(Integer id, Date pickupDate, Date dropoffDate, Product product, Customer customer) {
        this.id = id;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.product = product;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", pickupDate=" + pickupDate +
                ", dropoffDate=" + dropoffDate +
                ", product=" + product +
                ", customer=" + customer +
                '}';
    }
}
