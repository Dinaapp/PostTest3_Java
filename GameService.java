/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import models.Game;
import java.util.ArrayList;
/**
 *
 * @author Dina Putri
 */
public class GameService {
    private ArrayList<Game> daftarGame;
    private int nextId;
    
    public GameService() {
        this.daftarGame = new ArrayList<>();
        this.nextId = 1;
        
        Game ml = new Game (nextId++, "Mobile Legends");
        ml.addTopUp("50 Diamond = Rp20.000");
        ml.addTopUp("150 Diamond = Rp55.000");
        ml.addTopUp("500 Diamond = Rp250.000");
        daftarGame.add(ml);
        
        Game gi = new Game (nextId++, "Genshin Impact");
        gi.addTopUp("80 Genesis Crystal = Rp20.000");
        gi.addTopUp("300 Genesis Crystal = Rp260.000");
        gi.addTopUp("980 Genesis Crystal = Rp899.000");
        daftarGame.add(gi);
        
        Game rx = new Game (nextId++, "Roblox");
        rx.addTopUp("80 Robux = Rp15.000");
        rx.addTopUp("400 Robux = Rp60.000");
        rx.addTopUp("800 Robux = Rp120.000");
        daftarGame.add(rx);
        
        Game vt = new Game (nextId++, "Valorant");
        vt.addTopUp("475 VP = Rp50.000");
        vt.addTopUp("1000 VP = Rp95.000");
        vt.addTopUp("2050 VP = Rp190.000");
        daftarGame.add(vt);
    }
    
    public boolean tambahGame(String nama) {
        for (Game g : daftarGame) {
            if (g.getNama().equalsIgnoreCase(nama)) {
                return false;
            }
        }
        daftarGame.add(new Game(nextId++, nama));
        return true;
    }
    
    public boolean tambahTopUp(int gameId, String listTopUp) {
        Game game = cariGame(gameId);
        if (game != null) {
            return game.addTopUp(listTopUp);
        }
        return false;
    }
    
    public boolean updateGame(int gameId, String namaBaru) {
        Game game = cariGame(gameId);
        if (game != null) {
            for (Game g : daftarGame) {
                if(g.getNama().equalsIgnoreCase(namaBaru)) {
                    return false;
                }
            }
            game.setNama(namaBaru);
            return true;
        }
        return false;
    }
    
    public boolean hapusGame(int gameId) {
        Game game = cariGame(gameId);
        if (game != null) {
            daftarGame.remove(game);
            return true;
        }
        return false;
    }
    public Game cariGame(int id) {
        for (Game g : daftarGame) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }
    
    public ArrayList<Game> cariGame(String keyword) {
        ArrayList<Game> hasil = new ArrayList<>();
        for (Game g : daftarGame) {
            if (g.getNama().toLowerCase().contains(keyword.toLowerCase())) {
                hasil.add(g);
            }
        }
        return hasil;
    }
    
    public ArrayList<Game> semuaGame() {
        return daftarGame;
    }
    
    public void tampilkanDaftarGame() {
        if (daftarGame.isEmpty()) {
            System.out.println("Belum ada game tersedia.");
        } else {
            System.out.println("  DAFTAR GAME   ");
            for (Game g : daftarGame) {
                System.out.println(g.getId() + ". " + g.getNama());
                for (String t : g.getTopUp()) {
                    System.out.println("   - " + t);
                }
            }
        }
    }
}

