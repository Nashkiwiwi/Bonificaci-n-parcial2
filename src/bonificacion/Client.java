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
public class Client extends User {
    private ArrayList<Order> orders;

    public Client(int id, String name, String email, LocalDate registrationDate) {
        super(id, name, email, registrationDate);
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        if (order != null) {
            orders.add(order);
        }
    }

    public Order makeOrder(int id, LocalDate date) {
        Order order = new Order(id, this, date);
        addOrder(order);
        return order;
    }

    public void addProductToOrder(int orderId, Product product, int quantity) {
        Order order = getOrder(orderId);
        if (order != null) {
            order.addProduct(product, quantity);
        }
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public Order getOrder(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
    
    
}
