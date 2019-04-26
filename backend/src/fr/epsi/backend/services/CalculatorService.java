package fr.epsi.backend.services;

import org.springframework.stereotype.Service;

@Service("CalculatorService")
public class CalculatorService {

    public CalculatorService() {
    }

    public float getDiscountRate(float net, float brut) {
        return (1 - net / brut) * 100;
    }

    public float getNetBuyingPrice(float brut, float discountRate) {
        return brut * (1 - discountRate);
    }

    public float getNetSellingPrice(float netBuyingPrice, float multiplicationCoeff) {
        return netBuyingPrice * multiplicationCoeff;
    }

    public float getMultiplicationCoeff(float netSellingPrice, float netBuyingPrice) {
        return netSellingPrice / netBuyingPrice;
    }
}