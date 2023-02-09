package com.rivaldy.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private Long id;
    @Column(name = "name", length = 30)
    private String name;
    @Column(name = "description", length = 150)
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
