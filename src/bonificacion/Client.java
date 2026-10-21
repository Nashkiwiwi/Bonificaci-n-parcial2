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

    public void makeOrder(int orderId, LocalDate date) {
        orders.add(new Order(orderId, this, date));
    }

    public Order getOrder(int orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public void addProductToOrder(int orderId, Product product, int quantity) {
        Order order = getOrder(orderId);
        if (order != null) {
            order.addProduct(product, quantity);
        }
    }

    public void confirmOrder(int orderId) {
        Order order = getOrder(orderId);
        if (order != null) {
            order.confirm();
        }
    }

    public void receiveOrder(int orderId) {
        Order order = getOrder(orderId);
        if (order != null) {
            order.receive();
        }
    }

    public void cancelOrder(int orderId) {
        Order order = getOrder(orderId);
        if (order != null) {
            order.cancel();
        }
    }

    public int countOrders(Status status) {
        int count = 0;
        for (Order order : orders) {
            if (order.getStatus() == status) {
                count++;
            }
        }
        return count;
    }

    public double valueOrders(Status status) {
        double total = 0;
        for (Order order : orders) {
            if (order.getStatus() == status) {
                total += order.getTotal();
            }
        }
        return total;
    }

    public double spentSentDelivered() {
        return valueOrders(Status.SENT) + valueOrders(Status.DELIVERED);
    }

    // Ingreso generado por un producto en las ordenes SENT y DELIVERED de este cliente
    public double incomeOfProduct(Product product) {
        double total = 0;
        for (Order order : orders) {
            if (order.getStatus() == Status.SENT || order.getStatus() == Status.DELIVERED) {
                for (Element element : order.getProducts()) {
                    if (element.getProduct() == product) {
                        total += element.getSubtotal();
                    }
                }
            }
        }
        return total;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
