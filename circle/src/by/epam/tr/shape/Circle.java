package by.epam.tr.shape;

public class Circle {  
	 
    private double radius; 
	private double area; 
	private double perimeter; 


	public Circle(double radius) {
        this.radius = radius;
    } 


    public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

    public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPerimeter() {
		return perimeter;
	}


	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}


}