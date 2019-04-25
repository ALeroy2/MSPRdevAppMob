package java.fr.epsi.backend.controllers;

import java.fr.epsi.backend.services.CalculatorService;

public class CalculatorController {
    private CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
    }
    public float getDiscountRate(float net, float brut) {
        return this.calculatorService.getDiscountRate(net, brut);
    }

    public float getNetBuyingPrice(float brut, float discountRate) {
        return this.calculatorService.getNetBuyingPrice(brut, discountRate);
    }

    public float getNetSellingPrice(float netBuyingPrice, float multiplicationCoeff) {
        return this.calculatorService.getNetSellingPrice(netBuyingPrice, multiplicationCoeff);
    }

    public float getMultiplicationCoeff(float netSellingPrice, float netBuyingPrice) {
        return this.calculatorService.getMultiplicationCoeff(netSellingPrice, netBuyingPrice);
    }
}