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
public class Admin extends User {
    public Admin(String username, String password, GameService service) {
        super(username, password, service);
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("\nMENU ADMIN CANTIK");
        System.out.println("1. Lihat Daftar Game");
        System.out.println("2. Cari Game");
        System.out.println("3. Tambah Game Baru");
        System.out.println("4. Tambah Daftar Top Up");
        System.out.println("5. Ubah Nama Game");
        System.out.println("6. Hapus Game");
        System.out.println("7. Keluar");
    }
}

