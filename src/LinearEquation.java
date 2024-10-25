public class LinearEquation {




    private double x1;
    private double x2;
    private double y1;
    private double y2;




    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }




    public double distance(){
        return roundedtoHundredth(Math.sqrt(Math.pow(y2-y1,2) + Math.pow(x2-x1,2)));
    }




    public double slope() {
        return roundedtoHundredth(((y2-y1)/(x2-x1)));
    }




    public double yIntercept() {
        return roundedtoHundredth(y1-((slope())*x1));
    }




    public String equation(){
        double deltaX = x2-x1;
        double deltaY = y2-y1;
        String str = "";


        if(deltaY!=0) {
            str += "y= " + deltaY + "/" + deltaX + "x + " + yIntercept() ;
        } else {
            return "\n y= " + yIntercept();
        }


        return str;
    }


    public String coordinateForX(double x) {
        return "(" + x + ", " + (slope() * x + yIntercept()) + ")";
    }


    public String lineInfo() {
        String str = "";
        str+= "The two points are: (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")";
        str+= "\nThe equation of the line is: " + equation();
        str += "\n The y-intercept of the line is: " + yIntercept();
        str += "\n The slope of the line: " + slope();
        str+= "\n The distance between the points is: " + distance();
        return str;
    }


    private double roundedtoHundredth(double toRound) {
        return Math.round(toRound*100)/100.0;
    }
}

