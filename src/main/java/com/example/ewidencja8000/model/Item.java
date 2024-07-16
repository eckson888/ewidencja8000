package com.example.ewidencja8000.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Item
{
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    private String serial;
    private String brand;
    private String model;
    private String storedAt;
    private String origin;
    private int quantity;
    private String imageURL;

    public Item(int id){
        this.id = id;
    }
}