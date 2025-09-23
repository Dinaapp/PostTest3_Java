/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import service.GameService;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Dina Putri
 */
public class Customer extends User{
    private ArrayList<Transaksi> riwayat;

    public Customer(String username, String password, GameService service) {
        super(username, password, service);
        this.riwayat = new ArrayList<>();
    }
    
    
    @Override
    public void tampilkanMenu() {
        System.out.println("\nMENU TOP UP GAME");
        System.out.println("1. Lihat Daftar Game");
        System.out.println("2. Beli Top Up");
        System.out.println("3. Lihat Riwayat Transaksi");
        System.out.println("4. Keluar");
    }

    public void beliTopUp(Scanner scanner) {
        service.tampilkanDaftarGame();
        System.out.print("Masukkan ID Game: ");
        if (!scanner.hasNextInt()) {
            System.out.println("ID harus angka!");
            scanner.nextLine();
            return;
        }
        int id = scanner.nextInt();
        scanner.nextLine();
        Game game = service.cariGame(id);
        if (game == null) {
            System.out.println("Game tidak ditemukan!");
            return;
        }

        System.out.println("Pilih item top up:");
        ArrayList<String> topup = game.getTopUp();
        if (topup.isEmpty()) {
            System.out.println("Belum ada item tersedia.");
            return;
        }
        for (int i = 0; i < topup.size(); i++) {
            System.out.println((i + 1) + ". " + topup.get(i));
        }

        System.out.print("Pilih nomor item: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Input harus angka!");
            scanner.nextLine();
            return;
        }
        int pilih = scanner.nextInt();
        scanner.nextLine();
        if (pilih < 1 || pilih > topup.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }
        String item = topup.get(pilih - 1);

        System.out.print("Apakah anda yakin membeli ini? (y/n): ");
        String konfirmasi = scanner.nextLine();
        if (!konfirmasi.equalsIgnoreCase("y")) {
            System.out.println("Pembelian dibatalkan.");
            return;
        }

        System.out.print("Masukkan ID akun: ");
        String idAkun = scanner.nextLine();
        if (!idAkun.matches("\\d+")) {
            System.out.println("ID akun harus angka!");
            return;
        }

        System.out.println("Pilih metode pembayaran:");
        System.out.println("1. Kredit");
        System.out.println("2. Virtual Bank");
        System.out.println("3. Transfer Bank");
        System.out.println("4. E-Wallet");
        String metode = "";
        if (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            scanner.nextLine();
            switch (i) {
                case 1:
                    metode = "Kredit";
                    break;
                case 2:
                    metode = "Virtual Bank";
                    break;
                case 3:
                    metode = "Transfer Bank";
                    break;
                case 4:
                    metode = "E-Wallet";
                    break;
                default:
                    System.out.println("Metode pembayaran tidak valid!");    
                }

            } else {
                System.out.println("Input harus angka!");
                scanner.nextLine();
                return;
        }

        Transaksi trx = new Transaksi(game.getNama(), item, idAkun, metode);
        riwayat.add(trx);

        System.out.println("\n STRUK PEMBELIAN  ");
        trx.tampilkanStruk();
    }

    public void lihatRiwayat() {
        if (riwayat.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (Transaksi t : riwayat) {
                t.tampilkanStruk();
            }
        }
    }
}
