/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bonificacion;
import java.time.LocalDate;
import java.util.*;

public class Order {
    private int id;
    private Client client;
    private LocalDate date;
    private Status status;
    private ArrayList<Element> products;
 
    public Order(int id, Client client, LocalDate date) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.status = Status.PENDING;
        this.products = new ArrayList<>();
    }
 
    public int getId() {
        return id;
    }
 
    public Client getClient() {
        return client;
    }
 
    public LocalDate getDate() {
        return date;
    }
 
    public Status getStatus() {
        return status;
    }
 
    public ArrayList<Element> getProducts() {
        return products;
    }
 
    public void addProduct(Product product, int quantity) {
        if (status == Status.PENDING) {
            products.add(new Element(product, quantity));
        }
    }
 
    public boolean isValid() {
        for (Element element : products) {
            if (!element.getProduct().hasStock(element.getQuantity())) {
                return false;
            }
        }
        return true;
    }
 
    public void confirm() {
        if (status == Status.PENDING) {
            for (Element element : products) {
                element.getProduct().decreaseStock(element.getQuantity());
            }
            status = Status.SENT;
        }
    }
 
    public void receive() {
        if (status == Status.SENT) {
            status = Status.DELIVERED;
        }
    }
 
    public void cancel() {
        if (status == Status.PENDING) {
            status = Status.CANCELED;
        } else if (status == Status.SENT) {
            for (Element element : products) {
                element.getProduct().increaseStock(element.getQuantity());
            }
            status = Status.CANCELED;
        }
    }
 
    public double getTotal() {
        double total = 0;
        for (Element element : products) {
            total += element.getSubtotal();
        }
        return total;
    }
}