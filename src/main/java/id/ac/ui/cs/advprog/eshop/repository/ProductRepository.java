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
    Product product = null;
    for (int i = 0; i< productData.size(); i++ ){
      if(productData.get(i).getProductId().equals(id)){
        product = productData.get(i);
      }
    }
    return product;
  }

  public Product save(Product productUpdate){
    Product product = null;
    for (Product productIterate : productData){
      if(productIterate.getProductId().equals(productUpdate.getProductId())){
          productIterate.setProductName(productUpdate.getProductName());
          productIterate.setProductQuantity(productUpdate.getProductQuantity());
          product = productIterate;
      }
  }
  return product;
  }

   public Product delete(String id){
    Product deletedProduct = getById(id);
    productData.remove(deletedProduct);
    return deletedProduct;
  }

   public Iterator<Product> findAll(){
    return productData.iterator();
   }
}