# TUTORIAL 1 ADPRO
#### Daffa Mohamad Fathoni (2206824161)
#### Advanced Programming B / GEN

<hr>

## REFLECTION 1

### Clean Code Principles
Dalam pengembangan *software*, suatu aplikasi yang serba jadi tidak cukup untuk menjadikannya efisien mudah dipahami. Suatu kodingan harus menjadi elegan dan efisien dalam konsep *Clean Code*. Hal ini menjadi penting dalam *Software Craftsmanship* untuk menjunjung profesionalitas dalam pengembangan perangkat lunak.

#### 1. Meaningful Names
*Meaningful Names* berarti penamaan setiap komponen dalam kode kita yang secara jelas dan ringkas untuk mudah dipahami sehingga tidak diperlukan adanya *comment* yang menjelaskan variabel atau fungsi tersebut.

Contoh implementasinya sebagai berikut:
```java
public class Product {
    private String productId;
    private String productName;
    private int productQuantity;
}
```

#### 2. Function
*Function* dalam sebuah kode digunakan agar menjadikannya modular dan reusable ketika dibutuhkan lagi. Fungsinya harus ringkas dan hanya menjalankan satu jenis fungsi saja. Penamaan *function* juga harus deskriptif dan bermakna karena menggambarkan apa yang dilakukan fungsi tersebut.

Contoh implementasinya sebagai berikut:
```java
public Product getById(String id){
    for (Product product : productData){
        if (product.getProductId().equals(id)){
            return product;
        }
    }
    return null;
  }
```

#### 3. Comments
Penggunaan *comments* hanya untuk keperluan tentu saja, tidak dianjurkan untuk menjelaskan setiap kode dengan *comments* yang menjadikannya *redundant*. *Comment* biasa digunakan sebagai berikut:
1. Legal Comments
2. Informative Comments
3. Explanation of intents
4. Clarification
5. Warning of consequences
6. TODO Comments
7. Amplification

Dalam implementasi kode saya, nama fungsi dan variabel sudah cukup deskriptif sehingga tidak diperlukan *comments*.

#### 4. Objects and Data Structures
Dalam implementasi java yang merupakan bahasa pemrograman berbasis objek, terdapat pentingnya enkapsulasi dan abstraksi. Hal ini penting dalam implementasinya keamanan data. Implementasi yang digunakan sebagai berikut:

```java
public interface ProductService {
    public Product create(Product product);
    ...
}
```

```java
@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }
    ...
}
```

#### 5. Error Handling
Kode yang bersih tidak hanya mudah dibaca, tetapi juga harus kokoh dengan penanganan kesalahan sebagai hal yang modular, sesuatu yang dapat dilihat secara mandiri dari logika utama kita. Program kita bisa salah, dan programmer bertanggung jawab untuk menangani kesalahan yang mungkin terjadi.

Contoh implementasinya sebagai berikut:
```java
@Test
    void createProductPage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        WebElement checkInput = driver.findElement(By.className("btn"));
        checkInput.click();

        checkInput = driver.findElement(By.id("create-product"));
        checkInput.click();

        String titleCreateProduct = driver.getTitle();
        assertEquals("Create New Product", titleCreateProduct);
    }
```

#### 6. Version Control
Untuk pengintegrasian kodingan dengan *git* selama proses pengembangan, saya menghubungkan project Spring ini dengan Git dan remote git yaitu Github saya sendiri.

Saya mengimplementasikan *Feature Branch* untuk git ini agar memudahkan pengembangan setiap fiturnya. Di sini, saya membuat enam branch termasuk `main`, yaitu meliputi `delete-product`, `edit-product`, `functional-test`, `list-product`, dan `unit-test`.

#### 7. Testing
Dalam direktori `test`, saya sudah membuat `unit-test` dan `functional-test`. Dalam `unit-test`, saya membuat testing untuk `getter` dan `setter` model `Product`, serta fitur edit dan delete dalam aplikasi ini. 

Untuk `functional-test` saya membuat validasi halaman `HomePage` serta `ProductList` dan `CreateProduct`.

### Hal yang bisa di-improve
1. Bisa menambahkan *error handling* yang lebih konsisten sehingga tidak hanya pada function testing saja

2. Melakukan alur `commit` dan `merge` yang lebih rapih

3. Mengimplementasikan secure coding untuk memastikan keamanan data dan aplikasi dari potensi serangan eksternal

<hr>

## REFLECTION 2

### Unit Tests
Kegunaan unit test membantu saya untuk memeriksa dan memastikan bahwa kode dan fitur-fitur saya dapat berjalan sesuai yang diinginkan sehingga tidak perlu memeriksa secara satu per satu. Hal ini meyakinkan saya akan kekokohan struktur projek yang saya buat.

Jumlah unit tests dapat dibuat berdasarkan banyaknya fitur dan function yang dibuat seputar create, edit, dan delete product. Sangat penting untuk memeriksa dan meninjau segala aspek dari fitur yang dibuat agar menangani kasus-kasus tertentu.

### Code Coverage
Code coverage 100% tidak menjamin bahwa kode Anda bebas dari bug atau kesalahan. Code coverage hanya mengukur seberapa banyak kode yang dieksekusi saat menjalankan test suite, tetapi tidak mengevaluasi kualitas atau kelengkapan dari test suite itu sendiri.

Code coverage 100% hanya berarti bahwa semua fungsi, pernyataan, cabang, dan kondisi dalam kode Anda telah dipanggil setidaknya sekali saat menjalankan test suite. Namun, hal ini tidak menjamin bahwa semua skenario, kasus uji, atau perilaku yang diharapkan dari kode Anda telah diuji secara menyeluruh dan benar.


### Another Number of Items Functional Test
Ketika membuat function yang baru namun memiliki fungsionalitas yang sama dapat menjadikannya **redundant** sehingga dapat menurunkan kualitas dan kebersihan kode.

Yang dapat bisa dilakukan adalah cukup dibuat dalam satu uji suite untuk memverifikasi `number of items` tersebut sehingga tidak diperlukan menambahkan duplikasi kode yang sama lagi pada suite yang berbeda. Lalu memberikan nama yang deskriptif dan menghapus atau memindahkan variabel yang tidak relevan pada functional test tersebut.