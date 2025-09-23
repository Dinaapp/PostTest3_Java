/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.ArrayList;
/**
 *
 * @author Dina Putri
 */
public class Game {
    private int id;
    private String nama;
    private ArrayList<String> topUp;
    
    public Game(int id, String nama) {
        this.id = id;
        this.nama = nama;
        this.topUp = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public ArrayList<String> getTopUp() {
        return topUp;
    }

    public boolean addTopUp(String item) {
        if (topUp.contains(item)) {
            return false;
        }
        topUp.add(item);
        return true;
}
}