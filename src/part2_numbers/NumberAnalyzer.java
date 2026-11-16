package part2_numbers;

import java.util.ArrayList;
import java.util.Random;

// Part 2. Number Analysis
public class NumberAnalyzer {

    private ArrayList<Integer> numbers = new ArrayList<>();

    // Part 2.1 addNumber
    public void addNumber(int n) {
        numbers.add(n);
    }

    // Part 2.2 getAverage
    public double getAverage() {
        if (numbers.isEmpty()) return 0;
        int sum = 0;
        for (int n : numbers) sum += n;
        return (double) sum / numbers.size();
    }

    // Part 2.3 getMax
    public int getMax() {
        int max = numbers.get(0);
        for (int n : numbers) {
            if (n > max) max = n;
        }
        return max;
    }

    // Part 2.4 getMin
    public int getMin() {
        int min = numbers.get(0);
        for (int n : numbers) {
            if (n < min) min = n;
        }
        return min;
    }

    // Part 2.5 removeNegativeNumbers
    public void removeNegativeNumbers() {
        numbers.removeIf(n -> n < 0); // минусы долой
    }

    // вывод всего
    public void printStats() {
        System.out.println("Numbers: " + numbers);
        if (numbers.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        System.out.printf("Average: %.2f%n", getAverage());
        System.out.println("Max: " + getMax());
        System.out.println("Min: " + getMin());
    }

    // Part 2.6 Demo
    public static void main(String[] args) {
        NumberAnalyzer an = new NumberAnalyzer();
        Random rnd = new Random();

        // 10 рандомных от -50 до 50
        for (int i = 0; i < 10; i++) {
            an.addNumber(rnd.nextInt(101) - 50);
        }

        System.out.println("--- Before removing negatives ---");
        an.printStats();

        an.removeNegativeNumbers();

        System.out.println("--- After removing negatives ---");
        an.printStats();
    }
}
