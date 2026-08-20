package io.github.mateussilva.dscatalog.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;

@Entity
@Table(name = "tb_category")
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public Category() { }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Category category)) return false;

        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
