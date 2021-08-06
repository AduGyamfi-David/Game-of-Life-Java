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
		// AddABorder();
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
		if (A && this.alive){
			this.visual.setBackground(Color.BLACK);
		}
		else if (A && !this.alive){
			this.visual.setBackground(Color.GREEN);
		}
		else if (!A && this.alive){
			this.visual.setBackground(Color.RED);
		}
		else{
			this.visual.setBackground(Color.WHITE);
		}
		this.alive = A;
	}
	public JPanel getVisual(){
		return this.visual;
	}
	public void setVisual(JPanel V){
		this.visual = V;
	}

	//CLASS METHODS
	public void AddABorder(){
		this.visual.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	}
}

/* 
todo - Option to load a saved game
todo - fix option to save a game
todo - redesign UI on FIGMA and then convert into this project
todo - Option to load random cells or start from starting point
todo - option to choose dimensions of "field" 
todo - option to go to next generation automatically after selected (and variable time)
*/