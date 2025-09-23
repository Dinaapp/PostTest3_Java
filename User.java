/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import service.GameService;
/**
 *
 * @author Dina Putri
 */
public abstract class User {
    protected String username;
    protected String password;
    protected GameService service;

    public User(String username, String password, GameService service) {
        this.username = username;
        this.password = password;
        this.service = service;
    }

    public String getUsername() { return username; }
    public GameService getService() { return service; }

    public abstract void tampilkanMenu();
}

    
