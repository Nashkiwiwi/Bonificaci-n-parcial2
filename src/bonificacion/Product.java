/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bonificacion;

/**
 *
 * @author kamelln
 */
public class Product {
    private String name;
    private String description;
    private float price;
    private String category;
    private int inventoryQuantity;

    public Product(String name, String description, double price, String category, int inventoryQuantity) {
        this.name = name;
        this.description = description;
        this.price = (float) price;
        this.category = category;
        this.inventoryQuantity = inventoryQuantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }
}
