// Rectangle.java Rectangle class with accessor methods 

package testbox;

public class Rectangle {

	private double width;
	private double height;
	private String color;
        
	// Default constructor
	public Rectangle() {
		width = 1.0;
		height =1.0;
                color = "white";
	}
	
	// Constructor with arguments
	public Rectangle(double w, double h,String c){
		width = w;
		height = h;
                color = c;
	}
	
	// Return width
	public double getWidth() {
		return width;
	}
	
	// Return height
	public double getHeight(){
		return height;
	}
        
        // Return color
        public String getColor(){
            return color;
        }
	
	// Set new width 
	public void setWidth(double newWidth){
		width = newWidth;
	}
	
	// Set new height
	public void setHeight(double newHeight){
		height = newHeight;
	}
        
        //Set new color
        public void setColor(String c){
            color = c;
        }
	
	// Find area of the rectangle 
	public double findArea(){
		return (height  * width);
	}
	 //Add everything to a String for output
        public String toString(){
            String output = "Rectangl "+ getWidth()+" by "+getHeight();
            output += " color "+ getColor()+ " area is = "+ findArea();
            return output;
        }
}