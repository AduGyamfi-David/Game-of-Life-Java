import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;

public class Cell{
    //INSTANCE VARIABLES/CONSTANTS
    static final int cellSize = 20; //Width & Height 
    private boolean alive = false;
    private JPanel visual;
  
    //CONSTRUCTORS
    public Cell(){
      this.alive = false;
      this.visual = new JPanel();
      this.visual.setBounds(0, 0, cellSize, cellSize);
      this.visual.setBackground(Color.WHITE);
      AddABorder();
      // this.visual.setBackground(new Color((int)((Math.random()*254) + 1), (int)((Math.random()*254) + 1), (int)((Math.random()*254) + 1)));
    }
  
    public Cell(int x, int y){
      this.alive = false;
      this.visual = new JPanel();
      this.visual.setBounds(x, y, cellSize, cellSize);
      this.visual.setBackground(Color.gray);
      AddABorder();
      // this.visual.setBackground(new Color((int)((Math.random()*254) + 1), (int)((Math.random()*254) + 1), (int)((Math.random()*254) + 1)));
    }
  
    /*MODIFIER METHODS
    ACCESSORS & MUTATORS*/
    public boolean getAlive(){
      return this.alive;
    }
    public void setAlive(boolean A){
      this.alive = A;
      if (A){
        this.visual.setBackground(Color.BLACK);
      }
      else{
        this.visual.setBackground(Color.WHITE);
      }
    }
    public JPanel getVisual(){
      return this.visual;
    }
    public void setVisual(JPanel V){
      this.visual = V;
    }
  
    //CLASS METHODS
    public void setLocation(int x, int y){
      visual.setBounds(x, y, 50, 50);
    }
    public void AddABorder(){
      this.visual.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
    }
  }