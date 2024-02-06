package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
   private List<Product> productData = new ArrayList<>();
   
   public Product create(Product product){
    productData.add(product);
    return product;
   }

   public Product getById(String id){
    for (Product product : productData){
        if (product.getProductId().equals(id)){
            return product;
        }
    }
    return null;
  }

  public Product save(Product product){
    // int idxProductBefore = productData.indexOf(getById(product.getProductId()));
    int idxProductBefore = productData.indexOf(product);
    delete(product.getProductId());
    productData.add(idxProductBefore, product);
    return product;
  }

   public void delete(String id){  
    for (Product product : productData){
        if (product.getProductId().equals(id)){
            productData.remove(product);
            break;
        }
    }
  }

   public Iterator<Product> findAll(){
    return productData.iterator();
   }
}