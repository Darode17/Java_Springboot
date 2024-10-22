package Assignment_PartA;

public class mysqroot {

    public static void main(String[] args){
        if (args.length <= 0){
            System.out.println("Number not provided");
            return;
        }
        double number;
        String argument = args[0];
        try{
                number = Double.parseDouble(argument);

                if (number <= 0){
                    System.out.println("Incorrect number");
                    return;
                }
            }catch(NumberFormatException e){
                System.out.println("Incorrect input.Enter valid input.");
                return;
            }

        if(!isValidNum(number)) {
            System.out.println("The number is invalid.");
            return;
        }        
        double squareRoot = calculateSquareRoot(number);

        System.out.printf("%.4f %.4f\n", number, squareRoot);
    }

    public static boolean isValidNum(double number){
        return number >= 0;
    }

    private static double calculateSquareRoot(double number){
        double startingnumber = 1; 
        double newNumber=0;
        double num =number;

        for (int i = 0; i <= 25; i++){
            newNumber = startingnumber - (startingnumber * startingnumber - number) / (2 * startingnumber);

            if (number - startingnumber <= 0.001){
                break;
            }
            startingnumber = newNumber;
        }
        
       System.out.printf("%.4f %.4f\n",num,newNumber);
        return newNumber;
    }
}