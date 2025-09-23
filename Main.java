/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import models.Game;
import service.GameService;
import java.util.ArrayList;
import java.util.Scanner;
import models.User;
import models.Admin;
import models.Customer;
/**
 *
 * @author Dina Putri
 */
public class Main {
    public static void main(String[] args) {
        GameService service = new GameService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("SELAMAT DATANG DI TOP UP GAME BY DINAP");
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        User user;
        if (username.equals("admin") && password.equals("123")) {
            user = new Admin("admin", "123", service);
            System.out.println("Login sebagai ADMIN berhasil!");
        } else {
            user = new Customer(username, password, service);
            System.out.println("Selamat datang, " + username);
        }

        int pilihan = 0;

        if (user instanceof Admin admin) {
            do {
                admin.tampilkanMenu();
                System.out.print("Pilih menu: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Input Harus Berupa Angka!");
                    scanner.nextLine();
                    continue;
                }
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                case 1:
                    service.tampilkanDaftarGame(); 
                    break;                   

                case 2:
                    System.out.print("Masukkan Nama Game: ");
                    String keyword = scanner.nextLine().trim();
                    if (keyword.isEmpty() || !keyword.matches("[a-zA-Z0-9\\s\\-_=,.Rp]+")) {
                        System.out.println("Input Tidak Diperbolehkan!");
                        break;
                    }
                    ArrayList<Game> hasil = service.cariGame(keyword);
                    if (hasil.isEmpty()) {
                        System.out.println("Game tidak ditemukan.");
                    } else {
                        for (Game g : hasil) {
                            System.out.println(g.getId() + ". " + g.getNama());
                            for (String t : g.getTopUp()) {
                                System.out.println("   - " + t);
                            }
                        }
                    }
                    break;
                    
                case 3:
                    System.out.print("Masukkan Nama Game Baru: ");
                    String namaGame = scanner.nextLine();
                    if (namaGame.trim().isEmpty() || !namaGame.matches("[a-zA-Z0-9\\s\\-_=,.Rp]+")) { 
                        System.out.println("Input Tidak Diperbolehkan!");
                        break;
                    }
                    if (service.tambahGame(namaGame.trim())) {
                        System.out.println("Game Berhasil Ditambahkan!");
                    } else {
                        System.out.println("Game Sudah Ada, Gagal Menambahkan!");
                    }
                    break;
                    
                case 4:
                    service.tampilkanDaftarGame(); 
                    System.out.print("Masukkan ID Game: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("ID Harus Angka!");
                        scanner.nextLine();
                        break;
                    }
                    int idTop = scanner.nextInt();
                    scanner.nextLine();
                    if (service.cariGame(idTop) == null) {
                        System.out.println("Game tidak ditemukan!");
                        break;
                    }
                    System.out.print("Masukkan Item Top Up: ");
                    String varian = scanner.nextLine();
                    if (varian.trim().isEmpty() || !varian.matches("[a-zA-Z0-9\\s\\-_=,.Rp]+")) { 
                        System.out.println("Input tidak Diterima!");
                        break;
                    }
                    if (service.tambahTopUp(idTop, varian.trim())) {
                        System.out.println("Item berhasil ditambahkan!");
                    } else {
                        System.out.println("Item sudah ada atau game tidak ditemukan!");
                    }
                    break;
                    
                case 5:
                    service.tampilkanDaftarGame(); 
                    System.out.print("Masukkan ID Game: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("ID Harus Angka! ");
                        scanner.nextLine();
                        break;
                    }
                    int idUbah = scanner.nextInt();
                    scanner.nextLine();
                    if (service.cariGame(idUbah) == null) { 
                        System.out.println("Game Tidak Ditemukan!");
                        break;
                    }
                    System.out.print("Masukkan Nama Baru: ");
                    String newNama = scanner.nextLine().trim();
                    if (newNama.isEmpty() || !newNama.matches("[a-zA-Z0-9\\s\\-_=,.Rp]+")) { 
                        System.out.println("Input tidak diperbolehkan!");
                        break;
                    }
                    if (service.updateGame(idUbah, newNama)) {
                        System.out.println("Nama Game Berhasil Diubah!");
                    } else {
                        System.out.println("Nama Sudah Ada Atau Game Tidak Ditemukan!");
                    }
                    break;

                case 6:
                    service.tampilkanDaftarGame(); 
                    System.out.print("Masukkan ID Game: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("ID Harus Angka!");
                        scanner.nextLine();
                        break;
                    }
                    int idHapus = scanner.nextInt();
                    scanner.nextLine();
                    if (service.cariGame(idHapus) == null) { 
                        System.out.println("Game Tidak Ditemukan!");
                        break;
                    }
                    if (service.hapusGame(idHapus)) {
                        System.out.println("Game Berhasil Dihapus!");
                    }
                    break;
                
                case 7:
                    System.out.println("Terima Kasih, Top Up Done, Game On!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 7);

        scanner.close();
        
    } else if (user instanceof Customer pembeli) {
        do {
            pembeli.tampilkanMenu();
            System.out.print("Pilih menu: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input Harus Berupa Angka!");
                scanner.nextLine();
                continue;
            }
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    service.tampilkanDaftarGame(); 
                    break;
                case 2:
                    pembeli.beliTopUp(scanner);
                    break;
                case 3:
                    pembeli.lihatRiwayat();
                    break;
                case 4:
                    System.out.println("Terima kasih sudah berbelanja!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 4);
    }

    scanner.close();
}
}