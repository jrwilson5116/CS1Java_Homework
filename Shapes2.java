/*Joey Wilson
 * 4/6/2017
 * Displays window with option buttons to display multiple shapes
 * 
 */
package shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Shapes extends JFrame implements ActionListener {
	public Shapes() {
		getContentPane().add(shapePanel, BorderLayout.CENTER);
                JPanel p = new JPanel();
                p.setLayout(new GridLayout(1,3));
                p.add(jbtRect);
                p.add(jbtOval);
                p.add(jbtCircle);
                getContentPane().add(p,BorderLayout.SOUTH);
                jbtRect.addActionListener(this);
                jbtOval.addActionListener(this);
                jbtCircle.addActionListener(this);
	}
        
        public void actionPerformed(ActionEvent e){
            getContentPane().remove(shapePanel);
            if(e.getSource()==jbtRect)
                shapePanel =rectanglePanel;
            else if(e.getSource()== jbtOval)
                shapePanel = ovalPanel;
            else if(e.getSource()==jbtCircle)
                shapePanel = circlePanel;
                
            getContentPane().add(shapePanel);
            getContentPane().repaint();
            getContentPane().validate();
        }
	
	OvalPanel ovalPanel = new OvalPanel();
	RectanglePanel rectanglePanel = new RectanglePanel();
	CirclePanel circlePanel = new CirclePanel();
        JPanel shapePanel = new RectanglePanel();
        JButton jbtRect = new JButton("Show Rectangle");
        JButton jbtOval = new JButton("Show Oval");
        JButton jbtCircle = new JButton("Show Circle");
	
	public static void main(String[] args) {
		JFrame frame = new Shapes();
		
		frame.setTitle("Shapes Lab11B Joey Wilson");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
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