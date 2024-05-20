package spring.start.here.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.start.here.springboot.model.Product;
import spring.start.here.springboot.services.ProductService;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);

        return "products.html";
    }

    @PostMapping(path = "/products")
    public String addProduct(
            @RequestParam String name,
            @RequestParam Integer price,
            Model model
    ) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);

        return "products.html";
    }
}
