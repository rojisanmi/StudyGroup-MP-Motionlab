1. Penjelasan fitur
- Halaman Login:
  -> Terdapat dua kolom input: Username dan Password.
  -> Tombol "Login" untuk memvalidasi input dan berpindah ke halaman berikutnya.
  -> Jika input kosong, akan muncul pesan peringatan (Toast). Jika berhasil, akan diarahkan ke halaman Home.
  -> Latar belakang halaman login dilengkapi dengan gambar, teks "Selamat Datang!", dan ikon ilustrasi.
  
- Validasi Input:
  -> Username dan password tidak boleh kosong. Jika salah satu atau keduanya kosong, aplikasi menampilkan pesan "Username atau Password tidak boleh kosong" menggunakan Toast.
  
- Berpindah Halaman:
  -> Setelah login berhasil, aplikasi mengirim data username ke HomeActivity dan menampilkan halaman utama (Home Page).
  
- Halaman Home
  -> Menampilkan pesan selamat datang yang disesuaikan dengan username pengguna.
  -> Tombol "Logout" yang mengarahkan kembali ke halaman login.
  
Logging
  -> Proses login dan logout dicatat menggunakan Logcat untuk memudahkan debugging.


2. Cara menjalankan aplikasi
- Pada halaman login, masukkan username dan password.
- Jika salah satu kosong, aplikasi akan menampilkan pesan kesalahan.
- Jika keduanya diisi, klik tombol "Login" untuk masuk ke halaman Home.
- Pada halaman Home, klik tombol "Logout" untuk kembali ke halaman login.

3. Screenshot aplikasi
- Login page
![LoginPage](https://github.com/user-attachments/assets/c2707665-6cae-4131-9239-bb6d2b80d751)

- Input on textbox
![input](https://github.com/user-attachments/assets/b9cc273f-183a-4de7-a94c-0053e1cf2f4d)

- Toast notif
![toast_notif](https://github.com/user-attachments/assets/a91c8d23-2095-4537-96f1-08445951a39d)

- Home page
![HomePage](https://github.com/user-attachments/assets/bdceb1bc-0897-4b9a-b657-35dde1f21970)

- Login succes log
![loginsucces_log](https://github.com/user-attachments/assets/1c5f2285-1b47-431e-960e-1e917dd7d6c8)

- Login null log
![loginnull_log](https://github.com/user-attachments/assets/e2ad19a5-3927-4089-95ab-244a775db07a)

- Logout log
![logout_log](https://github.com/user-attachments/assets/2c55deec-299b-402e-81c3-e623761649ea)
