package Assignment_PartB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mysqroot2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Enter the command line");
            return;
        }

        String inputFile = args[0];

        try (BufferedReader read = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = read.readLine()) != null) {
                try {
                    double number = Double.parseDouble(line.trim());
                    if (number <= 0) {
                        System.out.println("Invalid number:" + number);
                        continue;
                    }

                    double squareRoot = calculateSquareRoot(number);
                    System.out.printf("The square root of %.4f is %.4f\n", number, squareRoot);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static boolean isValidNum(double number) {
        return number >= 0;
    }

    private static double calculateSquareRoot(double number) {
        double startingNumber = 1;
        double newNumber = 0;

        for (int i = 0; i <= 25; i++) {
            newNumber = startingNumber - (startingNumber * startingNumber - number) / (2 * startingNumber);

            if (Math.abs(number - startingNumber) <= 0.001) {
                break;
            }
            startingNumber = newNumber;
        }
        return newNumber;
    }
}