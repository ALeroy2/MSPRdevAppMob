package fr.epsi.backend.dao;

import fr.epsi.backend.Main;
import fr.epsi.backend.daI.IDrugstore;
import fr.epsi.backend.domain.Drugstore;
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
public class IDrugstoreTest {

    @Autowired
    IDrugstore dao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addDrugstore() {
        Drugstore drugstore = new Drugstore();
        drugstore.setLatitude(1000);
        drugstore.setLongitude(1000);
        drugstore.setName("Drugstore");
        drugstore.setCity("Nantes");
        Drugstore saved = dao.save(drugstore);
        assertThat(drugstore.getName(), is(dao.findById(saved.getId()).get().getName()));
    }

    @Test
    public void mergeDrugstore() {
        Drugstore drugstore = new Drugstore();
        drugstore.setName("React");
        drugstore.setCity("Nantes");
        drugstore = dao.save(drugstore);
        drugstore.setName("Node");
        drugstore.setCity("Lille");
        Drugstore saved = dao.save(drugstore);
        assertThat(drugstore.getName(), is(dao.findById(saved.getId()).get().getName()));
    }
}