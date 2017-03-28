// Box.java box class with accessor methods

package testbox;

public class Box extends Rectangle {
    private double length;
    
    // Default constructor 
    public Box(){
        length = 1.0;
    }
    
    // Four argument constructor: length, width, height and color
    public Box(double h,double w,String c,double lth){
        super(w, h, c);
        length = lth;
    }
    
    //Set length
    public void setLength(double newLength){
        length = newLength;
    }
    
    //Return length
    public double getLength(double getLength){
        return length;
    }
    
    //Find the area
    public double findArea( ){
        double area;
        area = (2*(getWidth()*getHeight()+length*getHeight()+length*getWidth()));
        return (area);
    }
    
    //Add everything to a String for output
    public String toString(){
        String output = "Box "+length+" by "+ getWidth()+" by "+getHeight();
        output += " color "+ getColor()+ " area is = "+ findArea();
        return output;
    }
}