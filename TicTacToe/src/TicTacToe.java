/**Joey Wilson
 * 4/20/2017
 * TicTacToe.java Lab13B
 * GUI Tic Tac Toe game with new game feature
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TicTacToe extends JFrame {
  // Indicate which player has a turn, initially it is the X player
  private char whoseTurn = 'X';

  // Create and initialize cells
  private Cell[][] cells =  new Cell[3][3];

  // Create and initialize a status label
  private JLabel jlblStatus = new JLabel("X's turn to play");
  
  //Create menu
  JMenuBar mb = new JMenuBar();
  JMenu file = new JMenu("File");
  JMenuItem newGame = new JMenuItem("New");
  
  boolean gameOver = false;
  
  // Initialize UI
  public TicTacToe() {
    // Panel p to hold cells
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(3, 3, 0, 0));
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        p.add(cells[i][j] = new Cell());
    
   setJMenuBar(mb);
   mb.add(file);
   file.add(newGame);
   
    // Set line borders on the cells panel and the status label
    p.setBorder(new LineBorder(Color.red, 1));
    jlblStatus.setBorder(new LineBorder(Color.yellow, 1));

    // Place the panel and the label to the applet
    //add(menuPanel,BorderLayout.NORTH);
    add(p, BorderLayout.CENTER);
    add(jlblStatus, BorderLayout.SOUTH);
   
    //Register listener for menu
    
    newGame.addActionListener(new ActionListener(){
       
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	if (e.getSource() instanceof JMenuItem) {
        		gameOver=false;
        		whoseTurn = 'X';
        		jlblStatus.setText("X's turn");
        		for (int reset = 0; reset < 3; reset++) {
        			cells[reset][0].setToken(' ');
        			cells[reset][1].setToken(' ');
        			cells[reset][2].setToken(' ');
        		}
        	}
        } 
    });
  }

  // This main method does the standard 5 things
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new TicTacToe();
    frame.setTitle("TicTacToe");
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  // Determine if the cells are all occupied 
  public boolean isFull() {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (cells[i][j].getToken() == ' ')
          return false;

    return true;
  }

  // Determine if the player with the specified token wins
  public boolean isWon(char token) {
    for (int i = 0; i < 3; i++)
      if ((cells[i][0].getToken() == token)
          && (cells[i][1].getToken() == token)
          && (cells[i][2].getToken() == token)) {
        return true;
      }

    for (int j = 0; j < 3; j++)
      if ((cells[0][j].getToken() ==  token)
          && (cells[1][j].getToken() == token)
          && (cells[2][j].getToken() == token)) {
        return true;
      }

    if ((cells[0][0].getToken() == token)
        && (cells[1][1].getToken() == token)
        && (cells[2][2].getToken() == token)) {
      return true;
    }

    if ((cells[0][2].getToken() == token)
        && (cells[1][1].getToken() == token)
        && (cells[2][0].getToken() == token)) {
      return true;
    }

    return false;
  }

  // An inner class for a cell
  public class Cell extends JPanel implements MouseListener {
    // Token used for this cell
    private char token = ' ';

    public Cell() {
      setBorder(new LineBorder(Color.black, 1)); // Set cell's border
      
      //Register listener
      addMouseListener(new MouseAdapter() {
    	  @Override
    	  public void mouseClicked(MouseEvent e) {
    	      
    	      if (token == ' '&&gameOver==false) { // If cell is not occupied
    	        if (whoseTurn == 'X') { // If it is the X player's turn
    	          setToken('X');  // Set token in the cell
    	          whoseTurn = 'O';  // Change the turn
    	          jlblStatus.setText("O's turn");  // Display status
    	          if (isWon('X')){
    	            jlblStatus.setText("X won! The game is over");
    	            gameOver = true;
    	          }else if (isFull()){
    	            jlblStatus.setText("Draw! The game is over");
    	            gameOver=true;
    	          }
    	        }
    	        else if (whoseTurn == 'O') { // If it is the O player's turn
    	          setToken('O'); // Set token in the cell
    	          whoseTurn = 'X';  // Change the turn
    	          jlblStatus.setText("X's turn"); // Display status
    	          if (isWon('O')){
    	            jlblStatus.setText("O won! The game is over");
    	            gameOver=true;
    	          }else if (isFull()){
    	            jlblStatus.setText("Draw! The game is over");
    	            gameOver=true;
    	          }
    	        }
    	      }
    	    }
    	    public void mousePressed(MouseEvent e) {
    	    }
    	    public void mouseReleased(MouseEvent e) {
    	    }
    	    public void mouseEntered(MouseEvent e) {
    	    }
    	    public void mouseExited(MouseEvent e) {
    	    }
      });  
    }

    // Return token
    public char getToken() {
      return token;
    }

    // Set a new token 
    public void setToken(char c) {
      token = c;
      repaint();
    }

    // Paint the cell
    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (token == 'X') {
        g.drawLine(10, 10, getSize().width-10, getSize().height-10);
        g.drawLine(getSize().width-10, 10, 10, getSize().height-10);
      }
      else if (token == 'O') {
        g.drawOval(10, 10, getSize().width-20, getSize().height-20);
      }
    }

    //Wouldn't work without this
	@Override
	public void mouseClicked(MouseEvent e) {	
	}
	@Override
	public void mousePressed(MouseEvent e) {	
	}
	@Override
	public void mouseReleased(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {	
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
  }
}