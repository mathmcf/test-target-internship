package exercise3;

public class ProcessBilling {

    private final BillingDay[] billingDays;

    public ProcessBilling(BillingDay[] billingDays) {
        this.billingDays = billingDays;
    }

    public void process() {

        var lowestBillingDay = calculateLowestOrLargestBillingDay(OperationEnum.LOWEST);
        var largestBillingDay = calculateLowestOrLargestBillingDay(OperationEnum.LARGEST);
        var billingDaysMoreThanAverage = getBillingDaysMoreThanAverage();
        printResults(lowestBillingDay, largestBillingDay, billingDaysMoreThanAverage);
    }

    private BillingDay calculateLowestOrLargestBillingDay(OperationEnum operationEnum) {

        BillingDay lowestBillingDay = billingDays[0];
        BillingDay largestBillingDay = billingDays[0];

        for (BillingDay billingDay : this.billingDays) {

            if (billingDay.getValor() > 0 && lowestBillingDay.getValor() > billingDay.getValor()) {
                lowestBillingDay = billingDay;
            }

            if (largestBillingDay.getValor() < billingDay.getValor()) {
                largestBillingDay = billingDay;
            }
        }

        return OperationEnum.LOWEST.equals(operationEnum) ? lowestBillingDay : largestBillingDay;

    }

    private double calculateBillingDaysAverage() {

        int countBillings = 0;
        double sumBillings = 0;
        double avarageBilling;

        for (BillingDay billingDay : this.billingDays) {

            if (billingDay.getValor() != 0) {
                sumBillings += billingDay.getValor();
                countBillings++;
            }
        }

        avarageBilling = sumBillings / countBillings;

        return avarageBilling;

    }

    private BillingDay[] getBillingDaysMoreThanAverage() {

        var average = calculateBillingDaysAverage();

        BillingDay[] billingDaysMoreThanAverage = new BillingDay[this.billingDays.length];

        int filledPosition = 0;

        for (BillingDay billingDay : this.billingDays) {

            if (billingDay.getValor() > average) {
                billingDaysMoreThanAverage[filledPosition] = billingDay;
                filledPosition++;
            }
        }

        return billingDaysMoreThanAverage;
    }

    private void printResults(BillingDay lowestBillingDay, BillingDay largestBillingDay, BillingDay[] billingDaysMoreThanAverage) {

        System.out.printf("O menor valor do faturamento diário do mês foi no dia %s - %s %n%n", lowestBillingDay.getDia(), lowestBillingDay.getValor());

        System.out.printf("O maior valor do faturamento diário do mês foi no dia %s - %s %n%n", largestBillingDay.getDia(), largestBillingDay.getValor());

        System.out.println("Os dias em que o faturamento diário é maior do que o faturamento médio são: \n");

        for (BillingDay billingDay : billingDaysMoreThanAverage) {

            if (billingDay != null) {
                System.out.printf("Dia: %s , Faturamento %s %n", billingDay.getDia(), billingDay.getValor());
            }
        }

    }

}
