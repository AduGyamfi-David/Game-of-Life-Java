//IMPORTED CLASSES
//Graphic Objects
import javax.swing.JButton; import javax.swing.JFrame;
import javax.swing.JPanel; import javax.swing.JLabel;
import javax.swing.BorderFactory;

//Editing & Simple Objects
import java.awt.event; import java.awt.Color;
import java.awt.Rectangle; import java.awt.Dimension;
import java.awt.BorderLayout; import java.awt.LayoutManager;
import java.awt.FlowLayout; import java.awt.GridLayout;

//Language Classes
import java.lang.Math;

//Class for the actual main program
public class Game{

  //CLASS CONSTANTS
  static final int cellSize = 20; //Width & Height 
  static final int cellDim = 4; //Dimensions of Cell Array
  static final Rectangle fieldDim = new Rectangle(150, 75, 1050, 600); //field dimensions
  //MAIN SUB
  public static void main(String[] args){

    //OBJECT VARIABLES
    JFrame form = new JFrame("Game"); //The Windows Form containing everything
    JPanel field = new JPanel(new FlowLayout()); 
    JPanel labels = new JPanel(new GridLayout());
    Cell[][] organisms = new Cell[cellDim][cellDim];
    // JButton cmdStart, cmdNextGeneration;
    JLabel fieldLabels[] = new JLabel[3];

    SetForm(form); 

    //Setting up the field on the form
    SetField(field);
    AddOrganisms(field, organisms);
    // form.getContentPane().add(field);

    //Setting up text controls on form
    SetLabelInfo(fieldLabels, labels);
    form.getContentPane().add(labels);


    // cmdStart = new JButton("START GAME");
    // // cmdStart.addActionListener(new ActionListener());
    // cmdStart.setBounds(700, 200, 60, 30);

    // // field.add(cmdStart);
    form.setBackground(Color.black);
    form.setVisible(true);
  }

  // public void actionPerformed(ActionEvent e, JLabel lblCC, Cell[][] O){
  //   lblCC.setText(Integer.toString(CountAliveCells(O)));
  // }
  
  //Creates window for game
  public static void SetForm(JFrame F){
    F.setBounds(fieldDim);
    F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void SetField(JPanel F){
    F.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    F.setPreferredSize(new Dimension(500, 500));
    F.setVisible(true);
  }

  /*Sets up info for labels on panel, 
  to then be added to field*/
  public static void SetLabelInfo(JLabel lbls[], JPanel L){

    //Initialize each label
    int i = 0;
    for (i = 0; i < 3; i ++){
      lbls[i] = new JLabel("Label number: " + Integer.toString(i));
    }
    
    //Set up graphics of panel containing labels
    L.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    L.setBackground(Color.CYAN);

    // lbls[0].setText(Integer.toString(CountAliveCells(0)));
    lbls[0].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    // lbls[0].setBounds(700, 50, 100, 50);
    L.add(lbls[0]);

    lbls[1].setText("NOT STARTED");
    lbls[1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    // lbls[1].setBounds(700, 150, 100, 50);
    L.add(lbls[1]);

    lbls[2].setText("GENERATION: \n 0");
    lbls[2].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    // lbls[2].setBounds(700, 250, 100, 50);
    L.add(lbls[2]);


  }

  //Decides fate of a particular cell
  public static void CellEvolution(Cell C, int x, int y, int A){
    if (A < 2 || A > 3){
      C.setAlive(false);
    }
    else{
      C.setAlive(true);
    }
  }

  //Adds all the cells onto field (after initializing each one)
  public static void AddOrganisms(JPanel f, Cell[][] O){
    int i, j;
    i = j = 0;
    for (i = 0; i < cellDim; i ++){
      for (j = 0; j < cellDim; j ++){
        O[i][j] = new Cell(((cellSize * i)), ((cellSize * j)));
        f.add(O[i][j].getVisual(), BorderLayout.WEST);
      }
    }
  }

  public static int CheckAliveCells(int x, int y, Cells O){
    int cellCount = 0;
    for (j = y - 1; j < y + 2; j++){
      for (i = x - 1; i < x + 2; i ++){
        if (i == x && j == y){
        }
        else{
          if (O.getCell(x,y).getAlive){
            cellCount += 1;
          }
        }
      }
    }
    return cellCount;
  }

  public static int CountAliveCells(Cell[][] O){
    int i, j, count;
    i = j = count = 0;
    for (i = 0; i < cellDim; i ++){
      for (j = 0; j < cellDim; j ++){
        if (O[i][j].getAlive()){
          count += 1;
        }
      }
    }
    return count;
  }

}

public class Cells{

}

/*WHAT HAVE WE LEARNT
- void function means a function that doesn't return anything
(or returns a void), i.e., a subroutine!
- to initialize a variable: [type] object_pointer/s = ("new" [type]) / value/s
- static variables belong to the class as a whole, not each instance of the class
- multi-D arrays are just arrays within arrays
- import javax.swing.*; - IMPORTS ALL CLASSES under package
*/