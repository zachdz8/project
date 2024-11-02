import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scan;
    private String coordinate1;
    private String coordinate2;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        while (true) {
            getCoordinates();
            LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
            System.out.println();
            System.out.println(equation.lineInfo());
            calculateAndDisplayPointOnLine(equation);
            if (!askToContinue()) {
                break;
            }
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }

    private void getCoordinates() {
        System.out.println("Enter coordinate 1: ");
        coordinate1 = scan.nextLine();
        System.out.println("Enter coordinate 2: ");
        coordinate2 = scan.nextLine();
        x1 = parseX(coordinate1);
        x2 = parseX(coordinate2);
        y1 = parseY(coordinate1);
        y2 = parseY(coordinate2);
    }

    private void calculateAndDisplayPointOnLine(LinearEquation equation) {
        double xCoord;
        if (x2 - x1 != 0) {
            System.out.println("Enter a value for x: ");
            xCoord = scan.nextDouble();
            scan.nextLine();
            System.out.println();
            System.out.println("The point on the line is: " + equation.coordinateForX(xCoord));
        }
    }

    private boolean askToContinue() {
        System.out.println();
        System.out.println("Would you like to enter another pair of coordinates? y/n: ");
        String response = scan.nextLine();
        return response.equalsIgnoreCase("y");
    }

    public int parseX(String coordinate) {
        int idx = coordinate.indexOf(",");
        return Integer.parseInt(coordinate.substring(1, idx));
    }

    public int parseY(String coordinate) {
        int idx = coordinate.indexOf(",");
        int idx1 = coordinate.indexOf(")");
        return Integer.parseInt(coordinate.substring(idx + 2, idx1));
    }
}


