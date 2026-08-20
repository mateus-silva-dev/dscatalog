package io.github.mateussilva.dscatalog.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;

@Entity
@Table(name = "tb_product")
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;

    private String imgUrl;


    public Product() { }

    public Product(String name, String description, Double price, String imgUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }


    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;

        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
