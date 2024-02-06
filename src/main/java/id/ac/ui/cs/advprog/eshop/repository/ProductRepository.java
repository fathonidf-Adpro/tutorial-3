package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
   private List<Product> productData = new ArrayList<>();
   private int idCounter = 0;
   
   public Product create(Product product){
    productData.add(product);
    product.setId(++idCounter);
    return product;
   }

   public Product getById(long id){
    for (Product product : productData){
        if (product.getId() == id){
            return product;
        }
    }
    return null;
  }

  public Product save(Product product){
    int idxProductBefore = productData.indexOf(getById(product.getId()));
    delete(product.getId());
    productData.add(idxProductBefore, product);
    return product;
  }

   public void delete(long id){  
    for (Product product : productData){
        if (product.getId() == id){
            productData.remove(product);
            break;
        }
    }
  }

   public Iterator<Product> findAll(){
    return productData.iterator();
   }
}