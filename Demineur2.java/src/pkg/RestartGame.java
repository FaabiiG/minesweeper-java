package pkg;

public class RestartGame {
	

	public RestartGame(int size, int toughness, int nb) {
		game newGame = new game(size, toughness, nb);
        newGame.main(newGame, size);
	}
	
	

}
