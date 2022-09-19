package com.orderapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="Items")
@Table(name="Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Integer itemId;

//    @NotBlank(message = "Name  cannot be blank")
//    @Column(nullable = false)
    private String name;

//    @NotBlank(message = "Price  cannot be blank")
//    @Column(nullable = false)
    private Double price;

//    @JsonBackReference(value = "oders-items")
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Set<Orders> orders = new HashSet<>();

    //    @JsonBackReference(value = "customers-orders")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "order_id_fk"), nullable = true)
    private Orders order;
}
