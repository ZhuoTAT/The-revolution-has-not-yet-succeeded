import java.util.Scanner;
class Circle{
    int radius=1;
    void setRadius(int radius){
        if(radius>0){
            this.radius=radius;
        }
    }
}
class Geometry{
    Circle c;
    void setCircle(Circle c){
        c.radius+=10;
        this.c=c;
    }
}
public class Main {
    public static void main(String[] args) {
        Circle circle=new Circle();
        circle.setRadius(10);
        Geometry geometry=new Geometry();
        int r=circle.radius;
        geometry.setCircle(circle);
        System.out.printf("%d:%d:%d",r,geometry.c.radius,circle.radius);
    }
}