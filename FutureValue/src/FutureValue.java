/**Joey Wilson
 * 
 * 
 * 
 */


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class FutureValue extends JFrame implements ActionListener {
    //
    JPanel p1 = new JPanel();
    JLabel jlblOne = new JLabel("Investment Amount");
    JLabel jlblTwo = new JLabel("Years");
    JLabel jlblThree = new JLabel("Annual Interest Rate");
    JLabel jlblFour = new JLabel("Future Value");
    JTextField jtxtOne = new JTextField(15);
    JTextField jtxtTwo = new JTextField(15);
    JTextField jtxtThree = new JTextField(15);
    JTextField jtxtFour = new JTextField(15);
    JButton calc = new JButton("Calulate");
    
     
    public FutureValue(){
        
        jtxtFour.setEditable(false);
        p1.setLayout(new GridLayout(4,4));
        p1.add(jlblOne);
        p1.add(jtxtOne);
        p1.add(jlblTwo);
        p1.add(jtxtTwo);
        p1.add(jlblThree);
        p1.add(jtxtThree);
        p1.add(jlblFour);
        p1.add(jtxtFour);
        
        getContentPane().add(p1,BorderLayout.CENTER);

        JPanel p2 = new JPanel();
       
        p2.add(calc);
        
        getContentPane().add(p2,BorderLayout.SOUTH);
        
        //Register Listeners
        calc.addActionListener(this);
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new FutureValue();
        frame.pack();
        JMenuBar mb = new JMenuBar();
        frame.setJMenuBar(mb);
        JMenu op = new JMenu("Operation",false);
        JMenu help = new JMenu("Help",false);
        mb.add(op);
        op.add(new JMenuItem("Calculate"));
        op.add(new JMenuItem("Exit"));
        mb.add(help);
        help.add(new JMenuItem("About"));
        //add menu listener
        op.addMenuListener(new MenuListener(){

			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Selected");
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        frame.setTitle("FutureValue.java Joey Wilson");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==calc){
            getCalc();
        }
       /* if (e.getSource() instanceof JMenuItem){
            if ("Calculate".equals(e.getSource())) {
                getCalc();
            }
        }*/
    }
    
    public void getCalc(){
        double inv,yrs,annrt,fut;
        inv = Double.parseDouble(jtxtOne.getText().toString());
        yrs = Double.parseDouble(jtxtOne.getText().toString());
        annrt = Double.parseDouble(jtxtThree.getText().toString());
        
        fut=inv*(1+(annrt/1200))*12;
        jtxtFour.setText(new Double(fut).toString());
    }
    
}
