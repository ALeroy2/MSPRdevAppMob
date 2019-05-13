package fr.espi.backend.services;

import fr.epsi.backend.services.CalculatorService;
import junit.framework.TestCase;
import org.junit.Test;

public class TestCalculatorService extends TestCase {

    @Test
    public void testGetDiscountRate() {
        float net = 1000;
        float brut = 1200;
        float calcul = (1 - net / brut) * 100;
        assertEquals(calcul, new CalculatorService().getDiscountRate(net, brut));
    }

    @Test
    public void testGetNetBuyingPrice() {
        float brut = 1000;
        float discountRate = 5.2f;
        float calcul = brut * ((100 - discountRate)/100);
        assertEquals(calcul, new CalculatorService().getNetBuyingPrice(brut, discountRate));
    }

    @Test
    public void testGetNetSellingPrice() {
        float netBuyingPrice = 150;
        float multiplicationCoeff = 2.5f;
        float calcul = netBuyingPrice * multiplicationCoeff;
        assertEquals(calcul, new CalculatorService().getNetSellingPrice(netBuyingPrice, multiplicationCoeff));
    }

    @Test
    public void testGetMultiplicationCoeff() {
        float netSellingPrice = 1500;
        float netBuyingPrice = 1450;
        float calcul = netSellingPrice / netBuyingPrice;
        assertEquals(calcul, new CalculatorService().getMultiplicationCoeff(netSellingPrice, netBuyingPrice));
    }
}
