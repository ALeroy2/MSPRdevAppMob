package fr.epsi.backend.services;

import fr.epsi.backend.daI.IDrugstore;
import fr.epsi.backend.domain.Drugstore;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("DrugstoreService")
public class DrugstoreService {

    @Autowired
    IDrugstore dao;

    public DrugstoreService() {}

    public Drugstore getDrugstore(Long drugstoreId) {
        return dao.findById(drugstoreId).get();
    }

    public List<Drugstore> getDrugstores(float longitude, float latitude) {
        List<Drugstore> drugstores = Lists.newArrayList(dao.findAll());
        Collections.sort(drugstores, (o1, o2) -> (int) (o1.getDistance(longitude, latitude) - (o2.getDistance(longitude, latitude))));
        return drugstores.stream().limit(10).collect(Collectors.toList());
    }

    public void postDrugstore(Drugstore drugstore) {
        dao.save(drugstore);
    }
}
