# Navigation dan Routing di Jetpack Compose

Navigasi adalah proses perpindahan antar layar (composable) dalam aplikasi. Dengan Jetpack Compose, navigasi menjadi lebih sederhana melalui library `Navigation`. Sementara itu, routing mengacu pada pengelolaan jalur layar serta pengoperan data antar layar.

## Komponen Utama Navigasi
1. **NavHost**  
   Komponen utama yang mendefinisikan navigasi dalam aplikasi. Semua layar dan rute dijabarkan di sini.
   - **Fungsi Utama:**
     - Struktur navigasi aplikasi.
     - Mendefinisikan rute dan relasi antar layar.

2. **NavController**  
   Objek yang bertanggung jawab atas perpindahan antar layar.
   - **Fungsi Utama:**
     - Mengatur navigasi antar layar.
     - Menyimpan state backstack layar.
     - Navigasi dengan parameter.

3. **Composable**  
   Unit dasar untuk layar. Setiap layar atau komponen didefinisikan sebagai `composable`.
   - **Fungsi Utama:**
     - Mendefinisikan layar berdasarkan rute.
     - Mendukung penerimaan data sebagai parameter.

4. **NavBackStackEntry**  
   Representasi dari layar yang berada dalam backstack navigasi.
   - **Fungsi Utama:**
     - Menyimpan state dan argument layar aktif.
     - Mengakses data navigasi yang diterima.

## Jenis Navigasi
### 1. Navigasi Dasar
- Membuat `NavHost` yang mendefinisikan rute.
- Contoh:
  ```kotlin
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = "screenA") {
      composable("screenA") { ScreenA(navController) }
      composable("screenB") { ScreenB() }
  }
