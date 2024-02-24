# TUTORIAL 3 ADPRO  (Maintainability & OO Principles)
#### Daffa Mohamad Fathoni (2206824161)
#### Advanced Programming B / GEN

<hr>

[Link to Eshop Web *(Coming Soon)*]()

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-orange.svg)](https://sonarcloud.io/summary/new_code?id=fathonidf-adpro_eshop-tutorial-3) 
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=fathonidf-adpro_eshop-tutorial-3&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=fathonidf-adpro_eshop-tutorial-3) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=fathonidf-adpro_eshop-tutorial-3&metric=coverage)](https://sonarcloud.io/summary/new_code?id=fathonidf-adpro_eshop-tutorial-3) [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=fathonidf-adpro_eshop-tutorial-3&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=fathonidf-adpro_eshop-tutorial-3)

## REFLECTION

### 1. Explain what principles you apply to your project!

1. **Single Responsibility Principle**
Pemisahan `CarController` yang awalnya berada dalam class `ProductController` untuk menerapkan SRP karena keduanya memiliki fungsinya yang berbeda masing-masing.

2. **Open Closed Principle**
Dengan membuat method update pada `models` akan memudahkan dengan cukup pemanggilan method update tersebut. Hal ini memudahkan pemanggilan method pada `repository` agar lebih general dalam pemanggilannya daripada memodifikasikannya

3. **Interface Segregation Principle**
Dengan pemisahan interface `CarService` dan `ProductService` ini membedakan interface antara kedua fungsi tersebut. Lebih baik pembuatan interface yang bervariasi (modular) dibandingkan menggabungkannya secara keseluruhan. Hal ini akan membuat kode menjadi efisien untuk mengimplementasi abstract method sesuai kebutuhannya.

4. **Dependency Inversion Principle**
Prinsip ini mengimplementasikan kode misalnya pada sebuah object yang diinstansiasi dengan bergantung/berkaitan pada *abstraction/interfaces* daripada *concrete class*. Dengan kebergantungan pada *abstract class/interface* akan mengurangi atau menghilangkan ketergantungan antar komponen-komponen *concrete class*, hal ini biasa disebut *decoupling*. Pada projek ini, `CarRepository` menginstansiasi objek `CarService carservice` yang berupa *interface* daripada `CarServiceImpl carService` yang berupa *concrete class*.


### 2. Explain the advantages of applying SOLID principles to your project with examples.

Dengan mengimplementasikan prinsip-prinsip SOLID, manajemen kode yang kita buat meningkat secara signifikan. Kita dapat lebih mudah membuat unit pengujian untuk menguji kode, karena memisahkan fungsi-fungsi kecil memudahkan dalam mendiagnosis kesalahan. Hal ini juga meningkatkan keterbacaan kode, karena method-method yang lebih kecil lebih mudah dipahami oleh pembaca baru.

Penerapan SOLID juga memudahkan penambahan fitur ke dalam kode, sesuai dengan prinsip Open Closed Principle. Kita dapat menambahkan fitur baru tanpa harus mengubah kode yang sudah ada. Selain itu, penggunaan Dependency Inversion Principle membantu dalam meminimalkan kerusakan yang diakibatkan oleh perubahan pada satu bagian kode terhadap bagian kode lainnya.

Merujuk pada prinsip *Open Close* and *Dependency Inversion* pada *Controller* memungkinkan penambahan implementasi baru tanpa perlu memodifikasi *Controller* yang sudah ada. Hal ini mengurangi keterikatan antar kelas dan memungkinkan penggantian implementasi dengan yang lain secara lebih mudah.

Prinsip SRP memungkinkan organisasi kode yang lebih baik dengan memisahkan tanggung jawab tiap kelas. Hal ini memudahkan pemahaman, pemeliharaan, dan komunikasi antar pengembang. Pengujian juga menjadi lebih mudah karena setiap kelas memiliki tanggung jawab tunggal, dan perubahan pada satu kelas tidak akan berdampak pada kelas lainnya.

Dengan LSP dan ISP, kita dapat menerapkan polimorfisme yang lebih baik dan mengurangi ketergantungan antar kelas. Ini memungkinkan penggunaan kelas turunan dan antarmuka dengan lebih fleksibel, serta mengurangi keterikatan antar kelas. Desain antarmuka yang terfokus juga membantu dalam memastikan setiap antarmuka memiliki tanggung jawab yang spesifik.

Secara keseluruhan, penerapan SOLID meningkatkan kualitas, keterbacaan, dan fleksibilitas kode, serta memudahkan dalam pengujian, pemeliharaan, dan pengembangan fitur baru.

### 3. Explain the disadvantages of not applying SOLID principles to your project with examples.

Jika sebuah program tidak mengikuti prinsip-prinsip OCP (Open-Closed Principle) dan DIP (Dependency Inversion Principle), maka akan menghadapi risiko keterikatan yang kuat antara *Controller* dan implementasi. Hal ini dapat mengakibatkan lingkungan pengujian yang buruk dan sulit untuk dengan mudah beralih antara implementasi untuk pengujian. Selain itu, ini akan menghambat perubahan atau penambahan implementasi baru di masa depan, karena kita harus memodifikasi *Controller* kita, yang berpotensi memperkenalkan lebih banyak bug dan overhead pemeliharaan.

Jika tidak mematuhi SRP (Single Responsibility Principle) dan membiarkan *Controller*, repositori, atau model menangani banyak tanggung jawab, maka akan berisiko sulit memahami dan memelihara kode kita sendiri. Ini bisa mengakibatkan peningkatan kompleksitas, bug, dan komunikasi yang lebih sulit dengan pengembang lain, dosen, dan asisten pengajar. Pengujian juga akan terhambat karena perlu menguji banyak tanggung jawab dalam satu pengujian, dan perubahan pada satu tanggung jawab akan berdampak pada tanggung jawab lainnya.

Jika tidak mengikuti LSP (Liskov Substitution Principle) dan ISP (Interface Segregation Principle), kita berisiko memiliki basis kode yang terikat erat dan kurang fleksibel karena antarmuka, abstraksi, atau kelas dasar dengan metode atau dependensi yang tidak perlu. Jika perlu menambah fitur baru atau memodifikasi yang sudah ada, mungkin perlu memodifikasi beberapa kelas.

Kesimpulannya, kerugian dari tidak mengimplementasikan SOLID adalah:

- Sulit menambahkan kode karena perlu banyak perubahan pada kode yang sudah ada.
- Kode sulit dibaca karena terlalu banyak tanggung jawab dalam satu metode.
- Pengujian menjadi sulit karena bergantung pada banyak bagian kode lain atau memiliki metode yang terlalu panjang.
- Sulit melakukan perubahan pada kode karena ketergantungan yang tinggi antar modul atau metode yang hanya cocok untuk tipe data tertentu.