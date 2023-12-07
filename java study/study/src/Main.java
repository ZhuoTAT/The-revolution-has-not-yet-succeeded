import java.util.*;
class Fan {
    public final int SlOW=1;
    public final int MEDIUM=2;
    public final int FAST=3;
    private int speed=SlOW;
    private boolean on=false;
    private double radius=5;
    private String color="white";
    Fan(){}
    Fan(int fanSpeed,boolean fanOn,double fanRadius,String fanColor){
        speed=fanSpeed;
        on=fanOn;
        radius=fanRadius;
        color=fanColor;
    }
    public String toString() {
        String s="speed "+speed+"\n";
        s+="color "+color+"\n";
        s+="radius "+radius+"\n";
        if(on==false) {
            s+="fan is off";
        }else {
            s+="fan is on";
        }
        return s;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("-------\n"
                + "Default\n"
                + "-------");
        Fan fan1=new Fan();
        System.out.println(fan1.toString());
        System.out.println("-------\n"
                + "My Fan\n"
                + "-------");
        Scanner in=new Scanner(System.in);
        int fanSpeed=in.nextInt() ;
        boolean fanOn=in.nextBoolean();
        double fanRadius=in.nextDouble();
        String fanColor=in.next();
        Fan fan2=new Fan(fanSpeed, fanOn,fanRadius,fanColor);
        System.out.println(fan2.toString());
    }
}