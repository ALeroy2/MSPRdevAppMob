import fr.epsi.backend.controllers.CalculatorController;

public class Main {

    public static void main(String[] args) {
        System.out.println(new CalculatorController().getNetBuyingPrice(25, 5.2f));
    }
}
