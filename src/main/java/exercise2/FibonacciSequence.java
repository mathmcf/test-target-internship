package exercise2;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence {
    private final List<Long> fiboSequence;

    public FibonacciSequence() {
        this.fiboSequence = new ArrayList<>();
    }

    private void addFirstAndSecondElementsOnFiboSequence() {
        this.fiboSequence.add(0L);
        this.fiboSequence.add(1L);
    }

    public void findElementAndGenerateFibonacciSequence(long searchedElement) {

        boolean isFound = false;
        long nextElement;

        this.addFirstAndSecondElementsOnFiboSequence();

        int i = 2;

        while (true) {

            nextElement = this.fiboSequence.get(i - 1) + this.fiboSequence.get(i - 2);
            this.fiboSequence.add(nextElement);

            if (checkIfElementInSequenceIsLargerThanSearchedElement(nextElement, searchedElement)) break;

            if (checkIfElementInSequenceEqualsSearchedElement(nextElement, searchedElement)) {
                isFound = true;
                break;
            }

            i++;
        }

        printResult(searchedElement, isFound);
    }

    private boolean checkIfElementInSequenceIsLargerThanSearchedElement(long element, long searchedElement) {
        return element > searchedElement;
    }

    private boolean checkIfElementInSequenceEqualsSearchedElement(long element, long searchedElement) {
        return element == searchedElement;
    }

    private void printResult(long searchedElement, boolean isFound) {

        System.out.printf("Sequência de Fibonacci %s %n", this.fiboSequence);

        if (isFound) {
            System.out.printf("O elemento %s foi encontrado na sequência de Fibonacci.%n", searchedElement);
        } else {
            System.out.printf("O elemento %s NÃO pertence à sequência de Fibonacci. %n", searchedElement);
        }
    }

}
