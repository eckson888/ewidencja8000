package com.example.ewidencja8000.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
    private String current;
    private String origin;
    private String responsible;
    //private int quantity;
    private String imageURL;

    public Item(int id){
        this.id = id;
    }


    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public Item copyOf()
    {
        Item newItem = new Item();
        newItem.setBrand(this.brand);
        newItem.setModel(this.model);
        newItem.setSerial(this.serial);
        newItem.setOrigin(this.origin);
        newItem.setCurrent(this.current);
        newItem.setResponsible(this.responsible);
//        newItem.setQuantity(this.quantity);
        newItem.setImageURL(this.imageURL);
        return newItem;
    }
}