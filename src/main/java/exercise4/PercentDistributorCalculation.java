package exercise4;

import java.util.HashMap;
import java.util.Map;

public class PercentDistributorCalculation {

    private final Map<String, Double> stateBilling;

    private final Map<String, Double> stateBillingPercentual;

    public PercentDistributorCalculation(Map<String, Double> stateBilling) {
        this.stateBilling = stateBilling;
        this.stateBillingPercentual = new HashMap<>();
    }

    public void processPercentualDistributorCompany() {

        Double sumBillingAllStates = 0D;

        for (var entry : this.stateBilling.entrySet()) {
            sumBillingAllStates += entry.getValue();
        }

        for (var entry : this.stateBilling.entrySet()) {
            this.stateBillingPercentual.put(entry.getKey(), entry.getValue() / sumBillingAllStates);
        }

    }

    public void printPercentualCalculated() {

        System.out.println("O cálculo do percentual é: \n");

        for (var entry : this.stateBillingPercentual.entrySet()) {
            System.out.printf("%s : %.2f %% %n", entry.getKey(), entry.getValue() * 100);
        }

    }

    public Map<String, Double> getStateBilling() {
        return stateBilling;
    }

    public Map<String, Double> getStateBillingPercentual() {
        return stateBillingPercentual;
    }

}
