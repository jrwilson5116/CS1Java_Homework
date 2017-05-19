/**Joey Wilson
 * 4/11/2017
 * SalesCommission.java Lab12A
 * Allows user to calculate commissions from the sales amount or vice versa
 */


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class SalesCommission extends JFrame implements ActionListener {
    //
    private JTextField jtfOne = new JTextField(15);
    private JTextField jtfTwo = new JTextField(15);
    
    //Default constructor
    public SalesCommission(){
        //Panel for the top of the window
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2,1));
        p1.add(new JLabel("Sales Amount"));
        p1.add(jtfOne);
        p1.add(new JLabel("Commissions"));
        p1.add(jtfTwo);
        p1.setBorder(new TitledBorder("Sales Amount and Commissions"));
        getContentPane().add(p1, BorderLayout.CENTER);
        p1.setVisible(true);
        
        //Panel for the bottom of the window
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4,2));
        p2.setBorder(new TitledBorder("Comission Rates"));
        p2.add(new JLabel("Sales Amount"));
        p2.add(new JLabel("Commission Rate"));
        p2.add(new JLabel("$1 to $5,000"));
        p2.add(new JLabel("8 Percent"));
        p2.add(new JLabel("$ 5,001 to $10,000"));
        p2.add(new JLabel("10 Percent"));
        p2.add(new JLabel("Above $10,000"));
        p2.add(new JLabel("12 Percent"));
        getContentPane().add(p2, BorderLayout.SOUTH);
        p2.setVisible(true);
         
        //Register listener
        jtfOne.addActionListener(this);
        jtfTwo.addActionListener(this);
        
    }
    
    public static void main(String[] args) {
        // Set up frame
        JFrame frame = new SalesCommission();
        frame.pack();
		frame.setTitle("Sales Commisson Joey Wilson");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
	
	//Take input from either textbox and apply the formula
   @Override
    public void actionPerformed(ActionEvent e) {
        double sal, com;
        if (e.getSource()==jtfOne){
            sal = Double.parseDouble(jtfOne.getText().trim());
            if (sal <= 5000){
                com = (sal * .08);
            }else if (sal <= 10000){
                com = 400 + (sal - 5000) * .10;
            }else {
                com = 900 + (sal - 10000) * .12;
            }
            jtfTwo.setText(new Double(com).toString());
        }
        if (e.getSource() == jtfTwo){
            com = Double.parseDouble(jtfTwo.getText().trim());
            if(com <= 400){
                sal = com/(0.8);
            }else if(com <= 900){
                sal = 5000 + (com - 400)/.10;
            }else{
                sal = 10000 + (com - 900)/.12;
            }
            jtfOne.setText(new Double(sal).toString());   
        }
    }
}
