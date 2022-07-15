package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
public class Order {
  private Long id;
  private LocalDate orderDate;
  private LocalDate deliveryDate;
  private String status;
  private Customer customer;
  private Set<Product> products;

  public Order(Long id, String orderDate, String deliveryDate, String status, Customer customer) {
    this.id = id;
    this.orderDate = LocalDate.parse(orderDate);
    this.deliveryDate = LocalDate.parse(deliveryDate);
    this.status = status;
    this.customer = customer;
    this.products = new HashSet<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(LocalDate orderDate) {
    this.orderDate = orderDate;
  }

  public LocalDate getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(LocalDate deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Set<Product> getProducts() {
    return products;
  }

  public void setProducts(Set<Product> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    return "Order{"
            + "id=" + id
            + ", orderDate=" + orderDate
            + ", deliveryDate=" + deliveryDate
            + ", status='" + status + '\''
            + ", customer=" + customer
            + ", products=" + products
            + '}';
  }
}
