// package src;

//IMPORTED CLASSES
//Graphical Classes
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JLabel;
// import javax.swing.BorderFactory;

//JAVAFX PACKAGES
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//Editing & Simple Packages & Classes
// import java.awt.Color;
// import java.awt.Rectangle;
// import java.awt.Dimension;
// import java.awt.BorderLayout;
// import java.awt.event.*;
// import java.awt.FlowLayout;
// import java.awt.GridLayout;

//Language Classes
// import java.lang.Math;

//I/O Classes
// import java.io.File;
// import java.io.IOException;
// import java.io.FileWriter;

public class App extends Application{
    // CLASS CONSTANTS
	// static final int cellSize = 20; // Width & Height
	// static final int cellDim = 50; // Dimensions of Cell Array
	// static final Rectangle fieldDim = new Rectangle(150, 75, 1050, 600); // field dimensions
	// static final int liveCells = 50; // Number of live cells initialized
	// static final String dataPath = new String("C:\\Users\\David A\\Documents\\David\\Other\\Programming\\Program Data\\GoL");

	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome to the Game of Life!");
        Button btn = new Button();

        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
    		@Override
        	public void handle(ActionEvent event) {
            	System.out.println("Hello World!");
        	}
    	});
        
    	StackPane root = new StackPane();
    	root.getChildren().add(btn);
    	primaryStage.setScene(new Scene(root, 600, 424));
		primaryStage.getScene().getStylesheets().add(App.class.getResource("welcome.css").toExternalForm());
    	primaryStage.show();
    }
}	// 	// OBJECT VARIABLES
	// 	JFrame GameForm = new JFrame("Game"); // The Windows Form containing everything
	// 	JFrame WelcomeForm = new JFrame("Welcome");
	// 	JPanel container = new JPanel(new FlowLayout());
	// 	JPanel field = new JPanel(new GridLayout(cellDim, cellDim));
	// 	JPanel labels = new JPanel(new GridLayout(3, 0));
	// 	JPanel commands = new JPanel(new GridLayout(4, 0));
	// 	JButton fieldButtons[] = new JButton[5];
	// 	JButton cmdToGame = new JButton();
	// 	JLabel fieldLabels[] = new JLabel[3];
	// 	Cell[][] organisms = new Cell[cellDim][cellDim];
	// 	int generation = 0;

    //     // Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
 
	// 	setWelcomeForm(WelcomeForm, cmdToGame);
	// 	cmdToGame.addActionListener(new ActionListener() {
	// 		public void actionPerformed(ActionEvent e) {
	// 			WelcomeForm.setVisible(false);
	// 			SetField(field);
	// 			SetForm(GameForm, container);
	// 		}
	// 	});

	// 	// Setting up the field on the form
	// 	AddOrganisms(field, organisms);

	// 	// Setting up text & command controls on form
	// 	SetLabelInfo(fieldLabels, labels); // LABELS
	// 	SetButtonInfo(fieldButtons, commands); // BUTTONS
	// 	// Adding panels of all objects to form
	// 	container.setBackground(Color.GRAY);
	// 	container.add(field);
	// 	container.add(labels);
	// 	container.add(commands);

	// 	fieldButtons[0].addActionListener(new ActionListener() {
	// 		public void actionPerformed(ActionEvent e) {
	// 			AddLiveOrganisms(organisms);
	// 			fieldLabels[0].setText(Integer.toString(CountAliveCells(organisms)));
	// 			fieldLabels[1].setText("STARTED");
	// 			ChangeGeneration(fieldLabels[2], generation);
	// 			fieldButtons[0].setEnabled(false);
	// 		}
	// 	});

	// 	fieldButtons[1].addActionListener(new ActionListener() {
	// 		public void actionPerformed(ActionEvent e) {
	// 			// DetermineEvolutionLoop(organisms);
	// 			DetermineEvolutionRecursive(organisms, 0, 0);
	// 			ChangeGeneration(fieldLabels[2], generation);
	// 			fieldLabels[0].setText(Integer.toString(CountAliveCells(organisms)));
	// 		}
	// 	});

	// 	fieldButtons[2].addActionListener(new ActionListener() {
	// 		public void actionPerformed(ActionEvent e) {
	// 			fieldLabels[1].setText("STOPPED");
	// 			fieldButtons[1].setEnabled(false);
	// 		}
	// 	});

	// 	fieldButtons[3].addActionListener(new ActionListener() {
	// 		public void actionPerformed(ActionEvent e) {
	// 			WriteStateToFile(organisms);
	// 		}
	// 	});

	// }

	// private static void setWelcomeForm(JFrame W, JButton G) {
	// 	W.setLayout(new BorderLayout());
	// 	W.setBounds(150, 70, 300, 300);
	// 	W.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// 	G.setLayout(new BorderLayout());
	// 	G.setSize(50, 50);
	// 	G.setText("PROCEED TO GAME");
	// 	W.getContentPane().add(G, BorderLayout.SOUTH);
	// 	W.setVisible(true);
	// }

	// public static void WriteStateToFile(Cell[][] O) {
	// 	File fieldFile = new File(dataPath + "field1.txt");
	// 	try {
	// 		if (fieldFile.createNewFile()) {
	// 			System.out.println("FILE CREATED");
	// 		}
	// 	} catch (IOException e) {
	// 		System.out.println("ERROR");
	// 	}
	// 	try {
	// 		FileWriter fieldWriter = new FileWriter(fieldFile);
	// 		int i = 0;
	// 		int j = 0;
	// 		for (i = 0; i < cellDim; i++) {
	// 			for (j = 0; j < cellDim; j++) {
	// 				if (O[i][j].getAlive()) {
	// 					fieldWriter.write("1");
	// 				} else {
	// 					fieldWriter.write("0");
	// 				}
	// 			}
	// 		}
	// 		fieldWriter.close();
	// 		System.out.println("FILE WRITE SUCCESS");
	// 	} catch (IOException e) {
	// 		System.out.println("ERROR");
	// 	}
	// }

	// public static void ChangeGeneration(JLabel lbl, int G) {
	// 	G += 1;
	// 	lbl.setText("Generation: " + Integer.toString(G));
	// }

	// public static void SetForm(JFrame F, JPanel C) {
	// 	/**
	// 	** Formats window for game
	// 	** @param F - JFrame window containing form for game
	// 	** @param C - Container panel which is parent to all pannels representing cells
	// 	*/
	// 	F.setBounds(fieldDim);
	// 	F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// 	F.getContentPane().add(C);
	// 	F.pack();
	// 	F.setVisible(true);
	// }

	// public static void SetField(JPanel F) {
	// 	F.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	// 	F.setMaximumSize(new Dimension(500, 500));
	// 	F.setLocation(0, 0);
	// 	F.setVisible(true);
	// }

	// /*
	// * Sets up info for labels on panel, to then be added to field
	// */
	// public static void SetLabelInfo(JLabel lbls[], JPanel L) {

	// 	// Initialize each label
	// 	int i = 0;
	// 	for (i = 0; i < 3; i++) {
	// 		lbls[i] = new JLabel("Label number: " + Integer.toString(i + 1));
	// 	}

	// 	// Set up graphics of panel containing labels
	// 	L.setBackground(Color.WHITE);

	// 	// LABEL 1 - NUMBER OF ALIVE CELLS
	// 	lbls[0].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	// 	L.add(lbls[0]);

	// 	// LABEL 2 = GAME STATUS
	// 	lbls[1].setText("NOT STARTED");
	// 	lbls[1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	// 	L.add(lbls[1]);

	// 	// LABEL 3 - GENERATION NUMBER
	// 	lbls[2].setText("GENERATION: " + Integer.toString(0));
	// 	lbls[2].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	// 	L.add(lbls[2]);

	// }

	// public static void SetButtonInfo(JButton cmds[], JPanel B) {

	// 	int i = 0;
	// 	for (i = 0; i < 5; i++) {
	// 		cmds[i] = new JButton("Button Number: " + Integer.toString(i + 1));// INITIALISE EACH BUTTON
	// 		cmds[i].setBackground(Color.WHITE);
	// 	}

	// 	B.setBackground(Color.WHITE);

	// 	// BUTTON 1 - START
	// 	cmds[0].setText("INITIALIZE");
	// 	B.add(cmds[0]);

	// 	// BUTTON 2 - NEXT GENERATION
	// 	cmds[1].setText("NEXT GENERATION");
	// 	B.add(cmds[1]);

	// 	// BUTTON 3 - STOP GAME
	// 	cmds[2].setText("STOP");
	// 	B.add(cmds[2]);

	// 	// BUTTON 4 - SAVE CURRENT STATE
	// 	cmds[3].setText("SAVE");
	// 	B.add(cmds[3]);

	// 	// BUTTON 5 - LOAS A GAME
	// 	cmds[4].setText("LOAD");
	// 	B.add(cmds[4]);
	// }

	// // Decides fate of a particular cell
	// public static void CellEvolution(Cell C, int x, int y, int A) {
	// 	if (A < 2 || A > 3) {
	// 		C.setAlive(false);
	// 	} else {
	// 		C.setAlive(true);
	// 	}
	// }

	// // Adds all the cells onto field (after initializing each one)
	// public static void AddOrganisms(JPanel f, Cell[][] O) {
	// 	int i, j;
	// 	i = j = 0;
	// 	for (i = 0; i < cellDim; i++) {
	// 		for (j = 0; j < cellDim; j++) {
	// 			O[i][j] = new Cell();
	// 			O[i][j].getVisual().setBorder(BorderFactory.createLineBorder(Color.BLACK));
	// 			f.add(O[i][j].getVisual(), BorderLayout.WEST);
	// 		}
	// 	}
	// }

	// public static int CheckAliveCells(int x, int y, Cell[][] O) {
	// 	int cellCount = 0;
	// 	int i, j;
	// 	i = j = 0;
	// 	for (i = x - 1; i < x + 2; i++) {
	// 		for (j = y - 1; j < y + 2; j++) {
	// 			if (i == x && j == y) {
	// 			} else if (i < 0 || j < 0 || i > cellDim - 1 || j > cellDim - 1) {
	// 			} else {
	// 				if (O[i][j].getAlive()) {
	// 					cellCount += 1;
	// 				}
	// 			}
	// 		}
	// 	}
	// 	return cellCount;
	// }

	// public static int CountAliveCells(Cell[][] O) {
	// 	int i, j, count;
	// 	i = j = count = 0;
	// 	for (i = 0; i < cellDim; i++) {
	// 		for (j = 0; j < cellDim; j++) {
	// 			if (O[i][j].getAlive()) {
	// 				count += 1;
	// 			}
	// 		}
	// 	}
	// 	return count;
	// }

	// public static void AddLiveOrganisms(Cell[][] O) {
	// 	int n = 0;
	// 	for (n = 0; n < liveCells; n++) {
	// 		int i = (int) (Math.random() * cellDim);
	// 		int j = (int) (Math.random() * cellDim);
	// 		if (O[i][j].getAlive()) {
	// 			n -= 1;
	// 		} else {
	// 			O[i][j].setAlive(true);
	// 		}
	// 	}
	// }

	// public static void DetermineEvolutionLoop(Cell[][] O) {

	// 	int i = 0;
	// 	int j = 0;
	// 	boolean[][] nextStage = new boolean[cellDim][cellDim];

	// 	for (i = 0; i < cellDim; i++) {
	// 		for (j = 0; j < cellDim; j++) {
	// 			if (CheckAliveCells(i, j, O) < 2 || CheckAliveCells(i, j, O) > 3) {
	// 				nextStage[i][j] = false;
	// 			} else {
	// 				nextStage[i][j] = true;
	// 			}
	// 		}
	// 	}

	// 	for (i = 0; i < cellDim; i++) {
	// 		for (j = 0; j < cellDim; j++) {
	// 			O[i][j].setAlive(nextStage[i][j]);
	// 		}
	// 	}
	// }

	// public static void DetermineEvolutionRecursive(Cell[][] O, int i, int j) {
	// 	boolean future = false;
	// 	if (CheckAliveCells(i, j, O) < 2 || CheckAliveCells(i, j, O) > 3) {
	// 	} else {
	// 		future = true;
	// 	}

	// 	if (i == cellDim - 1 && j == cellDim - 1) {
	// 	} else if (j == cellDim - 1) {
	// 		DetermineEvolutionRecursive(O, i + 1, 0);
	// 	} else {
	// 		DetermineEvolutionRecursive(O, i, j + 1);
	// 	}
	// 	O[i][j].setAlive(future);
	// }

// }
/*
 * WHAT HAVE WE LEARNT - void function means a function that doesn't return
 * anything (or returns a void), i.e., a subroutine! - to initialize a variable:
 * [type] object_pointer/s = ("new" [type]) / value/s - static variables belong
 * to the class as a whole, not each instance of the class - multi-D arrays are
 * just arrays within arrays - import javax.swing.*; - IMPORTS ALL CLASSES under
 * package - if I wanna resize myself, I have to create a layout.
 */