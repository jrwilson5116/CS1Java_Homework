/**Joey Wilson
 * 3/10/2017
 * TestRectangle.java
 * Displays the length width and area of two rectangles and then multiplies them by three
 */

public class TestRectangle {
	// Main method
	public static void main(String[] args) {
		
		double h = 4.0,w = 2.0; // Arbitrary values
		
		// Create rectangle with default values for hight and width 
		Rectangle r1 = new Rectangle();
		
		// Create rectangle with hight 4.0 and width 2.0
		Rectangle r2 = new Rectangle(w,h);
		
		System.out.println("Rectangle one: width = " + r1.getWidth() + " height = " + r1.getHeight() + " area = " + r1.findArea());
		System.out.println("Rectangle two: width = " + r2.getWidth() + " height = " + r2.getHeight() + " area = " + r2.findArea());
		
		// Increase width and height 3x
		r1.setHeight(r1.getHeight() * 3);
		r2.setWidth(r2.getHeight() * 3);
		
		System.out.println("Multiplied by three: ");
		System.out.println("Rectangle one: width = " + r1.getWidth() + " height = " + r1.getHeight() + " area = " + r1.findArea());
		System.out.println("Rectangle two: width = " + r2.getWidth() + " height = " + r2.getHeight() + " area = " + r2.findArea());

	}

}

/**Sample Output
 *  Rectangle one: width = 1.0 height = 1.0 area = 1.0
	Rectangle two: width = 2.0 height = 4.0 area = 8.0
	Multiplied by three: 
	Rectangle one: width = 1.0 height = 3.0 area = 3.0
	Rectangle two: width = 12.0 height = 4.0 area = 48.0
	*/

