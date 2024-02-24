package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService service;

    private String redirectList = "redirect:list";

    @GetMapping("/create")
    public String createProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model){
        service.create(product);
        return redirectList;
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable String id, Model model){
        model.addAttribute("product", service.getProduct(id));
        return "editProduct";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute Product product){
        service.updateProduct(product);
        return redirectList;
    }

    @GetMapping("/{id}")
    public String deleteProduct(@PathVariable String id){
        service.delete(id);
        return redirectList;
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }
}