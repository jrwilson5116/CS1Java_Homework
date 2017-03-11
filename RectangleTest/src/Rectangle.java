// Rectangle.java Rectangle class with accessor methods 
public class Rectangle {

	private double width;
	private double height;
	
	// Default constructor
	public Rectangle() {
		width = 1.0;
		height =1.0;
	}
	
	// Constructor with arguments
	public Rectangle(double w, double h){
		width = w;
		height = h;
	}
	
	// Return width
	public double getWidth() {
		return width;
	}
	
	// Return height
	public double getHeight(){
		return height;
	}
	
	// Set new width 
	public void setWidth(double newWidth){
		width = newWidth;
	}
	
	// Set new height
	public void setHeight(double newHeight){
		height = newHeight;
	}
	
	// Find area of the rectangle 
	public double findArea(){
		return (height  * width);
	}
	
}
