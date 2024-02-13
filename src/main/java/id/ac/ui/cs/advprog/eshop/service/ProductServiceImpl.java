package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public Product getProduct(String id){
        return productRepository.getById(id);
    }

    @Override
    public Product updateProduct(Product product){
        System.out.printf("di service, idnya %s itu %s\n", product.getProductName(), product.getProductId());
        productRepository.save(product);

        return product;
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }

    @Override 
    public List<Product> findAll(){
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }
}