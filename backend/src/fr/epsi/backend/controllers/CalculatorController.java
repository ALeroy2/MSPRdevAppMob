package fr.epsi.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.epsi.backend.services.CalculatorService;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    private CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
    }

    @GetMapping("/discountRate")
    public float getDiscountRate(float net, float brut) {
        return this.calculatorService.getDiscountRate(net, brut);
    }

    @GetMapping("/netBuyingPrice")
    public float getNetBuyingPrice(float brut, float discountRate) {
        return this.calculatorService.getNetBuyingPrice(brut, discountRate);
    }

    @GetMapping("/netSellingPrice")
    public float getNetSellingPrice(float netBuyingPrice, float multiplicationCoeff) {
        return this.calculatorService.getNetSellingPrice(netBuyingPrice, multiplicationCoeff);
    }

    @GetMapping("/multiplicationCoeff")
    public float getMultiplicationCoeff(float netSellingPrice, float netBuyingPrice) {
        return this.calculatorService.getMultiplicationCoeff(netSellingPrice, netBuyingPrice);
    }
}