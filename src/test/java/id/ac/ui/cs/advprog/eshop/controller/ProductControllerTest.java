package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService service;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProductPage(){
        String pageString = productController.createProductPage(model);
        assertEquals("createProduct", pageString);
    }

    @Test
    void testCreateProductPost(){
        Product product = new Product();
        String pageString = productController.createProductPost(product, model);
        assertEquals("redirect:list", pageString);
        verify(service, times(1)).create(product);
    }

    @Test
    void testEditProductPage(){
        Product product = new Product();
        String pageString = productController.editProductPage(product.getProductId(), model);
        assertEquals("editProduct", pageString);
    }

    @Test
    void testUpdateProduct(){
        Product product = new Product();
        product.setProductName("Kue");
        product.setProductQuantity(5);

        productController.createProductPost(product, model);

        product.setProductName("Kue Lapis");
        product.setProductQuantity(1);

        String pageString = productController.updateProduct(product.getProductId(), product, model);
        assertEquals("redirect:list", pageString);
        verify(service, times(1)).create(product);
        verify(service, times(1)).updateProduct(product);

    }

    @Test
    void testDeleteProduct(){
        Product product = new Product();
        product.setProductName("Kue");
        product.setProductQuantity(5);

        productController.createProductPost(product, model);
        String pageString = productController.deleteProduct(product.getProductId());
        
        assertEquals("redirect:list", pageString);
        verify(service, times(1)).create(product);
        verify(service, times(1)).delete(product.getProductId());
    }

    @Test
    void testProductListPage(){
        List<Product> productList = new ArrayList<>();
        when(service.findAll()).thenReturn(productList);

        Product product1 = new Product();
        product1.setProductName("Kue");
        product1.setProductQuantity(1);
        productController.createProductPost(product1, model);
        
        Product product2 = new Product();
        product2.setProductName("Kue Talas");
        product2.setProductQuantity(5);
        productController.createProductPost(product2, model);
        
        Product product3 = new Product();
        product3.setProductName("Kue Lapis");
        product3.setProductQuantity(9);
        productController.createProductPost(product3, model);
        verify(service, times(3)).create(any(Product.class));

        String pageString = productController.productListPage(model);
        assertEquals("productList", pageString);
        verify(model, times(1)).addAttribute("products", productList);
    }
}
