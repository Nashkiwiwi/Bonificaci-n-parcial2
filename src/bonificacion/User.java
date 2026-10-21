/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bonificacion;

import java.time.LocalDate;

/**
 *
 * @author kamelln
 */
public abstract class User {
    protected int id;
    protected String name;
    protected String email;
    protected LocalDate registrationDate;

    public User(int id, String name, String email, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    
}
