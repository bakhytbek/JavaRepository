package by.epam.tr.shape;

public class Circle extends Shape {  
	 
    private static final double PI = Math.PI;   
    private double radius; 
 
    public Circle(double radius) {
        this.radius = radius;
    } 
 
    public double area(){
        return PI * Math.pow(radius, 2);
    }

    public double perimeter(){
        return 2* PI * radius;
    }

}