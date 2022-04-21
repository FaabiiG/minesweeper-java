package pkg;

import javax.swing.JOptionPane;

public class Minesweeper {
	

    public void start(Minesweeper minesweeper) {
//        Input = new input(minesweeper);
//        Input.main(Input);
    	 minesweeper.gameInit();
    }
    
    public void gameInit() {
        int toughness = 1;
        int size = 8;
        Object[] options = {"Facile", "Moyen", "Difficile"};
        int nbOfMines = 0;
        toughness = JOptionPane.showOptionDialog(null,
                "Choisir la difficulté?", "Démineur",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if(toughness == -1)
            System.exit(0);
        
        switch(toughness) {
	        case 0:
	        	size = 9;
	        	nbOfMines = 10;
	        	break;
	        case 1: 
	        	size = 16;
	        	nbOfMines = 40;
	        	break;
	        case 2:
	        	size = 30;
	        	nbOfMines = 99;
	        	break;
        }
        newGame = new game(size, toughness, nbOfMines);
        newGame.main(newGame, size);
//        System.out.println(size);
        

    }
    
    public static void main(String[] args) {
        minesweeper = new Minesweeper();
        minesweeper.start(minesweeper);
    }
    
    private static Minesweeper minesweeper;
    private static game newGame;
    private static input Input;
	public void proceed() {
		// TODO Auto-generated method stub
		
	}
}

