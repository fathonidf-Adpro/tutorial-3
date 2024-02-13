package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProduct() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(createdProduct);
    }

    @Test
    void findAllProducts() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);
        productService.create(product);

        when(productRepository.findAll()).thenReturn(List.of(product).iterator());
        Iterator<Product> foundProducts = productService.findAll().iterator();

        assertTrue(foundProducts.hasNext());
        Product savedProduct = foundProducts.next();

        assertEquals(product, savedProduct);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void findProductById() {
        Product product = new Product();
        String productId = product.getProductId();
        when(productRepository.getById(productId)).thenReturn(product);

        Product foundProduct = productService.getProduct(productId);

        assertEquals(product, foundProduct);
        verify(productRepository, times(1)).getById(productId);
    }

    @Test
    void editProduct() {
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);

        Product editedProduct = productService.updateProduct(product);

        assertEquals(product, editedProduct);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void deleteProduct() {
        Product product = new Product();
        String productId = product.getProductId();
        when(productRepository.delete(productId)).thenReturn(product);

        productService.delete(productId);

        verify(productRepository, times(1)).delete(productId);
    }
}
