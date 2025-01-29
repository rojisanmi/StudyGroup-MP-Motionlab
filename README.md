# Working with Retrofit and Open API

## Pendahuluan
Retrofit adalah sebuah library yang digunakan untuk melakukan komunikasi dengan REST API di aplikasi Android. Library ini dikembangkan oleh Square dan mempermudah pengambilan serta pengiriman data dari atau ke server menggunakan berbagai metode HTTP seperti GET, POST, PUT, dan DELETE.

Dalam eksplorasi ini, berbagai Open API digunakan untuk memahami cara kerja Retrofit dalam mengakses data dari internet, termasuk OpenWeatherMap API, Cat Facts API, Joke API, serta pembuatan REST API sederhana menggunakan Beeceptor.

## Open API yang Dieksplorasi
Beberapa Open API yang digunakan dalam eksplorasi ini adalah:

### 1. OpenWeatherMap API
API ini menyediakan data cuaca berdasarkan lokasi, seperti suhu, kelembapan, kecepatan angin, dan lainnya.
- **Endpoint yang digunakan:**  
  `https://api.openweathermap.org/data/2.5/weather?q={city}&appid={API_KEY}`

### 2. Cat Facts API
API ini memberikan informasi menarik tentang kucing dalam bentuk fakta-fakta acak.
- **Endpoint yang digunakan:**  
  `https://catfact.ninja/fact`

### 3. Joke API
API ini menyediakan berbagai jenis lelucon yang dapat diambil secara acak.
- **Endpoint yang digunakan:**  
  `https://official-joke-api.appspot.com/random_joke`

### 4. Beeceptor (Custom API untuk CRUD Notes)
Beeceptor digunakan untuk membuat dan mengelola REST API sederhana. API ini membantu dalam memahami proses CRUD (Create, Read, Update, Delete) dengan menggunakan endpoint yang telah dibuat.
- **Base URL Beeceptor:**  
  `https://beeceptor.com/crud-api/api/notes`

## Fitur yang Dapat Diterapkan dari API

### 1. Menggunakan Retrofit untuk Permintaan HTTP
Retrofit digunakan untuk berkomunikasi dengan API yang dieksplorasi.

#### **Menambahkan Dependensi Retrofit**
Tambahkan dependensi berikut di `build.gradle`:
```gradle
implementation 'com.squareup.retrofit2:retrofit:2.11.0'
implementation 'com.squareup.retrofit2:converter-gson:2.11.0'
implementation 'com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.14
```

#### **Membuat Interface ApiService**
```kotlin
interface ApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Response<WeatherResponse>

    @GET("fact")
    suspend fun getCatFact(): Response<CatFactResponse>

    @GET("random_joke")
    suspend fun getJoke(): Response<JokeResponse>
}
```

### 2. Menggunakan Gson Converter untuk Parsing JSON
Gson digunakan untuk mengubah respons JSON menjadi objek Kotlin.

#### **Membuat Model Data**
```kotlin
data class WeatherResponse(
    val main: Main,
    val name: String
)

data class Main(
    val temp: Double,
    val humidity: Int
)

data class CatFactResponse(
    val fact: String
)

data class JokeResponse(
    val setup: String,
    val punchline: String
)
```

### 3. Konfigurasi Retrofit Instance
```kotlin
object RetrofitInstance {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private const val CAT_FACT_URL = "https://catfact.ninja/"
    private const val JOKE_URL = "https://official-joke-api.appspot.com/"

    val weatherApi: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    val catFactApi: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(CAT_FACT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    val jokeApi: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(JOKE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
```

### 4. Implementasi CRUD Menggunakan Beeceptor
Beeceptor digunakan untuk simulasi operasi CRUD dengan Retrofit.

#### **Menambahkan Interface untuk Beeceptor API**
```kotlin
interface NotesApiService {
    @POST("/api/notes")
    suspend fun createNote(@Body note: Note): Response<Note>

    @GET("/api/notes")
    suspend fun getNotes(): Response<List<Note>>

    @PUT("/api/notes/{id}")
    suspend fun updateNote(@Path("id") id: String, @Body note: Note): Response<Note>

    @DELETE("/api/notes/{id}")
    suspend fun deleteNote(@Path("id") id: String): Response<Unit>
}
```

#### **Model untuk Catatan (Notes)**
```kotlin
data class Note(
    val id: String,
    val content: String,
    val authorName: String
)
```

## Cara Menjalankan Aplikasi yang Dibuat (only API's Features)
1. Pada navbar klik icon Feedback
2. Setelah masuk ke laman feedback, untuk menambahkan feedback klik tombol '+', lalu masukkan nama dan isi feedback-nya
3. Untuk mengedit feedback, klik box feedback-nya kemudian edit data feedback-nya
4. Dan untuk menghapus feedback, klik icon keranjang sampah di bagian kanan box feedback-nya

## Screenshot Aplikasi
- Tampilan Laman Feedback

![Image](https://github.com/user-attachments/assets/11d0d584-7ddc-4046-aade-eb9ebdb0acae)

- Edit Feedback

![Image](https://github.com/user-attachments/assets/1e001ae4-41d6-4f0e-9805-9a39fcc9786d)
![Image](https://github.com/user-attachments/assets/346ea0ab-a1cf-43df-a379-49047aa5b825)

- Tampilan Laman Feedback Setelah Edit Feedback

![Image](https://github.com/user-attachments/assets/97cb8696-7c2b-4031-8859-30d340b1294f)- 

- Add Feedback

![Image](https://github.com/user-attachments/assets/a213243b-1e7f-490c-928c-5facb6014de3)

- Tampilan Laman Feedback Setelah Add feedback

![Image](https://github.com/user-attachments/assets/788375d4-88c5-47e7-b345-d143d853a9ad)

- Tampilan Laman Feedback Setelah Delete Feedback

![Image](https://github.com/user-attachments/assets/d225f01c-fa8a-40c8-8f3f-c21d9e0533a2)


## Kesimpulan
Retrofit adalah solusi yang sangat fleksibel untuk mengelola komunikasi API di Android. Dengan bantuan Gson Converter, data JSON dapat dikonversi dengan mudah ke dalam objek Kotlin. Penerapan CRUD menggunakan Beeceptor memberikan pemahaman yang lebih baik tentang cara kerja komunikasi data antara aplikasi dan server.
