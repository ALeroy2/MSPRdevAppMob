package fr.epsi.backend.services;

import fr.epsi.backend.daI.IFormation;
import fr.epsi.backend.domain.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FormationService")
public class FormationService {

    @Autowired
    IFormation dao;

    public FormationService() {}

    public Formation getFormation(Long productId) {
        return dao.findById(productId).get();
    }
}

