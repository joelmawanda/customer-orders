package com.orderapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "orders")
@Table(name = "orders")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Integer ordersId;

//    @NotBlank(message = "orderNumber  cannot be blank")
//    @Column(nullable = false)
    private String orderNumber;

    @CreationTimestamp
    private Date orderDate;

//    @NotBlank(message = "Quantity  cannot be blank")
//    @Column(nullable = false)
    private Integer quantity;

//    @NotBlank(message = "Total amount  cannot be blank")
//    @Column(nullable = false)
    private Double totalAmount;

//    @NotBlank(message = "Discount  cannot be blank")
//    @Column(nullable = false)
    private Boolean discount;

    //@JsonBackReference(value = "shareholder-tax-rate")
//    @OneToOne(fetch = FetchType.EAGER, optional = true)
//    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "item_id_fk"), nullable = true)
//    private Item item;

//    @JsonBackReference(value = "customers-orders")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "customer_id_fk"), nullable = true)
    private Customer customer;

}
