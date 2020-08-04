//IMPORTED CLASSES
//Graphic Objects
import javax.swing.JButton; import javax.swing.JFrame;
import javax.swing.JPanel; import javax.swing.JLabel;
import javax.swing.BorderFactory;

//Editing & Simple Objects
import java.awt.Color;
import java.awt.Rectangle; import java.awt.Dimension;
import java.awt.BorderLayout; import java.awt.event.*;
import java.awt.FlowLayout; import java.awt.GridLayout;

//Language Classes
import java.lang.Math;

//Class for the actual main program
public class Game{

  //CLASS CONSTANTS
  static final int cellSize = 20; //Width & Height 
  static final int cellDim = 20; //Dimensions of Cell Array
  static final Rectangle fieldDim = new Rectangle(150, 75, 1050, 600); //field dimensions
  static final int liveCells = 15; //Number of live cells initialized
  //MAIN SUB
  public static void main(String[] args){

    //OBJECT VARIABLES
    JFrame form = new JFrame("Game"); //The Windows Form containing everything
    JPanel container = new JPanel(new FlowLayout());
    JPanel field = new JPanel(new GridLayout(cellDim, cellDim)); 
    JPanel labels = new JPanel(new GridLayout(3, 0));
    JPanel commands = new JPanel(new GridLayout(4,0));
    Cell[][] organisms = new Cell[cellDim][cellDim];
    JButton fieldButtons[] = new JButton[5];
    JLabel fieldLabels[] = new JLabel[3];
    int generation = 0;

    SetForm(form); 

    //Setting up the field on the form
    SetField(field);
    AddOrganisms(field, organisms);
    //Setting up text & command controls on form
    SetLabelInfo(fieldLabels, labels); //LABELS
    SetButtonInfo(fieldButtons, commands); //BUTTONS
    //Adding panels of all objects to form
    container.setBackground(Color.GRAY);
    container.add(field); container.add(labels); container.add(commands);

    fieldButtons[0].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        // generation += 1;
        AddLiveOrganisms(organisms);
        fieldLabels[0].setText(Integer.toString(CountAliveCells(organisms)));
        // fieldLabels[2].setText(Integer.toString(generation));
        fieldButtons[0].setEnabled(false);
      }
    });

    fieldButtons[1].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        DetermineEvolutionLoop(organisms);
        fieldLabels[0].setText(Integer.toString(CountAliveCells(organisms)));
      }
    });

    // cmdStart = new JButton("START GAME");
    // // cmdStart.addActionListener(new ActionListener());
    // cmdStart.setBounds(700, 200, 60, 30);

    form.setBackground(Color.BLUE);
    form.getContentPane().add(container);
    form.pack();
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
    F.setMaximumSize(new Dimension(500, 500));
    F.setLocation(0, 0);
    F.setVisible(true);
  }

  /*Sets up info for labels on panel, 
  to then be added to field*/
  public static void SetLabelInfo(JLabel lbls[], JPanel L){

    //Initialize each label
    int i = 0;
    for (i = 0; i < 3; i ++){
      lbls[i] = new JLabel("Label number: " + Integer.toString(i + 1));
    }
    
    //Set up graphics of panel containing labels
    // L.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    L.setBackground(Color.WHITE);

    // lbls[0].setText(Integer.toString(CountAliveCells(0)));
    lbls[0].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    // lbls[0].setBounds(700, 50, 100, 50);
    L.add(lbls[0]);

    lbls[1].setText("NOT STARTED");
    lbls[1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    // lbls[1].setBounds(700, 150, 100, 50);
    L.add(lbls[1]);

    lbls[2].setText("GENERATION: " + Integer.toString(0));
    lbls[2].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    // lbls[2].setBounds(700, 250, 100, 50);
    L.add(lbls[2]);


  }

  public static void SetButtonInfo(JButton cmds[], JPanel B){

    int i = 0;
    for (i = 0; i < 5; i ++){
      cmds[i] = new JButton("Button Number: " + Integer.toString(i + 1));//INITIALISE EACH BUTTON
      cmds[i].setBackground(Color.WHITE);
    }

    B.setBackground(Color.WHITE);

    //BUTTON 1 - START
    cmds[0].setText("INITIALIZE");
    B.add(cmds[0]);

    //BUTTON 2 - NEXT GENERATION
    cmds[1].setText("NEXT GENERATION");
    B.add(cmds[1]);

    //BUTTON 3 - STOP GAME
    cmds[2].setText("STOP");
    B.add(cmds[2]);

    //BUTTON 4 - SAVE CURRENT STATE
    cmds[3].setText("SAVE");
    B.add(cmds[3]);

    //BUTTON 5 - LOAS A GAME
    cmds[4].setText("LOAD");
    B.add(cmds[4]);
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
        O[i][j] = new Cell();
        f.add(O[i][j].getVisual(), BorderLayout.WEST);
      }
    }
  }

  public static int CheckAliveCells(int x, int y, Cell[][] O){
    int cellCount = 0;
    int i, j;
    i = j = 0;
    for (i = x - 1; i < x + 2; i++){
      for (j = y - 1; j < y + 2; j ++){
        if (i == x && j == y){
        }
        else if (i < 0 || j < 0 || i > 19 || j > 19){
        }
        else{
          if (O[i][j].getAlive()){
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

  public static void AddLiveOrganisms(Cell[][] O){
    int n = 0;
    for (n = 0; n < liveCells; n ++){
      int i = (int)(Math.random() * cellDim);
      int j = (int)(Math.random() * cellDim);
      if (O[i][j].getAlive()){
        n -= 1;
      }
      else{
        O[i][j].setAlive(true);
      }
    }
  }

public static void DetermineEvolutionLoop(Cell[][] O){

  int i = 0; int j = 0;
  boolean[][] nextStage = new boolean[cellDim][cellDim];

  for (i = 0; i < cellDim ; i ++){
    for (j = 0; j < cellDim; j ++){
      if (CheckAliveCells(i, j, O) < 2 || CheckAliveCells(i, j, O) > 3){
        nextStage[i][j] = false;
      }
      else{
        nextStage[i][j] = true;
      }
    }
  }

  for (i = 0; i < cellDim ; i ++){
    for (j = 0; j < cellDim; j ++){
      O[i][j].setAlive(nextStage[i][j]);
    }
  }

}

public static void DetermineEvolutionRecursive(Cell[][] O){

}

}
/*WHAT HAVE WE LEARNT
- void function means a function that doesn't return anything
(or returns a void), i.e., a subroutine!
- to initialize a variable: [type] object_pointer/s = ("new" [type]) / value/s
- static variables belong to the class as a whole, not each instance of the class
- multi-D arrays are just arrays within arrays
- import javax.swing.*; - IMPORTS ALL CLASSES under package
- if I wanna resize myself, I have to create a layout.
*/