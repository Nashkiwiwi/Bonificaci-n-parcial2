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
public class MarketHub {
    private ArrayList<User> users;
    private ArrayList<Store> stores;

    public MarketHub() {
        this.users = new ArrayList<>();
        this.stores = new ArrayList<>();
    }

    public void addUser(User user) {
        if (user != null) {
            users.add(user);
        }
    }

    public void addStore(Store store) {
        if (store != null) {
            stores.add(store);
        }
    }

    // Crea la tienda, se la asigna al vendedor y la registra en el hub
    public Store createStore(String name, LocalDate creationDate, Seller owner) {
        if (owner == null) {
            return null;
        }
        Store store = new Store(name, creationDate, owner);
        owner.setStore(store);
        addStore(store);
        return store;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    // Busqueda por indice
    public Store getStore(int index) {
        if (index >= 0 && index < stores.size()) {
            return stores.get(index);
        }
        return null;
    }

    // Busqueda por nombre
    public Store getStore(String name) {
        for (Store store : stores) {
            if (store.getName().equals(name)) {
                return store;
            }
        }
        return null;
    }

    // Busqueda por identificador
    public Client getClient(int id) {
        for (User user : users) {
            if (user instanceof Client && user.getId() == id) {
                return (Client) user;
            }
        }
        return null;
    }

    // Busqueda por identificador
    public Seller getSeller(int id) {
        for (User user : users) {
            if (user instanceof Seller && user.getId() == id) {
                return (Seller) user;
            }
        }
        return null;
    }
    
    
}
