/**Joey Wilson
 * 5/5/2017
 * TODO list program with save and delete functions and mnemonic key combo accelerators
 */
package todolist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class ToDoList extends JFrame implements ActionListener{
    
    private final int SIZE = 16;
    private JCheckBox[] jcbItem = new JCheckBox[SIZE]; 
    private JTextField[] jtfItem = new JTextField[SIZE];
    private JButton jbtInsert, jbtDelete, jbtSave, jbtFetch;
    private JMenuItem jmiOpen, jmiSave, jmiSaveAs, jmiExit, jmiAbout;
    private Object[] objArray = new Object[SIZE];
    private String baseDir = "", listName;
    private File listFile;
    private JFileChooser jFileChooser = new JFileChooser();
     
    
    public ToDoList(){
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(SIZE,2));
        p1.add(new JLabel("Done"));
        p1.add(new JLabel(" "));
        for(int i=1; i< SIZE; i++){
            p1.add(jcbItem[i] = new JCheckBox());           
            p1.add(new JLabel(String.valueOf(i)));
        }
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(SIZE,1));
        for(int i=0;i<SIZE;i++){
            p2.add(jtfItem[i] = new JTextField(40));            
        }
            
        jtfItem[0].setText("Replace WIth a One Word List Title Here ..."
                + " and Add Your \"To Do\" Items Below ");
        
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1,16));
        p3.add(jbtInsert = new JButton("Insert"));
        p3.add(jbtDelete = new JButton("Delete"));
        p3.add(jbtSave = new JButton("Save"));
        p3.add(jbtFetch = new JButton("Fetch"));
        
        getContentPane().setLayout(new BorderLayout());
        add(p1, BorderLayout.WEST);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        
        for(int i=1; i<SIZE; i++)
            objArray[i] = new Integer(i);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu fileMenu = new JMenu("File");
        mb.add(fileMenu);
        
        JMenu helpMenu = new JMenu("Help");
        
        mb.add(helpMenu);
        
        fileMenu.add(jmiOpen = new JMenuItem("Open"));
        fileMenu.add(jmiSave = new JMenuItem("Save"));
        fileMenu.add(jmiSaveAs = new JMenuItem("SaveAs"));
        fileMenu.add(jmiExit = new JMenuItem("Exit"));
        helpMenu.add(jmiAbout = new JMenuItem("About"));
        
        jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        jmiAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
                
        jFileChooser.setCurrentDirectory(new File("."));
        
        //Register listeners
        jbtInsert.addActionListener(this);
        jbtDelete.addActionListener(this);
        jbtSave.addActionListener(this);
        jbtFetch.addActionListener(this);
        jmiOpen.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiSaveAs.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiAbout.addActionListener(this);
    }
    
    public static void main(String[] args) {
        JFrame frame = new ToDoList();
        frame.setTitle("TODO List Joey Wilson");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);       
    }
    
     public void actionPerformed(ActionEvent e) {       
        String actionC = e.getActionCommand();
        int line;
        
        if (e.getSource() instanceof JButton) {
            if("Insert".equals(actionC)){
                line = (Integer)JOptionPane.showInputDialog(null, 
                        "Pick a line number you want to insert",
                        "DialogWithCombo",JOptionPane.QUESTION_MESSAGE, 
                        null, objArray, null);
                insert(line);
            }
            else if("Delete".equals(actionC)){
                line = (Integer)JOptionPane.showInputDialog(null, 
                        "Pick a line number you want to delete",
                        "DialogWithCombo",JOptionPane.QUESTION_MESSAGE, 
                        null, objArray, null);
                delete(line);
            }
            else if("Save".equals(actionC)){
                listName = jtfItem[0].getText();
                listFile = new File(baseDir + listName);
                writeFile();
            }
            else if("Fetch".equals(actionC)){
                listName = jtfItem[0].getText();
                listFile = new File(baseDir + listName);
                readFile();
            }    
        }
        if (e.getSource() instanceof JMenuItem) {
            if("Open".equals(actionC)){
                if(jFileChooser.showOpenDialog(this)
                        == JFileChooser.APPROVE_OPTION ){                   
                    listFile = jFileChooser.getSelectedFile();
                    readFile();
                    jtfItem[0].setText(listFile.getName());
                }
                
            }
            if("Save".equals(actionC)){
                listName = jtfItem[0].getText();
                listFile = new File(baseDir + listName);
                writeFile();
                jtfItem[0].setText(listFile.getName());
            }
            if("SaveAs".equals(actionC)){
                if(jFileChooser.showSaveDialog(this)
                        == JFileChooser.APPROVE_OPTION ){                   
                    listFile = jFileChooser.getSelectedFile();
                    jtfItem[0].setText(listFile.getName());
                    writeFile();                 
                }
            }
            if("Exit".equals(actionC)){
                System.exit(0);
            }
            if("About".equals(actionC)){
                JOptionPane.showMessageDialog(null,
                "Joey Wilson\n5/5/2017\nToDoList.java" +
                "\n", "About",JOptionPane.PLAIN_MESSAGE); 
            }
        } 
     }
     
    public void insert(int line){
        for(int i= SIZE-1; i > line; i-- ){
            jtfItem[i].setText(jtfItem[i-1].getText());
            jcbItem[i].setSelected(jcbItem[i-1].isSelected());
        }
        jtfItem[line].setText(" ");
        jcbItem[line].setSelected(false);
    }
     
    public void delete(int line){   
        for(int i= line;i < SIZE-1; i++ ){
            jtfItem[i].setText(jtfItem[i+1].getText());
            jcbItem[i].setSelected(jcbItem[i+1].isSelected());
        }
        jtfItem[SIZE-1].setText(" ");
        jcbItem[SIZE-1].setSelected(false);
    }
    
    public void writeFile(){
        try{
            Formatter out = new Formatter(listFile);
            for(int i = 1; i < SIZE ; i++){
                String check = (jcbItem[i].isSelected())?"X":" ";
                out.format("%s%s\n", check, jtfItem[i].getText().trim());
            }
            out.close();    
        }
        catch(Exception e){
            jtfItem[0].setText("Error writing to file");
        }
    }
    
    public void readFile(){
        try{
            if (listFile.exists() == false)
            	jtfItem[0].setText("Requested list does not exist!");
            else{
                Scanner in = new Scanner(listFile);
                for(int i=1; i<SIZE; i++){
                    String instr = in.nextLine();
                    jcbItem[i].setSelected(instr.charAt(0) == 'X');
                    jtfItem[i].setText(instr.substring(1, instr.length()));
                }
            in.close();
            }
        }
        catch(Exception e){
            jtfItem[0].setText("Error writing to file");
        }
    }
}

