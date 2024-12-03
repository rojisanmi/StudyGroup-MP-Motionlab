PENJELASAN FITUR
1. LoginScreen
- Background Image: Menggunakan Image untuk mengatur gambar latar belakang dengan skala ContentScale.FillHeight untuk memastikan gambar memenuhi seluruh layar.
- Card: Membungkus konten login di dalam Card dengan RoundedCornerShape untuk sudut melengkung. Kemudian warna latar belakang Card diatur ke warna putih menggunakan CardDefaults.
- OutlinedTextField: Untuk text input. Terdapat dua OutlinedTextField untuk username dan password. Password memiliki ikon toggle untuk melihat/menyembunyikan isi password menggunakan VisualTransformation.
- Button: Tombol Login diwarnai merah (Color.Red) menggunakan ButtonDefaults. Saat tombol ditekan, menampilkan toast dan menavigasi ke HomeScreen.
- TextButton: Tombol teks dengan label "Don't have account yet?" yang menavigasi ke RegisterScreen saat ditekan.

2. RegisterScreen
- Background Image: Terdapat background image seperti LoginScreen.
- Card: Konten register dibungkus dalam Card dengan sudut melengkung.
- OutlinedTextField: Untuk text input. Terdapat empat OutlinedTextField untuk Username, Email, Password, Confirm Password. Field password memiliki fitur toggle untuk melihat/menyembunyikan password.
- Button: Tombol Register berwarna merah. Saat ditekan, menampilkan toast dan menavigasi kembali ke LoginScreen.

3. HomeScreen
- Background Image: Terdapat background image seperti LoginScreen.
- Teks Utama: "Selamat Datang di Main Page" dengan ukuran besar dan warna putih.
- Deskripsi: Terdapat deskripsi yang berisi materi layouting di week 2, disimpan dalam Card agar lebih enak dipandang.
- Box, Row, dan Column: Digunakan dalam materi deskripsi untuk menunjukkan cara penggunaan layouting
- Box: Menyusun konten dalam area terbatas.
- Row: Membuat layout horizontal.
- Column: Membuat layout vertikal.
- Button Logout: Tombol Logout dengan warna merah. Saat ditekan, menampilkan toast dan menavigasi kembali.

CARA MENJALANKAN APLIKASI
1. Ketika aplikasi pertama kali dibuka, layar LoginScreen akan muncul. Pengguna melihat dua kolom input untuk username dan password, tombol Login, dan teks bertuliskan "Don't have account yet?".
2. Masukkan username dan password di kolom yang tersedia, lalu klik tombol Login. Jika berhasil, akan muncul notifikasi toast:
"Akun dengan username = [username] telah berhasil login."
Pengguna akan diarahkan ke layar HomeScreen.
3. Di HomeScreen, pengguna melihat teks "Selamat Datang di Main Page", informasi singkat tentang materi layout (Box, Row, dan Column), serta tombol merah bertuliskan Logout. Untuk keluar, klik tombol Logout, yang akan memunculkan notifikasi:
Logout berhasil.
Setelah itu, pengguna kembali ke LoginScreen.
4. Jika pengguna tidak memiliki akun, klik teks "Don't have account yet?" pada layar LoginScreen. Aplikasi akan memunculkan layar RegisterScreen dengan kolom input untuk username, email, password, dan konfirmasi password.
5. Isi semua kolom di RegisterScreen dan klik tombol Register. Jika berhasil, akan muncul notifikasi toast:
"Akun telah terdaftar."
Aplikasi kemudian kembali ke LoginScreen, tempat pengguna bisa login dengan akun baru yang telah didaftarkan.

SCREENSHOT APLIKASI
- LoginScreen
![LoginScreen](https://github.com/user-attachments/assets/fe734804-1c42-4a84-987a-1094431e8403)
- RegisterScreen
![RegisterScreen](https://github.com/user-attachments/assets/193957f3-6a64-42da-adfd-c7a9556ecd07)
- HomeScreen (Main Page)
![HomeScreen](https://github.com/user-attachments/assets/cb078f7e-691c-4222-9aaf-d049b8ae782f)
