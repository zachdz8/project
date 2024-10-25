
import java.util.Scanner;




public class LinearEquationLogic {
    private Scanner scan;
    private String coordinate1;
    private String coordinate2;
    private int x1;
    private int y1;
    private int x2;
    private int y2;




    public  LinearEquationLogic(){
        scan = new Scanner(System.in);
    }


    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        System.out.println("Enter coordinate 1: ");
        coordinate1 = scan.nextLine();
        System.out.println("Enter coordinate 2: ");
        coordinate2 = scan.nextLine();
        x1 = parseX(coordinate1);
        x2 = parseX(coordinate2);
        y1 = parseY(coordinate1);
        y2 = parseY(coordinate2);
        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
        System.out.println();
        System.out.println(equation.lineInfo());
    }




    public int parseX(String coordinate) {
        int idx = coordinate1.indexOf(",");
        int x1 = Integer.parseInt(coordinate1.substring(1,idx));
        return x1;
    }


    public int parseY(String coordinate) {
        int idx = coordinate1.indexOf(",");
        int idx1 = coordinate1.indexOf(")");
        int y1 = Integer.parseInt(coordinate1.substring(idx+2,idx1));
        return y1;
    }
}

