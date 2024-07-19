package org.example.springmvcacademy.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.springmvcacademy.utility.core_entity.CoreEntity;


@Entity
@Table(name = "academy-phones")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Phone extends CoreEntity {
    String brand;
    String name;
    String memory;
    String color;
    Double price;
}
