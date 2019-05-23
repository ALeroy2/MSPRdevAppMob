package fr.epsi.backend.services;

import fr.epsi.backend.Main;
import fr.epsi.backend.daI.IDrugstore;
import fr.epsi.backend.domain.Drugstore;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith( SpringRunner.class )
@SpringBootTest(classes = Main.class)
public class TestDrugstoreService extends TestCase {

    @Autowired
    IDrugstore dao;

    @Autowired
    DrugstoreService drugstoreService;

    @Test
    public void testGetDrugstores() {
        for (int i = 0; i < 20; i++) {
            Drugstore drugstore = new Drugstore("drugstore" + i, "Nantes", i * 2, i * 2);
            dao.save(drugstore);
        }

        assertThat(10, is(drugstoreService.getDrugstores(0, 0).size()));
    }
}
