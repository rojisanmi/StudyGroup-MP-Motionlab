PENJELASAN FITUR
1. Color
Untuk penambahan color dapat dilakukan pada file Color.kt. Adapun color yang saya tambahkan adalah Red (0XFFFC2C1C) dan DarkRed (0xFFC2271C) yang dikelompokkan dengan object.

![image](https://github.com/user-attachments/assets/890ce55e-fcf6-4573-9100-71ebda62ffed)

2. Fonts
Untuk penambahan font dapat dilakukan pada file Type.kt. Adapun font Parkinsans Family yang didownload dari Google Fonts.

![image](https://github.com/user-attachments/assets/cdb55382-d80b-4823-98a1-64038c6a6538)

![image](https://github.com/user-attachments/assets/67b24316-8de3-4a97-9ece-8c1f88b339a4)

3. Bottom Navbar
Bottom Navigation Bar dibuat menggunakan komponen NavigationBar dari Jetpack Compose, dengan tiga item navigasi: **Home**, **Profile**, dan **Settings**. Setiap item memiliki ikon terpilih dan tidak terpilih, serta label teks di bawah ikon. Pemilihan tab dikelola melalui variabel indeks selectedItemIndex, yang diperbarui setiap kali item dipilih, sehingga konten layar berubah sesuai pilihan. Ikon menggunakan Material Design Icons seperti Icons.Filled.Home untuk ikon terpilih. **Home** menampilkan daftar anggota menggunakan LazyColumn, sementara **Profile** dan **Settings** berfungsi sebagai placeholder. Struktur ini memberikan navigasi yang responsif dengan tampilan yang konsisten.

![image](https://github.com/user-attachments/assets/e49414d9-2161-4643-81ea-9c7d66bb6ab2)


CARA MENJALANKAN APLIKASI
1. Ketika aplikasi pertama kali dibuka, layar LoginScreen akan muncul. Pengguna dapat melihat dua kolom input untuk username dan password, tombol Login, dan teks bertuliskan "Don't have account yet?".
2. Masukkan username dan password di kolom yang tersedia, lalu klik tombol Login. Jika berhasil, akan muncul notifikasi toast: "Akun dengan username = [username] telah berhasil login." Pengguna akan diarahkan ke HomeScreen.
3. Jika pengguna belum memiliki akun, klik teks "Don't have account yet?" pada layar LoginScreen. Aplikasi akan menampilkan layar RegisterScreen dengan kolom input untuk username, email, password, dan konfirmasi password.
4. Isi semua kolom di RegisterScreen dan klik tombol Register. Jika berhasil, muncul notifikasi toast: "Akun telah terdaftar." Aplikasi kemudian kembali ke LoginScreen, dan pengguna dapat login dengan akun baru yang telah didaftarkan.
5. Di HomeScreen, pengguna secara default melihat card yang berisi member-member dari Motion Lab. Pengguna bisa melihat detail dari member tersebut dengan menekan card dari member tersebut yang kemudian akan diarahkan ke halaman detail informasi dari member berikut.
6. Pengguna juga bisa berpindah ke menu setting atau profile dengan menekan tombol pada bottom navbar.


SCREENSHOT APLIKASI
- LoginScreen

![LoginScreen](https://github.com/user-attachments/assets/0c52d2ff-6a10-430a-8a89-92101041cf6a)

- RegisterScreen

![RegisterScreen](https://github.com/user-attachments/assets/bee153a1-e8f7-4bde-b00c-da03e9fb70e7)

- HomeScreen

![HomeScreen](https://github.com/user-attachments/assets/c4270567-5112-4542-9a31-1161c9d7bdbd)

- ProfileScreen

![ProfileScreen](https://github.com/user-attachments/assets/7452fdd8-e9d3-4c8e-90ac-9fcc975ec6ba)

- SettingsScreen

![SettingsScreen](https://github.com/user-attachments/assets/6e9ca4e2-fc53-4ec2-8194-fa9ac52bd453)

- MemberDetailScreen

![MemberDetailScreen](https://github.com/user-attachments/assets/b16d30bd-233d-4b1f-8bd0-76a377bc99ed)
