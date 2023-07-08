/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.math.BigDecimal;
/**
 *
 * @author nkhan
 */
public class Items {
    public String id;
    public String ownner_id;
    public BigDecimal current_price;
    public BigDecimal initial_price;
    public String item_name;
    public String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnner_id() {
        return ownner_id;
    }

    public void setOwnner_id(String ownner_id) {
        this.ownner_id = ownner_id;
    }

    public BigDecimal getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(BigDecimal current_price) {
        this.current_price = current_price;
    }

    public BigDecimal getInitial_price() {
        return initial_price;
    }

    public void setInitial_price(BigDecimal initial_price) {
        this.initial_price = initial_price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Items(String id, String ownner_id, BigDecimal current_price, BigDecimal initial_price, String item_name, String description) {
        this.id = id;
        this.ownner_id = ownner_id;
        this.current_price = current_price;
        this.initial_price = initial_price;
        this.item_name = item_name;
        this.description = description;
    }
    
    public Items(){}

    @Override
    public String toString() {
        return "Items{" + "id=" + id + ", ownner_id=" + ownner_id + ", current_price=" + current_price + ", initial_price=" + initial_price + ", item_name=" + item_name + ", description=" + description + '}';
    }
}
