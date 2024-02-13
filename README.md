# TUTORIAL 2 ADPRO
#### Daffa Mohamad Fathoni (2206824161)
#### Advanced Programming B / GEN

<hr>

[*Link to Eshop Web*](https://eshop-fathonidf-adpro.koyeb.app/)

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-orange.svg)](https://sonarcloud.io/summary/new_code?id=fathonidf-adpro_eshop)

[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=fathonidf-adpro_eshop&metric=coverage)](https://sonarcloud.io/summary/new_code?id=fathonidf-adpro_eshop) [![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=fathonidf-adpro_eshop&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=fathonidf-adpro_eshop) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=fathonidf-adpro_eshop&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=fathonidf-adpro_eshop)

## REFLECTION

### 1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.

1. **Unused imports** merujuk pada penggunaan *library* dalam sebuah program yang diimpor tetapi tidak digunakan dalam implementasi kode tersebut. Keberadaan impor yang tidak terpakai dapat menyebabkan overhead pada kompilasi dan membuat kode menjadi kurang rapi dalam penerapan prinsip *clean code*. 
Oleh karena itu, adalah praktik yang baik untuk secara berkala memeriksa dan menghapus impor yang tidak digunakan agar kode tetap bersih dan efisien.

2. **Field Injection** seperti yang diimplementasikan dalam kerangka kerja seperti Spring menggunakan anotasi seperti `@Autowired` untuk menyisipkan dependensi ke dalam sebuah kelas melalui properti atau field. 
Meskipun ini menyediakan kenyamanan dalam pengembangan aplikasi dengan memungkinkan kerangka kerja mengelola siklus hidup objek dan penyisipan dependensi, namun penggunaan yang berlebihan dapat menyebabkan ketergantungan yang terlalu kuat antara kelas-kelas, sehingga sulit untuk melakukan pengujian dan memelihara kode.
Untuk memperbaikinya dapat mengubah objek yang menggunakan injeksi `@Autowired` dengan membuat inisiasi class langsung.

3. **JUnit 5 modifier** `public` pada metode pengujian (*unit test*) dianggap tidak perlu karena JUnit 5 menggunakan mekanisme refleksi untuk menemukan dan menjalankan metode pengujian tanpa memperhatikan visibilitasnya. Oleh karena itu, menambahkan modifier `public` pada metode pengujian hanyalah redundan dan tidak diperlukan. 
Menghindari penggunaan modifier `public` pada metode pengujian dapat membantu dalam menjaga kode tetap bersih dan mengurangi kebingungan pembaca tentang metode mana yang sebenarnya digunakan sebagai metode pengujian.

### 2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!


Menurut saya, implementasi saat ini telah memenuhi konsep **CI/CD**. Dengan penggunaan **GitHub workflows**, proyek kita dapat meng-*automatisasi* proses **CI (*Continuous Integration*)** dan **CD (Continuous Development*)** dengan deployment yang otomatis setiap kali ada perubahan yang di-*push* atau di-*pull request* ke repository GitHub. Setiap kali ada perubahan pada branch mana pun, kode akan diuji menggunakan test case yang ditetapkan dalam `ci.yml`, *code-scanning/analysis* oleh **OSSF Scorecard** di `scorecard.yml`, dan diperiksa menggunakan **SonarCloud** di `sonarcloud.yml`.
Setelah dianggap berhasil, kode akan digabungkan ke branch utama **main**, di mana ada langkah otomatis untuk melakukan deployment ke PaaS Koyeb dan pemeriksaan keamanan kode dengan `scorecard.yml`. Dengan demikian, serangkaian tindakan ini membentuk alur kerja otomatis dalam siklus pengembangan perangkat lunak **(Software Development Life Cycle)**, termasuk CI/CD.