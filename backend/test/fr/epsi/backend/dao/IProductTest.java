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
        Product product = new Product();
        product.setName("Doliprane");
        Drugstore ds = new Drugstore();
        ds.setName("SSY");
        ds.setLatitude(123);
        ds.setLongitude(456);

        Product saved = dao.save(product);;
        assertThat(product.getName(), is(dao.findById(saved.getId()).get().getName()));
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