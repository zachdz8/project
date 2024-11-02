public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return roundedtoHundredth(Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2)));
    }

    public double slope() {
        return roundedtoHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public double yIntercept() {
        return roundedtoHundredth(y1 - ((slope()) * x1));
    }

    public String equation() {
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;
        String str = "y = ";

        if (deltaY == 0) {
            return str + yIntercept();
        }

        if (deltaY % deltaX == 0) {
            double slope = (double) deltaY / deltaX;
            if (slope == 1) {
                str += "x";
            } else if (slope == -1) {
                str += "-x";
            } else {
                str += slope + "x";
            }
        } else {
            if (deltaY < 0 && deltaX > 0) {
                str += deltaY + "/" + deltaX + "x";
            } else if (deltaY > 0 && deltaX < 0) {
                str += -deltaY + "/" + -deltaX + "x";
            } else if (deltaY < 0 && deltaX < 0) {
                str += -deltaY + "/" + -deltaX + "x";
            } else {
                str += deltaY + "/" + deltaX + "x";
            }
        }

        double yIntercept = yIntercept();
        if (yIntercept > 0) {
            str += " + " + yIntercept;
        } else if (yIntercept < 0) {
            str += " - " + Math.abs(yIntercept);
        }

        return str;
    }

    public String coordinateForX(double x) {
        double calculatedY;
        if (slope() == 0) {
            calculatedY = yIntercept();
        } else {
            calculatedY = slope() * x + yIntercept();
        }
        return "(" + x + ", " + calculatedY + ")";
    }

    public String lineInfo() {
        String str = "";
        if (x2 != x1) {
            str += "The two points are: (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")";
            str += "\nThe equation of the line is: " + equation();
            str += "\nThe y-intercept of the line is: " + yIntercept();
            str += "\nThe slope of the line: " + slope();
            str += "\nThe distance between the points is: " + distance();
        } else {
            str += "These points are on a vertical line x = " + x1;
        }
        return str;
    }

    private double roundedtoHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}


