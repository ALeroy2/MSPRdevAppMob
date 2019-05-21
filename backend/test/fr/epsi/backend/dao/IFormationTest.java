package fr.epsi.backend.dao;

import fr.epsi.backend.Main;
import fr.epsi.backend.daI.IFormation;
import fr.epsi.backend.domain.Formation;
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
public class IFormationTest {

    @Autowired
    IFormation dao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addFormation() {
        Formation formation = new Formation();
        formation.setName("Agile");
        Formation saved = dao.save(formation);
        assertThat(formation.getName(), is(dao.findById(saved.getId()).get().getName()));
    }

    @Test
    public void mergeFormation() {
        Formation formation = new Formation();
        formation.setName("React");
        formation = dao.save(formation);
        formation.setName("Node");
        Formation saved = dao.save(formation);
        assertThat(formation.getName(), is(dao.findById(saved.getId()).get().getName()));
    }
}