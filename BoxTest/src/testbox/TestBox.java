
package testbox;

/**Joey Wilson
 * 3/23/2017
 * TestBox.java
 * Displays length, width and height and color of two boxes  
 */
public class TestBox {
    //Main method
    public static void main(String[] args) {
        // Create box with default constructor
        Box box1 = new Box();
        
        //Use set methods to change box1
        box1.setLength(2);
        box1.setWidth(4);
        box1.setHeight(7);
        box1.setColor("red");
        
        //Create a second box with arguments
        Box box2 = new Box(3,5,"yellow",7);
        
        //Output
        System.out.println(box1);
        System.out.println(box2);
    }
}

/**Sample output
 * Box 2.0 by 4.0 by 7.0 color red area is = 100.0
 * Box 7.0 by 5.0 by 3.0 color yellow area is = 142.0
 */