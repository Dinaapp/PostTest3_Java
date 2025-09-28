Nama: Rizky wahyu dina putri
NIM: 2409116111

Program Top Up Game adalah program CRUD yang mengelola daftar game beserta item Top Up. Pengguna dapat melihat daftar Game, mencari, menambahkan game baru, mengubah, dan menghapus data. Program juga dibuat menggunakan MVC dengan pemisahan packages agar lebih terstruktur dan sesuai dengan fungsi.

<img width="442" height="454" alt="image" src="https://github.com/user-attachments/assets/cd8ff955-5e5c-4e1f-81f8-ec3c1a7e155a" />

Terdapat 3 Package pada program top up game, pada package model terdapat penambahan class yaitu user, admin, customer, dan transaksi. Class user adalah class induk atau superclass, admin dan customer adalah class anak atau subclass dari user. Sedangkan transaksi adalah kelas tambahan untuk menu yang dibuat untuk Customer. Jadi pada program top up gam, terdapat dua pov menu program.

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

Method cariGame mencari data berdasarkan kata kunci yaitu nama gamenya, pencarian game disetting dengan menggunakan toLowerCase(). Method ini menerapkan overloading karena dua method dengan nama yang sama tetapi memiliki parameter yang berbeda yaitu cariGame(int id) untuk mencari game berdasarkan ID dan cariGame(String keyword) mencari game berdasarkan kata kunci nama game. 

Method tampilkanDaftarGame digunakan untuk menampilkan seluruuh data game beserta item top up. Jika list game kosong, maka menampilkan belum ada game tersedia.

<img width="514" height="308" alt="image" src="https://github.com/user-attachments/assets/96923096-8fe6-415a-b9f3-201cd7ce9cfe" />

<img width="1017" height="638" alt="image" src="https://github.com/user-attachments/assets/6090368e-7acc-450e-88c2-5af6b9d19097" />

<img width="1011" height="436" alt="image" src="https://github.com/user-attachments/assets/b000b4a5-4e55-45d7-aa13-e392dae74245" />

<img width="993" height="261" alt="image" src="https://github.com/user-attachments/assets/374b1297-a2a0-42ec-b8ce-956cc351f61f" />

<img width="911" height="869" alt="image" src="https://github.com/user-attachments/assets/e2402c24-612e-44c4-a122-762bc8feb7d5" />

<img width="920" height="577" alt="image" src="https://github.com/user-attachments/assets/282d1890-5943-47e7-bc16-351234ddb069" />

<img width="1364" height="868" alt="image" src="https://github.com/user-attachments/assets/bef576ba-b640-4190-a656-35ea86721640" />

<img width="1102" height="502" alt="image" src="https://github.com/user-attachments/assets/2b2773f3-236d-4006-a964-3d3492d66b27" />

Di sini ada tiga class utama, User, Admin, dan Customer. Pertama, class User dijadikan abstract karena sifatnya umum dan nantinya bakal diturunkan ke Admin dan Customer. Class ini punya atribut username, password, dan service (objek dari GameService). Di dalamnya ada constructor buat inisialisasi data, lalu ada getter untuk ambil username dan service. Karena abstract, dia juga punya method abstract tampilkanMenu() yang wajib menggunakan override di class anak. Sehingga Class ini telah menerapkan overriding.

Class Admin adalah turunan dari User. Di constructor-nya, class ini memanggil constructor induk pake super. Lalu tampilkanMenu() di override untuk diubah dengan menambahkan pilihan menu khusus admin, seperti lihat daftar game, cari game, tambah game baru, ubah nama game, hapus game, dan keluar.

Class Customer juga turunan dari user atau subclass nya, menu customer lebih simpel, yaitu lihat daftar game, beli top up, lihat riwayat transaksi, dan keluar. Salah satu pilihan menu di customer adalah bisa membeli/top up item game, saat program dijalankan akan menampilkan menu dan menampilkan daftar game di menu tertentu. saat customer membeli mereka diminta untuk masukin ID game, dicek apakah valid atau tidak. Jika valid maka ditampilkan pilihan item top up yang tersedia. Setelah item dipilih, ada konfirmasi pembelian, lalu customer juga diminta masukin ID akun (dengan validasi harus angka). Setelah itu user disuruh pilih metode pembayaran (kredit, virtual bank, transfer, atau e-wallet). Kalau semua valid, data pembelian disimpan sebagai objek Transaksi ke dalam riwayat, lalu ditampilkan struk.

method lihatRiwayat() di class Customer digunakan untuk menampilkan semua transaksi yang udah dilakukan customer. Jika masih kosong, muncul pesan "Belum ada transaksi". Kalau ada, setiap transaksi ditampilkan dengan struknya.
<img width="1324" height="495" alt="image" src="https://github.com/user-attachments/assets/f99c9ed2-de02-4836-8f38-d1bab986dfa4" />

<img width="1623" height="994" alt="image" src="https://github.com/user-attachments/assets/69e828cb-b84e-4e80-9cd3-67203ab4d508" />

CetakStruk menggunakan interface yang menjadikan CetakStruk ini adalah sebuah blueprint yang hanya berisi deklarasi method tanpa implementasi. Pada interface CetakStruk terdapat satu method abstrak void tampilkanStruk() yang artinya setiap class yang mengimplementasikan interface ini wajib menyediakan implementasi dari method tersebut.

Class Transaksi digunakan untuk menyimpan dan menampilkan data transaksi top up game. Pada saat objek transaksi dibuat, atribut game, item, ID akun, dan metode pembayaran akan diisi sesuai data yang dimasukkan, sedangkan atribut waktu akan otomatis mengambil data waktu saat transaksi berlangsung dengan real time. Class Transaksi menggunakan implements CetakStruk yang artinya kelas ini mengadopsi interface CetakStruk sehingga wajib menuliskan method tampilkanStruk. Pada class ini method tersebut digunakan untuk menampilkan struk saat transaksi berhasil oleh customer.

<img width="1057" height="617" alt="image" src="https://github.com/user-attachments/assets/63058ed6-661e-4e7f-8256-8136866641d7" />

<img width="1045" height="778" alt="image" src="https://github.com/user-attachments/assets/a186068d-12f5-402e-9ac4-1b9c5aae7577" />

<img width="1341" height="899" alt="image" src="https://github.com/user-attachments/assets/9d5f097e-2f63-4832-a51a-a18ac0edc1a1" />

<img width="1332" height="724" alt="image" src="https://github.com/user-attachments/assets/552e8ce7-def2-44d7-8fbf-f1fe02df1b6a" />

<img width="1098" height="712" alt="image" src="https://github.com/user-attachments/assets/01ac6343-10d1-4e18-8d7c-61c5596cd007" />

<img width="927" height="788" alt="image" src="https://github.com/user-attachments/assets/9ae39e9b-19f0-4b66-bd1b-fa85bbfa4dc0" />

<img width="1559" height="895" alt="image" src="https://github.com/user-attachments/assets/b1c09256-4c19-4054-b1a8-5aba60654c7d" />

Pada awal class main terdapat import kelas dari package lain lalu ArrayList untuk list game, dan Scanner buat input dari user. Programj ditambahkan menu login sebagai user admin dan customer, karena terdapat penambahan superclass dan subclass. Jika username dan password sesuai dengan data admin, maka user masuk sebagai Admin, jika user menginput username dan password random maka akan login sebnagai customer.

Bagi user yang login sebagai Admin, admin dapat melihat daftar game, mencari game berdasarkan kata kunci, menambahkan game baru, menambahkan item top up pada game tertentu, mengubah nama game, serta menghapus game. User yang login sebagai Customer memiliki menu berbeda. Customer dapat melihat daftar game yang tersedia, melakukan pembelian top up, serta melihat riwayat transaksi yang sudah dilakukan.


RUN PROGRAM

<img width="1001" height="396" alt="image" src="https://github.com/user-attachments/assets/728fba87-164c-413f-85a8-8e73201a2ab6" />
Menu top up game untuk user admin.
<img width="878" height="336" alt="image" src="https://github.com/user-attachments/assets/d696f3c1-ec3e-4888-a8ef-f1181c43e47e" />

<img width="1169" height="616" alt="image" src="https://github.com/user-attachments/assets/8a431a22-f214-490c-96d5-c53b08403848" />

<img width="1119" height="896" alt="image" src="https://github.com/user-attachments/assets/1d8d9c15-6e91-4c03-8a83-94f6e97e245a" />

<img width="1085" height="671" alt="image" src="https://github.com/user-attachments/assets/7d345116-387d-42e2-8722-2ecc3c376fec" />

<img width="1395" height="692" alt="image" src="https://github.com/user-attachments/assets/0a204c88-4cbb-4a40-baba-e880f4aad5f5" />

menu top up game untuk customer









