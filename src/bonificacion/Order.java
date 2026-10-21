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
    private Status status=Status.PENDING;
    private List<Element> products=new ArrayList<>();
    
    public Order(int id, Client client, LocalDate date){
        this.id=id; 
        this.client=client; 
        this.date=date;
    }
    public int getId(){
        return id;
    }
    public Client getClient(){
        return client;
    }
    public LocalDate getDate(){
        return date;
    }
    public Status getStatus(){
        return status;
    }
    public List<Element> getProducts(){return Collections.unmodifiableList(products);}
    public boolean addProduct(Product product, int quantity) {
        if(status!=Status.PENDING || product==null || quantity<=0) return false;
        for(Element e:products) if(e.getProduct()==product) return false;
        products.add(new Element(product,quantity)); return true;
    }
    public double getTotal(){double total=0; for(Element e:products) total+=e.getTotal(); return total;}
    public boolean confirm(){
        if(status!=Status.PENDING || products.isEmpty()) return false;
        for(Element e:products) if(!e.getProduct().hasStock(e.getQuantity())) return false;
        for(Element e:products) e.getProduct().decreaseStock(e.getQuantity());
        status=Status.SENT; return true;
    }
    public boolean receive(){if(status!=Status.SENT) return false; status=Status.DELIVERED; return true;}
    public boolean cancel(){
        if(status==Status.CANCELED || status==Status.DELIVERED) return false;
        if(status==Status.SENT) for(Element e:products) e.getProduct().increaseStock(e.getQuantity());
        status=Status.CANCELED; return true;
    }
}
