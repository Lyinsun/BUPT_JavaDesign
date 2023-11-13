import java.util.Scanner;

public class RegularPolygonConstruct {
    public static void main(String[] args) {
        RegularPolygon r1 = new RegularPolygon();
        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());

        RegularPolygon r2= new RegularPolygon(6, 4);
        System.out.println(r2.getArea());
        System.out.println(r2.getPerimeter());

        RegularPolygon r3= new RegularPolygon(10, 4, 5.6,7.8);
        System.out.println(r3.getArea());
        System.out.println(r3.getPerimeter());



    }
}

class RegularPolygon{
    private int n;
    private double side;
    private double x;
    private double y;

    public RegularPolygon(){
        this(3,1,0,0);
    };

    public RegularPolygon(int n, double side){
        this.n = n;
        this.side = side;
        this.x = 0;
        this.y = 0;
    };
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    };
    public double getPerimeter(){
        return n * side;
    };
    public double getArea(){
        return n * side * side/(4*Math.tan(Math.PI/n));
    }


    public int getN() {
        return n;
    };
    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }


}