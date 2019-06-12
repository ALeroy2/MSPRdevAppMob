package fr.epsi.backend.dao;

import fr.epsi.backend.Main;
import fr.epsi.backend.daI.IProduct;
import fr.epsi.backend.domain.Drugstore;
import fr.epsi.backend.domain.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith( SpringRunner.class )
@SpringBootTest(classes = Main.class)
public class IProductTest {

    @Autowired
    IProduct dao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addProduct() {
        Product product = new Product("Doliprane", 25, 30);
        Product product1 = new Product("Efferalgan", 15, 40);
        Product product2 = new Product("Dolirhume", 32, 54);
        Product product3 = new Product("Strepsil", 18, 26);
        Product product4 = new Product("Alban", 22, 47);
        Product product5 = new Product("Lafont", 12, 24);
        dao.save(product);
        dao.save(product1);
        dao.save(product2);
        dao.save(product3);
        dao.save(product4);
        dao.save(product5);
    }

    @Test
    public void mergeProduct() {
        Product product = new Product();
        product.setName("Viagra");
        product = dao.save(product);
        product.setName("Ibuprofène");
        Product saved = dao.save(product);
        assertThat(product.getName(), is(dao.findById(saved.getId()).get().getName()));
    }
}