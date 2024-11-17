package vn.haui.laptopshop.domain;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;
    private String status;

    private long totalAmount;
    private Instant createdAt;

    public Order() {
    }

    @PrePersist
    @PreUpdate
    public void handleBeforeSave() {
        this.totalAmount = calculateTotalAmount();
        this.createdAt = Instant.now();
    }

    private long calculateTotalAmount() {
        if (orderDetails == null) {
            return 0;
        }
        return orderDetails.stream()
                .mapToLong(OrderDetail::getQuantity) // Giả sử OrderDetail có thuộc tính quantity
                .sum();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Order(long id, double totalPrice, User user, List<OrderDetail> orderDetails, String receiverName,
            String receiverAddress, String receiverPhone, String status, long totalAmount, Instant createdAt) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.user = user;
        this.orderDetails = orderDetails;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverPhone = receiverPhone;
        this.status = status;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", totalPrice=" + totalPrice + ", user=" + user + ", orderDetails=" + orderDetails
                + ", receiverName=" + receiverName + ", receiverAddress=" + receiverAddress + ", receiverPhone="
                + receiverPhone + ", status=" + status + ", totalAmount=" + totalAmount + ", createdAt=" + createdAt
                + "]";
    }

}
