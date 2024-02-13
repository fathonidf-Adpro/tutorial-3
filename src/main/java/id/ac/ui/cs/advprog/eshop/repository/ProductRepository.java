package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
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
    String productUpdateId = productUpdate.getProductId();

    Product productInRepository = this.getById(productUpdateId);
    int idxProductBefore = productData.indexOf(productInRepository);
    System.out.println(productData);
    System.out.printf("%s ada di index %d", productInRepository, idxProductBefore);
    productData.set(idxProductBefore, productUpdate);





    // Product product = null;
    // Product productBefore = getById(productUpdate.getProductId());
    // int idxProductBefore = productData.indexOf(productBefore);
    // delete(productUpdate.getProductId());
    // for (Product productIterate : productData){
    //   if(productIterate.getProductId().equals(productUpdate.getProductId())){
    //       productIterate.setProductName(productUpdate.getProductName());
    //       productIterate.setProductQuantity(productUpdate.getProductQuantity());
    //       product = productIterate;
    //   }
    // }
    // productData.add(idxProductBefore, product);
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