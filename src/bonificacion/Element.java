/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bonificacion;

/**
 *
 * @author kamelln
 */
public class Element {
    private Product product;
    private int quantity;
    private float price;

    public Element(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        // El precio del elemento es el precio del producto al momento de la compra
        this.price = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }
    
    public double getSubtotal() {
        return price * quantity;
    }
}
