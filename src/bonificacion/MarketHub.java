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

    public Store getStore(int index) {
        if (index >= 0 && index < stores.size()) {
            return stores.get(index);
        }
        return null;
    }

    public Store getStore(String name) {
        for (Store store : stores) {
            if (store.getName().equals(name)) {
                return store;
            }
        }
        return null;
    }

    public Client getClient(int id) {
        for (User user : users) {
            if ( user.getId() == id) {
                return (Client) user;
            }
        }
        return null;
    }

    public Seller getSeller(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return (Seller) user;
            }
        }
        return null;
    }
    
    public void storeSummary() {
        System.out.println("Store summary:");
        for (Store store : stores) {
            System.out.println("- " + store.getName());
            System.out.println("  - Owner name: " + store.getOwner().getName());
            System.out.println("  - Owner contact email: " + store.getOwner().getEmail());
            System.out.println("  - Created at: " + store.getCreationDate());
            System.out.println("  - Product inventory:");
            for (Product product : store.getProducts()) {
                System.out.println("    - " + product.getName() + " stock: " + product.getInventoryQuantity());
            }
        }
        System.out.println();
    }

    public void clientOrderSummary() {
        System.out.println("Client order summary:");
        for (User user : users) {
            if (user instanceof Client) {
                Client client = (Client) user;
                System.out.println("- " + client.getName());
                for (Status status : Status.values()) {
                    System.out.println("  - " + status + " orders: " + client.countOrders(status));
                    System.out.println("  - " + status + " value: $"
                            + String.format("%.2f", client.valueOrders(status)));
                }
            }
        }
        System.out.println();
    }

    public Product getProductHighestIncome() {
        Product best = null;
        double bestIncome = -1;
        for (Store store : stores) {
            for (Product product : store.getProducts()) {
                double income = 0;
                for (User user : users) {
                    if (user instanceof Client) {
                        income += ((Client) user).incomeOfProduct(product);
                    }
                }
                if (income > bestIncome) {
                    bestIncome = income;
                    best = product;
                }
            }
        }
        return best;
    }

    public Client getClientMostSpent() {
        Client best = null;
        double bestSpent = -1;
        for (User user : users) {
            if (user instanceof Client) {
                Client client = (Client) user;
                if (client.spentSentDelivered() > bestSpent) {
                    bestSpent = client.spentSentDelivered();
                    best = client;
                }
            }
        }
        return best;
    }
    
}
