/*Joey Wilson
 * 4/6/2017
 * Adds three shapes of various colors that fill 80% of the screen
 * circle is centered 
 */
package shapes;

import javax.swing.*;
import java.awt.*;

public class Shapes extends JFrame  {
	public Shapes() {
		getContentPane().setLayout(new GridLayout(1,3));
		
		getContentPane().add(ovalPanel);
		getContentPane().add(rectanglePanel);
		getContentPane().add(circlePanel);
	}
	
	OvalPanel ovalPanel = new OvalPanel();
	RectanglePanel rectanglePanel = new RectanglePanel();
	CirclePanel circlePanel = new CirclePanel();
	
	public static void main(String[] args) {
		JFrame frame = new Shapes();
		
		frame.setTitle("Shapes Joey Wilson");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 300);
		frame.setVisible(true);
	}
}

class RectanglePanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		g.drawRect(getWidth()/10, getHeight()/10, 4*getWidth()/5, 4*getHeight()/5);
	}
	
}

class OvalPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.green);
		g.fillOval(getWidth()/10, getHeight()/10, 4*getWidth()/5, 4*getHeight()/5);
	}
}

class CirclePanel extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		
		if (getHeight()<getWidth())
			g.fillOval(getWidth()/2-4*getHeight()/10,getHeight()/10, 4*getHeight()/5, 4*getHeight()/5);
		else
			g.fillOval(getWidth()/10,getHeight()/2-4*getWidth()/10, 4*getWidth()/5, 4*getWidth()/5);
			
	}
}