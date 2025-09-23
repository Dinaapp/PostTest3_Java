/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Dina Putri
 */
public class Transaksi {
    private String game;
    private String item;
    private String idAkun;
    private String metode;
    private String waktu;

    public Transaksi(String game, String item, String idAkun, String metode) {
        this.game = game;
        this.item = item;
        this.idAkun = idAkun;
        this.metode = metode;
        this.waktu = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void tampilkanStruk() {
        System.out.println("-------------------------------");
        System.out.println("Struk Pembelian Top Up Game");
        System.out.println("Game    : " + game);
        System.out.println("Item    : " + item);
        System.out.println("ID Akun : " + idAkun);
        System.out.println("Metode  : " + metode);
        System.out.println("Waktu   : " + waktu);
        System.out.println("-------------------------------\n");
    }
}
