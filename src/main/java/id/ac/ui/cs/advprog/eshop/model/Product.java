package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private long productId;
    private String productName;
    private int productQuantity;

    public long getId() {
        return this.productId;
    }

    public String getName() {
        return this.productName;
    }

    public void setId(long id) {
        this.productId = id;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public void setQuantity(int quantity) {
        this.productQuantity = quantity;
    }
}