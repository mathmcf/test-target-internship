import exercise2.FibonacciSequence;
import exercise3.ProcessBilling;
import exercise3.ReadJson;
import exercise4.PercentDistributorCalculation;
import exercise5.RevertedString;

import java.util.Map;

public class ExecuteExercises {

    public static void main(String[] args) {

        System.out.println("================================================================================");

        /* Exercício 2: */
        System.out.println("Exercise 2: \n");

        long numberToFindOnFibonacciSequence = 7L;

        System.out.printf("Validando se o número %s existe na sequência de Fibonacci %n", numberToFindOnFibonacciSequence);

        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        fibonacciSequence.findElementAndGenerateFibonacciSequence(numberToFindOnFibonacciSequence);

        System.out.println("--------------------------------------------------------------------------------");

        /* Exercício 3: */
        System.out.println("Exercise 3: \n");

        var readJson = new ReadJson();
        var billingDays = readJson.readJsonBillingFile();

        ProcessBilling processBilling = new ProcessBilling(billingDays);
        processBilling.process();

        System.out.println("--------------------------------------------------------------------------------");

        /* Exercício 4: */
        System.out.println("Exercise 4: \n");

        Map<String, Double> stateBilling = Map.of(
                "SP", 67836.43,
                "RJ", 36678.66,
                "MG", 29229.88,
                "ES", 27165.48,
                "Outros", 19849.53
        );

        var percentDistributorCalculation = new PercentDistributorCalculation(stateBilling);

        percentDistributorCalculation.processPercentualDistributorCompany();
        percentDistributorCalculation.printPercentualCalculated();

        System.out.println("--------------------------------------------------------------------------------");
        /* Exercício 5: */
        System.out.println("Exercise 5:\n");

        String word = "java";
        String reversedWord = RevertedString.revertString(word);
        System.out.printf("A palavra %s invertida é %s %n", word, reversedWord);
        System.out.println("================================================================================");


    }

}
