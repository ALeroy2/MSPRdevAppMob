package fr.epsi.backend.services;

import fr.epsi.backend.daI.IProduct;
import fr.epsi.backend.domain.Product;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductService {

    @Autowired
    IProduct dao;

    public ProductService() {
    }

    public Product getProduct(Long productId) {
        return this.dao.findById(productId).get();
    }

    public void postProduct(Product product) {
        this.dao.save(product);
    }

    public List<Product> getProducts() { return Lists.newArrayList(this.dao.findAll()); }
}
