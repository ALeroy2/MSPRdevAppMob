package fr.epsi.backend.controllers;

import fr.epsi.backend.domain.Product;
import fr.epsi.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productController")
public class ProductController {

    @Autowired
    ProductService productService;

    public ProductController() {
    }

    @RequestMapping("/getProduct")
    public Product getProduct(@RequestParam(name = "productId") Long productId) {
        return this.productService.getProduct(productId);
    }

    @RequestMapping("/postProduct")
    public void postProduct(@RequestParam(name = "productName") String productName) {
        Product product = new Product();
        product.setName(productName);
        this.productService.postProduct(product);
    }
}
