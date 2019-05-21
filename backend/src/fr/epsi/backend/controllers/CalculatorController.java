package fr.epsi.backend.controllers;

import fr.epsi.backend.services.CalculatorService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculatorController")
public class CalculatorController {
    private CalculatorService calculatorService = new CalculatorService();

    public CalculatorController() {
    }

    @RequestMapping("/discountRate")
    public float getDiscountRate(@RequestParam(value = "net") float net
                                , @RequestParam(value = "brut") float brut) {
        return this.calculatorService.getDiscountRate(net, brut);
    }

    @RequestMapping("/netBuyingPrice")
    public float getNetBuyingPrice(@RequestParam(value = "brut") float brut
                                    , @RequestParam(value = "discountRate") float discountRate) {
        return this.calculatorService.getNetBuyingPrice(brut, discountRate);
    }

    @RequestMapping("/netSellingPrice")
    public float getNetSellingPrice(@RequestParam(value = "netBuyingPrice") float netBuyingPrice
                                    , @RequestParam(value = "multiplicationCoeff") float multiplicationCoeff) {
        return this.calculatorService.getNetSellingPrice(netBuyingPrice, multiplicationCoeff);
    }

    @RequestMapping("/multiplicationCoeff")
    public float getMultiplicationCoeff(@RequestParam(value = "netSellingPrice") float netSellingPrice
                                        , @RequestParam(value = "netBuyingPrice") float netBuyingPrice) {
        return this.calculatorService.getMultiplicationCoeff(netSellingPrice, netBuyingPrice);
    }
}