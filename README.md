Nama: Rizky wahyu dina putri
NIM: 2409116111

<img width="444" height="422" alt="image" src="https://github.com/user-attachments/assets/7c7c2788-350a-4bc7-894f-69cee535579e" />

<img width="960" height="437" alt="image" src="https://github.com/user-attachments/assets/18e5e10f-a22f-48c2-b62b-d8ca1d2d8fc6" />

<img width="974" height="667" alt="image" src="https://github.com/user-attachments/assets/5e0deaa0-0df4-4b2f-8dc0-543ec6b7d880" />

Program Game pada packages model dibuat dengan menggunakan access modifier private untuk atribut/properti id, nama, dan top up, sehingga hanya bisa diakses melalui method getter dan setter. Constructor Game digunakan untuk menginialisasi objek Game dengan id dan nama, serta membuat ArrayList untuk list kosong item top up. Getter dan setter digunakan untuk memberikan akses terbatas terhadap atribut/properti.

Method addTopUp digunakan untuk menambahkan item Top Up ke dalam game, namun apabila item yang diinputkan telah ada pada Arraylist maka akan ditolak (return false).

<img width="488" height="437" alt="image" src="https://github.com/user-attachments/assets/459a9444-4f3a-490f-b657-49b570f8f2d3" />

<img width="929" height="859" alt="image" src="https://github.com/user-attachments/assets/be8737fc-d53e-4e15-9d4b-39ea25c91543" />

<img width="928" height="839" alt="image" src="https://github.com/user-attachments/assets/0f79f3cd-6a27-4bca-904d-cfaae6113fa4" />

<img width="920" height="517" alt="image" src="https://github.com/user-attachments/assets/de0de174-8433-48d9-a297-9d0010d5bff0" />

Pada bagian awal atribut daftarGame menyimpan seluruh data game dalam bentuk list. Atribut next id digunakan untuk memberikan nomor id otomatis (auto increment) saat pengguna menambahkan game baru, jadi tidak dibuat manual. Pada constructor, membuat data default yang disimpan di arraylist agar saat program pertama dijalankan, daftar game tidak kosong danmenampilkan game beserta item top up masing-masing.

Method tambahGame digunakan untuk menambahkan data game baru pada proses CRUD. Method ini mengecek terlbih dahulu apakah nama game yang diinputkan oleh pengguna sudah ada di dalam list atau belum, jika sudah maka gagal menambahkan game karena nama game sudah ada.

Method tambahTopUp digunakan untuk menambahkan item top up baru ke dalam game, termasuk ke game yang baru ditambahkan melalui input pengguna. Mmeiliki proses yang sama seperti tambahGame, jika item top up sudah tersedia maka gagal menambahkan karena item sudah tersedia.

Method updateGame digunakan untuk mengubah nama game yang ada di list, dengan menginput game sesuai id. Apabila id game seuai maka pengguna dapat memasukkan nama game baru.

Method hapusGame digunakan untujk menghapus game berdasarkan id, jika data ditemukan, game akan dihapus dari list beserta item top upnya.

Method cariGame mencari data berdasarkan kata kunci yaitu nama gamenya, pencarian game disetting dengan menggunakan toLowerCase().

Method tampilkanDaftarGame digunakan untuk menampilkan seluruuh data game beserta item top up. Jika list game kosong, maka menampilkan belum ada game tersedia.

<img width="514" height="308" alt="image" src="https://github.com/user-attachments/assets/96923096-8fe6-415a-b9f3-201cd7ce9cfe" />

<img width="1017" height="638" alt="image" src="https://github.com/user-attachments/assets/6090368e-7acc-450e-88c2-5af6b9d19097" />

<img width="1011" height="436" alt="image" src="https://github.com/user-attachments/assets/b000b4a5-4e55-45d7-aa13-e392dae74245" />

<img width="993" height="261" alt="image" src="https://github.com/user-attachments/assets/374b1297-a2a0-42ec-b8ce-956cc351f61f" />

<img width="911" height="869" alt="image" src="https://github.com/user-attachments/assets/e2402c24-612e-44c4-a122-762bc8feb7d5" />

<img width="920" height="577" alt="image" src="https://github.com/user-attachments/assets/282d1890-5943-47e7-bc16-351234ddb069" />

<img width="905" height="853" alt="image" src="https://github.com/user-attachments/assets/b6fe17ae-51c3-42f4-a406-63023abb5049" />

<img width="917" height="296" alt="image" src="https://github.com/user-attachments/assets/455395f1-ffbf-49ab-b026-548c5f85f05a" />

Di sini ada tiga class utama, User, Admin, dan Customer. Pertama, class User dijadikan abstract karena sifatnya umum dan nantinya bakal diturunkan ke Admin dan Customer. Class ini punya atribut username, password, dan service (objek dari GameService). Di dalamnya ada constructor buat inisialisasi data, lalu ada getter untuk ambil username dan service. Karena abstract, dia juga punya method abstract tampilkanMenu() yang wajib menggunakan override di class anak.

Class Admin adalah turunan dari User. Di constructor-nya, class ini memanggil constructor induk pake super. Lalu tampilkanMenu() di override untuk diubah dengan menambahkan pilihan menu khusus admin, seperti lihat daftar game, cari game, tambah game baru, ubah nama game, hapus game, dan keluar.

Class Customer juga turunan dari user atau subclass nya, menu customer lebih simpel, yaitu lihat daftar game, beli top up, lihat riwayat transaksi, dan keluar. Salah satu pilihan menu di customer adalah bisa membeli/top up item game, saat program dijalankan akan menampilkan menu dan menampilkan daftar game di menu tertentu. saat customer membeli mereka diminta untuk masukin ID game, dicek apakah valid atau tidak. Jika valid maka ditampilkan pilihan item top up yang tersedia. Setelah item dipilih, ada konfirmasi pembelian, lalu customer juga diminta masukin ID akun (dengan validasi harus angka). Setelah itu user disuruh pilih metode pembayaran (kredit, virtual bank, transfer, atau e-wallet). Kalau semua valid, data pembelian disimpan sebagai objek Transaksi ke dalam riwayat, lalu ditampilkan struk.

method lihatRiwayat() di class Customer digunakan untuk menampilkan semua transaksi yang udah dilakukan customer. Jika masih kosong, muncul pesan "Belum ada transaksi". Kalau ada, setiap transaksi ditampilkan dengan struknya.

<img width="1359" height="896" alt="image" src="https://github.com/user-attachments/assets/991f3f80-b217-4903-bd04-947c04d2aaec" />

<img width="1057" height="617" alt="image" src="https://github.com/user-attachments/assets/63058ed6-661e-4e7f-8256-8136866641d7" />

<img width="1045" height="778" alt="image" src="https://github.com/user-attachments/assets/a186068d-12f5-402e-9ac4-1b9c5aae7577" />

<img width="1341" height="899" alt="image" src="https://github.com/user-attachments/assets/9d5f097e-2f63-4832-a51a-a18ac0edc1a1" />

<img width="1332" height="724" alt="image" src="https://github.com/user-attachments/assets/552e8ce7-def2-44d7-8fbf-f1fe02df1b6a" />

<img width="1098" height="712" alt="image" src="https://github.com/user-attachments/assets/01ac6343-10d1-4e18-8d7c-61c5596cd007" />

<img width="927" height="788" alt="image" src="https://github.com/user-attachments/assets/9ae39e9b-19f0-4b66-bd1b-fa85bbfa4dc0" />

<img width="1179" height="726" alt="image" src="https://github.com/user-attachments/assets/7c23b07c-2cd2-4366-afc0-07dabc21bd82" />

Pada awal class main terdapat import kelas dari package lain lalu ArrayList untuk list game, dan Scanner buat input dari user.












