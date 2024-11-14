**Command-Command Git**

1. Insialisasi
   git init -> menginisialisasi direktori di komputer lokal yang sedang digunakan sebagai repositori Git.
   git clone (HTTPS-url-git-repository) -> mengambil seluruh isi repositori dari remote environment melalui HTTPS url.
   git clone (SSH-key-git-repository) -> mengambil seluruh isi repositori dari remote environment melalui SSH key.

2. Stage & Snapshot
   git status -> menampilkan file yang dimodifikasi di direktori aktif, dan file yang belum terlacak (track) untuk commit berikutnya.
   git add . -> menambahkan semua file yang ada pada direktori aktif ke remote.
   git add (nama-file) -> menambahkan file tertentu yang ada pada direktori aktif ke remote.
   git commit -m "pesan" -> membuat perubahan di remote environment, dan menampilkan pesan sebagai informasi dari apa yang sudah di-commit.
   git diff -> menampilkan perbedaan pada apa yang telah diubah namun bukan staged.
   git diff --staged -> menampilkan perbedaan pada staged namun belum di-commit.
   
4. Push
   git push -> perubahan di-update ke git repository.

5. Reset & Rewrite History
   git rebase (nama branch) -> apply commit-commit pada branch aktif sebelum commit tertentu.
   git reset --hard (commit-hash) -> reset ke log commit tertentu. commit hash didapatkan dari 'git log' command.
   
6. Branch & Merge
   git branch -> menampilkan daftar branch. tanda * akan muncul di sebelah branch yang sedang aktif.
   git checkout -b (nama-branch-yang-akan-dibuat) -> membuat branch baru, dan otomatis berpindah ke branch yang baru dibuat.
   git checkout (nama-branch) -> pindah ke branch tertentu.
   git merge (nama branch) -> menggabungkan riwayat branch yang ditentukan ke branch aktif.
   
7. Inspect & Compare
   git log -> menampilkan semua riwayat commit pada branch aktif.
   git log (branchB)..(branchA) -> menampilkan riwayat commit pada branch A yang tidak ada pada branch B.
   git log --follow (nama file) -> menampilkan riwayat commit perubahan file, termasuk rename file.
   git diff branchB...branchA -> menampilkan perbedaan dari riwayat commit branch A yang tidak ada pada branch B.
   
8. Melacak Perubahan pada Path
   git rm (nama file) -> menghapus file pada project dan melakukan penghapusan juga untuk commit.
   git mv (path-tertentu) (path-tujuan) -> memindahkan file-file pada path tertentu ke path tujuan.
   git log --stat -M -> menampilkan semua riwayat commit dengan indikasi path apapun yang dipindahkan.
   
9. Share & Update
   git remote add (alias) (url) -> menambahkan git url menjadi sebuah alias.
   git fetch (alias) -> mengambil semua branch dari remote Git tersebut.
   git merge (alias)/(branch) -> menggabungkan satu branch remote ke branch aktif untuk di-update.
   git push (alias) (branch) -> mengirimkan commit-commit branch lokal ke branch remote.
   git pull -> mengambil dan menggabungkan semua commit dari branch remote.
  
10. Temporary Commits (Stash)
   git stash -> menyimpan perubahan secara bertahap.
   git stash list -> menampilkan daftar stash yang ada, nama branch tempat daftar stash tersebut dibuat, dan deskripsi commit yang menjadi dasar stash tersebut. 
   git stash pop -> menerapkan perubahan yang disembunyikan dan kemudian menghapusnya dari tumpukan stash.
   git stash drop -> mengabaikan perubahan dari tumpukan stash paling atas.


**Metode-Metode Git Clone**

1. HTTPS url
   - Buka terminal, dan arahkan ke direktori yang ingin dijadikan destinasi penyimpanan repositori dari GitHub.
   - Salin HTTPS url repositori dari GitHub.
   - lalu jalankan command "git clone (HTTPS-url-git-repository)"

2. SSH key
   - Buka terminal dan ketik ssh-keygen. (pastikan sudah melakukan git init pada direktori)
   - Tekan enter untuk menerima lokasi file dan frasa sandi default.
   - Salin public key ke clipboard dengan cat ~/.ssh/id_rsa.pub
   - Buka pengaturan akun GitHub dan klik SSH dan GPG keys.
   - Klik New SSH key dan tempel public key yang didapatkan pada kolom key. Beri judul dan simpan.
   - Buka repositori yang ingin dilakukan kloning dan klik pada Code. Pilih SSH sebagai metode kloning dan salin URL SSH.
   - Kembali ke terminal, ketik git clone diikuti dengan SSH key. Setelah itu, proses kloning repositori bisa berjalan tanpa memasukkan nama pengguna dan kata sandi.
