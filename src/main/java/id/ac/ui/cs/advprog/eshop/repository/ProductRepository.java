package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
   private List<Product> productData = new ArrayList<>();
   
   public Product create(Product product){
    UUID uuid = UUID.randomUUID();
    product.setProductId(uuid.toString());
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
    String productUpdateId = productUpdate.getProductId();
    Product productInRepository = this.getById(productUpdateId);
    int idxProductBefore = productData.indexOf(productInRepository);
    productData.set(idxProductBefore, productUpdate);
    return productUpdate;
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