package fr.epsi.backend.controllers;

import fr.epsi.backend.domain.Drugstore;
import fr.epsi.backend.services.DrugstoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drugstoreController")
public class DrugstoreController {

    private DrugstoreService drugstoreService;

    public DrugstoreController() {
        this.drugstoreService = new DrugstoreService();
    }

    @RequestMapping("/getDrugstore")
    public Drugstore getDrugstore(@RequestParam(name = "drugstoreId") Long drugstoreId) {
        return this.drugstoreService.getDrugstore(drugstoreId);
    }

    @RequestMapping("/getDrugstores")
    public List<Drugstore> getDrugstores(@RequestParam(name = "longitude") float longitude
                                            , @RequestParam(name = "latitude") float latitude) {
        return this.drugstoreService.getDrugstores(longitude, latitude);
    }

    @RequestMapping("/postDrugstore")
    public void postDrugstore(@RequestParam(name = "drugstoreName") String name
                              , @RequestParam(name = "drugstoreLongitude") int longitude
                              , @RequestParam(name = "drugstoreLatitude") int latitude) {
        Drugstore drugstore = new Drugstore();
        drugstore.setName(name);
        drugstore.setLongitude(longitude);
        drugstore.setLatitude(latitude);
        this.drugstoreService.postDrugstore(drugstore);
    }
}
