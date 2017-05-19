/**Joey Wilson
 * 4/14/2017
 * Quiz game with checkboxes radio buttons a combobox and a finish button 
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

public class CryptidGame extends JFrame implements ItemListener{
	
	//Declarations
	private double sasquach =0, chupacabra =0,lochNess =0, mothman=0,totalPts=0;
	
	private JCheckBox jchkOne = new JCheckBox("Taking a walk in the woods");
	private JCheckBox jchkTwo = new JCheckBox("Tasting succulent goat blood");
	private JCheckBox jchkThree = new JCheckBox("Going for a swim");
	private JCheckBox jchkFour = new JCheckBox("Forboding disaterous events");
	
	private JRadioButton jrdoOne = new JRadioButton("How unphotogenic I am...pictures of me are always blurry");
	private JRadioButton jrdoTwo = new JRadioButton("Running out of succulent goat blood");
	private JRadioButton jrdoThree = new JRadioButton("Underwater sonar imaging");
	private JRadioButton jrdoFour = new JRadioButton("When people dont heed my warnings of impending doom");
	
	private JButton jbtFinish = new JButton("Finish");
	
	public CryptidGame() {
		//Call methods to set up panels
		paneOneSetup();
		panelTwoSetup();
		panelThreeSetup();
	}

	public static void main(String[] args) {
		//Setting up frame
		JFrame frame = new CryptidGame();
		frame.setSize(600,600);
		frame.setTitle("Cryptid Quiz Joey Wilson");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void paneOneSetup() {
		JTextArea jtxtPlay = new JTextArea(3,50);
		String description = ("Have you ever wondered if you were related to Sasquach or "+
				"maybe a member of the Mothman family? Answer the following questions to find out!");
		jtxtPlay.setText(description);
		jtxtPlay.setLineWrap(true);
		jtxtPlay.setWrapStyleWord(true);
		jtxtPlay.setEditable(false);
		//Top panel
		JPanel p1 = new JPanel();
		p1.setBorder(new TitledBorder("Which Cryptid Are You???"));
		p1.add(jtxtPlay);
		getContentPane().add(p1,BorderLayout.NORTH);
		p1.setVisible(true);
	}
	
	public void panelTwoSetup() {
	
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(jrdoOne);
		bg1.add(jrdoTwo);
		bg1.add(jrdoThree);
		bg1.add(jrdoFour);
		
		JComboBox jcbo = new JComboBox();
		jcbo.addItem("Twigs and berries");
		jcbo.addItem("Succulent goat blood");
		jcbo.addItem("Hundreds of pounds of fish");
		jcbo.addItem("Humans");
		jcbo.setSelectedItem(null);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(12,0));
		p2.setBorder(new TitledBorder("Questions"));
		p2.add(new JLabel("First Question: Which passtimes do you enjoy?(check all that apply)"));
		p2.add(jchkOne);
		p2.add(jchkTwo);
		p2.add(jchkThree);
		p2.add(jchkFour);
		p2.add(new JLabel("Second Question: What do you hate the most?"));
		p2.add(jrdoOne);
		p2.add(jrdoTwo);
		p2.add(jrdoThree);
		p2.add(jrdoFour);
		p2.add(new JLabel("Final Question: What is your favorite food?"));
		p2.add(jcbo);
		
		getContentPane().add(p2,BorderLayout.CENTER);
		
		//Register listeners 
		jchkOne.addItemListener(this);
		jchkTwo.addItemListener(this);
		jchkThree.addItemListener(this);
		jchkFour.addItemListener(this);
		
		jrdoOne.addItemListener(this);
		jrdoTwo.addItemListener(this);
		jrdoThree.addItemListener(this);
		jrdoFour.addItemListener(this);
		
		jcbo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (jcbo.getSelectedIndex() == 0) {
					System.out.println("You chose: Twigs and berries");
					sasquach++;
					totalPts++;
				}else if (jcbo.getSelectedIndex()==1) {
					System.out.println("You chose: Succulent goat blood");
					chupacabra++;
					totalPts++;
				}else if (jcbo.getSelectedIndex()==2) {
					System.out.println("You chose: Hundreds of pounds of fish");
					lochNess++;
					totalPts++;
				}else if (jcbo.getSelectedIndex()==3) {
					System.out.println("You chose: Humans");
					mothman++;
					totalPts++;
				}
			}
		});
	}
	
	public void panelThreeSetup() {
		
		JPanel p3 = new JPanel();
		//JButton jbtFinish = new JButton("Finish");
		p3.add(jbtFinish);
		getContentPane().add(p3,BorderLayout.SOUTH);
		
		//
		jbtFinish.addActionListener(new FinishListener());
	}
	
	private  void findMatch(double s,double c,double m,double ln,double total) {
		if (s>c &&s>c&&s>m&&s>ln) {
			System.out.println("You are a Sasquach!");
			System.out.println("Match was "+((sasquach/totalPts)*100)+" percent");
		}else if (c>s&&c>m&&c>ln) {
			System.out.println("You are a Chupacabra!");
			System.out.println("Match was "+((chupacabra/totalPts)*100)+" percent");
		}else if (m>s&&m>c&&m>ln) {
			System.out.println("You are a Mothman!");
			System.out.println("Match was "+((mothman/totalPts)*100)+" percent");
		}else if (ln>s&&ln>c&&ln>m) {
			System.out.println("You are the Loch Ness Monster!");
			System.out.println("Match was "+((sasquach/totalPts)*100)+" percent");
		}else {
			System.out.println("You are an unknown hybrid species...");
		}
	}
	
	private class FinishListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==jbtFinish) {
				if (totalPts>=3) {
					System.out.println("You have made your selection final");
					findMatch(sasquach,chupacabra,mothman,lochNess,totalPts);
				}else {
					System.out.println("You have not selected enough ansewers to finish");
				}
			}
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (jchkOne.isSelected()) {
			System.out.println("You chose: Taking a walk in the woods");
			sasquach++;
			totalPts++;
		}
		if (jchkTwo.isSelected()) {
			System.out.println("You chose: Tasting succulent goat blood");
			chupacabra++;
			totalPts++;
		}
		if (jchkThree.isSelected()) {
			System.out.println("You chose: Going for a swim");
			lochNess++;
			totalPts++;
		}
		if (jchkFour.isSelected()) {
			System.out.println("You chose: Forboding disasterous events");
			mothman++;
			totalPts++;
		}
		if(e.getSource()==jrdoOne) {
			System.out.println("You chose: How unphotogenic I am...pictures of me are always blurry");
			sasquach++;
			totalPts++;
		}else if(e.getSource()==jrdoTwo) {
			System.out.println("You chose: Running out of succulent goat blood");
			chupacabra++;
			totalPts++;
		}else if(e.getSource()==jrdoThree) {
			System.out.println("You chose: Underwater sonar imaging");
			lochNess++;
			totalPts++;
		}else if (e.getSource()==jrdoFour) {
			System.out.println("You chose: When people don't heed my warnings of impending doom");
			mothman++;
			totalPts++;
		}
	
	}

}

/**Sample Output
 * You chose: Taking a walk in the woods
	You chose: How unphotogenic I am...pictures of me are always blurry
	You chose: Twigs and berries
	You have made your selection final
	You are a Sasquach!
	Match was 100.0 percent
	*/
