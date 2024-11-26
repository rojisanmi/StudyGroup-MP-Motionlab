1. Sejarah Kotlin  
- Kotlin diperkenalkan oleh JetBrains pada tahun 2011 sebagai bahasa pemrograman di atas JVM (Java Virtual Machine).  
- Kotlin dirancang agar terintegrasi dengan Java.  
- Pada tahun 2017, Google merekomendasikan Kotlin sebagai bahasa utama untuk pengembangan aplikasi Android.  

2. Kenapa Belajar Kotlin  
- Kotlin kompatibel dengan JVM dan mendukung ekosistem teknologi Java yang besar.  
- Lebih elegan dan sederhana dibandingkan Java.  
- Bahasa utama untuk pengembangan aplikasi Android.  
- Framework populer seperti Spring sudah mendukung Kotlin.  

3. Sejarah Android  
- Android adalah sistem operasi berbasis Linux untuk perangkat layar sentuh seperti ponsel dan tablet.  
- Dikembangkan oleh Android Inc yang didirikan Andy Rubin pada 2003, kemudian diakuisisi Google pada 2005.  
- Sistem operasi Android resmi dirilis pada 2007, dan ponsel Android pertama dijual pada 2008.  

4. Gradle  
- Gradle digunakan untuk manajemen proyek di Android.  
- Android Studio secara default membuat proyek Gradle dengan satu modul bernama *app*.  

5. Manifest File  
- Setiap proyek Android harus memiliki file AndroidManifest.xml.  
- File ini menyimpan informasi aplikasi seperti aktivitas, izin, dan komponen lainnya.  

6. Activity  
- Di Android, *Activity* adalah komponen utama yang menjalankan aplikasi, menggantikan konsep *main function* di Java/Kotlin.  

7. Layout  
- Android memisahkan kode program dari tampilan UI menggunakan Layout berbasis XML, yang menyerupai HTML.  

8. View  
- Semua komponen UI di Android adalah turunan dari class View, termasuk Layout.  

9. Find View by ID  
- Fungsi `findViewById()` digunakan untuk mengakses komponen di Layout.  
- Komponen harus memiliki atribut ID agar dapat diakses.  

10. View ID  
- ID ditambahkan pada komponen dengan format `@+id/namaId`.  
- ID ini otomatis terdaftar di class R dan digunakan untuk mengidentifikasi komponen.  
- Penamaan ID yang baik meliputi deskripsi nama dan jenis komponen, misalnya `nameEditText` atau `registerButton`.  

11. Action Listener  
- Beberapa komponen memiliki Action Listener untuk menangani aksi pengguna, seperti `setOnClickListener()` pada tombol.  

12. Log  
- Logging di Android dilakukan dengan class `Log`, menggantikan fungsi `println` di Java/Kotlin.  

13. Resource  
- Resource adalah file tambahan seperti teks, gambar, dan animasi.  
- Resource dapat diakses melalui class `Resources`.  
