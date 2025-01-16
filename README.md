# Working with Firebase

Firebase adalah platform yang dapat membantu dalam membangun dan mengembangkan backend aplikasi. Dengan Firebase, pengembang dapat fokus pada pengembangan fitur aplikasi tanpa perlu khawatir dengan kompleksitas infrastruktur backend. Firebase menyediakan berbagai layanan yang dapat digunakan untuk membangun aplikasi skala kecil hingga besar.

### Kenapa Firebase?
1. **Cepat dan Efisien:** Tidak perlu memulai pengembangan backend dari nol.
2. **Mudah Diintegrasi:** Mendukung platform Android, iOS, dan web.
3. **Real-Time:** Mendukung pembaruan data secara langsung.
4. **Skalabel:** Cocok untuk aplikasi kecil maupun besar dengan jutaan pengguna.
5. **Gratis (dengan opsi premium):** Fitur dasar sudah cukup untuk belajar dan prototipe.

---

## Fitur Utama Firebase

### **1. Authentication**
Authentication adalah fitur untuk mengelola login dan registrasi pengguna. Firebase mendukung berbagai metode login seperti email/password, Google, Facebook, atau nomor telepon.

#### **Kegunaan:**
- Mengelola autentikasi pengguna tanpa harus membangun backend dari awal.
- Mudah diintegrasikan dengan fitur lain, seperti Firestore atau Realtime Database.

#### **Contoh Implementasi Kode:**
```kotlin
val auth: FirebaseAuth = FirebaseAuth.getInstance()

fun signIn(email: String, password: String) {
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                println("Login berhasil: ${user?.uid}")
            } else {
                println("Login gagal: ${task.exception?.message}")
            }
        }
}
```

---

### **2. Firestore Database**
Firestore adalah database NoSQL modern yang fleksibel dan mendukung struktur data berbasis dokumen. Fitur real-time memungkinkan sinkronisasi data secara otomatis.

#### **Kegunaan:**
- Menyimpan data pengguna, catatan, atau data lainnya dengan mudah.
- Mendukung aplikasi yang memerlukan pembaruan data secara langsung.

#### **Contoh Implementasi Kode:**
```kotlin
val db = FirebaseFirestore.getInstance()

fun addNote(title: String, content: String) {
    val note = hashMapOf(
        "title" to title,
        "content" to content,
        "timestamp" to FieldValue.serverTimestamp()
    )

    db.collection("notes")
        .add(note)
        .addOnSuccessListener { documentReference ->
            println("Catatan ditambahkan dengan ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            println("Gagal menambahkan catatan: ${e.message}")
        }
}
```

---

### **3. Cloud Storage**
Cloud Storage digunakan untuk menyimpan file seperti gambar, video, atau dokumen. File disimpan dengan aman dan dapat diakses kapan saja.

#### **Kegunaan:**
- Cocok untuk aplikasi galeri foto atau penyimpanan dokumen.
- Mudah diintegrasikan dengan fitur lain, seperti Firestore.

#### **Contoh Implementasi Kode:**
```kotlin
val storage = FirebaseStorage.getInstance()
val storageRef = storage.reference

fun uploadFile(fileUri: Uri) {
    val fileRef = storageRef.child("uploads/${fileUri.lastPathSegment}")

    fileRef.putFile(fileUri)
        .addOnSuccessListener { taskSnapshot ->
            println("File berhasil diunggah: ${taskSnapshot.metadata?.path}")
        }
        .addOnFailureListener { e ->
            println("Gagal mengunggah file: ${e.message}")
        }
}
```

---

### **4. Firebase Cloud Messaging (FCM)**
Firebase Cloud Messaging memungkinkan pengiriman notifikasi ke perangkat tertentu atau grup perangkat.

#### **Kegunaan:**
- Mengirimkan notifikasi promosi, pembaruan fitur, atau informasi penting ke pengguna.

#### **Contoh Implementasi Kode:**
```kotlin
FirebaseMessaging.getInstance().token
    .addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val token = task.result
            println("Token FCM: $token")
        } else {
            println("Gagal mendapatkan token FCM: ${task.exception?.message}")
        }
    }
```

---

### **5. Crashlytics**
Crashlytics membantu melacak dan memperbaiki bug atau crash di aplikasi.

#### **Kegunaan:**
- Mempercepat proses identifikasi dan perbaikan bug berdasarkan laporan real-time.
- Membantu menjaga kualitas aplikasi.

#### **Contoh Implementasi Kode:**
```kotlin
FirebaseCrashlytics.getInstance().log("App dimulai")
FirebaseCrashlytics.getInstance().setUserId("user123")

try {
    // Simulasi error
    throw Exception("Simulasi crash")
} catch (e: Exception) {
    FirebaseCrashlytics.getInstance().recordException(e)
}
```

---

### **6. Firebase Hosting**
Firebase Hosting adalah solusi hosting cepat dan aman untuk aplikasi web atau Progressive Web App (PWA).

#### **Kegunaan:**
- Hosting web dengan HTTPS otomatis.
- Cocok untuk prototipe cepat atau aplikasi web kecil.

#### **Contoh Implementasi Kode:**
```bash
firebase init hosting
firebase deploy
```

---

## Cara Menjalankan
1. **Setup Firebase Project:**
   - Login ke Firebase Console dan buat project baru.
   - Aktifkan fitur yang diperlukan seperti Authentication, Firestore, atau Cloud Storage.
2. **Integrasi dengan Android Studio:**
   - Masuk ke tools Firebase.
   - Implementasikan fitur seperti autentikasi, database, atau notifikasi dengan memilih fitur-fitur yang sudah disediakan di aplikasi Android Studio.
   - Lakukan konfigurasi sesuai dengan petunjuk yang ada pada aplikasi.

---

## Kesimpulan
Firebase adalah platform yang lengkap untuk mendukung pengembangan aplikasi modern. Fitur-fiturnya seperti Authentication, Firestore, dan Cloud Storage mempermudah pengembang dalam membangun aplikasi yang efisien dan scalable. Dengan integrasi yang mudah dan dokumentasi yang jelas, Firebase menjadi pilihan tepat untuk mahasiswa maupun profesional dalam mengembangkan aplikasi.

---

## Screenshot Aplikasi
1. Menambahkan note
![Image](https://github.com/user-attachments/assets/0ef19f1a-5aac-4b5a-8741-bd44cf4b999d)
2. Menghapus note
![Image](https://github.com/user-attachments/assets/953f865b-4c55-46c9-a6a8-a38a95f6f0a0)
3. Tampilan setelah note dihapus
![Image](https://github.com/user-attachments/assets/ca17a8ad-d63a-407e-8ffb-4e01ca70c0cd)
