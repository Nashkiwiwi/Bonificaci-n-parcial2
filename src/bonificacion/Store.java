/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bonificacion;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author kamelln
 */
public class Store {
    private String name;
    private LocalDate creationDate;
    private Seller owner;
    private ArrayList<Product> products;
 
    public Store(String name, LocalDate creationDate, Seller owner) {
        this.name = name;
        this.creationDate = creationDate;
        this.owner = owner;
        this.products = new ArrayList<>();
    }
 
    public void createProduct(String name, String description, double price, String category, int inventoryQuantity) {
        products.add(new Product(name, description, price, category, inventoryQuantity));
    }
 
    public Product getProduct(int index) {
        return products.get(index);
    }
 
    public ArrayList<Product> getProducts() {
        return products;
    }
 
    public String getName() {
        return name;
    }
 
    public LocalDate getCreationDate() {
        return creationDate;
    }
 
    public Seller getOwner() {
        return owner;
    }
}
 
