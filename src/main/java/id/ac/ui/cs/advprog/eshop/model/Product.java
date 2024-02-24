package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Product {
    protected String productId;
    protected String productName;
    protected int productQuantity;

    public String toString(){
      return String.format("%s:%d", productName, productQuantity);
    }
}