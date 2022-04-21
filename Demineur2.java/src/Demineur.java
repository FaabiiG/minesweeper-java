import java.util.Random;
import java.util.Scanner;
public class Demineur {
	
	/**
	 * D�finition d'une grille ayant pour nom g
	 */
	private Grille g;
	
	
	
	/**
	 * Constructeur par d�faut d'une partie de d�mineur
	 * Un d�mineur est une nouvelle grille de jeu de 10x10 et en
	 * mettant 10 mines al�atoirement dans la grille
	 */
	public Demineur()
	{
		this.g = new Grille();
		//--------------------------------------
		//--- G�neration al�atoire des mines ---
		//--------------------------------------
		
		Random mineAleatoire = new Random();
		int mineGenerer = 0;
		
		while (mineGenerer < this.g.getNbMines() + 1)
		{
		
			Cellule c = this.g.getCellule(mineAleatoire.nextInt(this.g.getLargeur()), mineAleatoire.nextInt(this.g.getHauteur()));
			if(!c.getPresenceMine())
			{
				c.setPresenceMine(true);
				mineGenerer++;
			}
		}
		//-----------------------------------------
		//--- Algorithme de recherche des mines ---
		//-----------------------------------------
		for (int i = 0; i < this.g.getLargeur(); i++)
		{	
			for (int j = 0; j < this.g.getHauteur(); j++)
			{
				int nbMines = 0;
				if (j-1 >= 0)
				{
					if (this.g.getCellule(i, j-1).getPresenceMine()) 
						nbMines++;
				}
				if (i-1 >=0)
				{
					if (this.g.getCellule(i-1, j).getPresenceMine()) 
						nbMines++;
				}
				if (j+1 < 10)
				{
					if (this.g.getCellule(i, j+1).getPresenceMine()) 
						nbMines++;
				}
				if (i+1 < 10)
				{
					if (this.g.getCellule(i+1, j).getPresenceMine()) 
						nbMines++;
				}
				if ((i-1 >= 0)&&(j-1 >= 0))
				{
					if (this.g.getCellule(i-1, j-1).getPresenceMine()) 
						nbMines++;
				}
				if ((i+1 < 10)&&(j+1 < 10))
				{
					if (this.g.getCellule(i+1, j+1).getPresenceMine()) 
						nbMines++;
				}
				if ((i+1 < 10)&&(j-1 >=0))
				{
					if (this.g.getCellule(i+1, j-1).getPresenceMine()) 
						nbMines++;
				}
				if ((i-1 >=0)&&(j+1 < 10))
				{
					if (this.g.getCellule(i-1, j+1).getPresenceMine()) 
						nbMines++;
				}
				this.g.getCellule(i, j).setNbMinesVoisines(nbMines);
			}
		}
	}	
	

	/**
	 * Constructeur personnalis� d'une partie d�mineur.
	 * Le constructeur cr�er une nouvelle grille de largeur x et de hauteur
	 * y. Puis le constructeur rempli la grille de nombresMines mines de mani�re al�atoire
	 * de mines dans la grille x par y
	 * @param x largeur de la grille
	 * @param y hauteur de la grille
	 * @param nombresMines nombres de mines dans la grille de jeu
	 */
	public Demineur(int x, int y, int nombresMines)
	{
		this.g = new Grille(x,y,nombresMines);


		//--------------------------------------
		//--- G�neration al�atoire des mines ---
		//--------------------------------------
		
		Random mineAleatoire = new Random();
		int mineGenerer = 0;
		
		while (mineGenerer < this.g.getNbMines())
		{
			Cellule c = this.g.getCellule(mineAleatoire.nextInt(this.g.getLargeur()), mineAleatoire.nextInt(this.g.getHauteur())); 
			if(!c.getPresenceMine())
			{
			c.setPresenceMine(true);
			mineGenerer++;
			}
		}
		//-----------------------------------------
		//--- Algorithme de recherche des mines ---
		//-----------------------------------------
		for (int i = 0; i < this.g.getLargeur(); i++)
		{	
			for (int j = 0; j < this.g.getHauteur(); j++)
			{
				int nbMines = 0;
				if (j-1 >= 0)
				{
					if (this.g.getCellule(i, j-1).getPresenceMine()) 
						nbMines++;
				}
				if (i-1 >=0)
				{
					if (this.g.getCellule(i-1, j).getPresenceMine()) 
						nbMines++;
				}
				if (j+1 < this.g.getHauteur())
				{
					if (this.g.getCellule(i, j+1).getPresenceMine()) 
						nbMines++;
				}
				if (i+1 < this.g.getLargeur())
				{
					if (this.g.getCellule(i+1, j).getPresenceMine()) 
						nbMines++;
				}
				if ((i-1 >= 0)&&(j-1 >= 0))
				{
					if (this.g.getCellule(i-1, j-1).getPresenceMine()) 
						nbMines++;
				}
				if ((i+1 < this.g.getLargeur())&&(j+1 < this.g.getHauteur()))
				{
					if (this.g.getCellule(i+1, j+1).getPresenceMine()) 
						nbMines++;
				}
				if ((i+1 < this.g.getLargeur())&&(j-1 >=0))
				{
					if (this.g.getCellule(i+1, j-1).getPresenceMine()) 
						nbMines++;
				}
				if ((i-1 >=0)&&(j+1 < this.g.getHauteur()))
				{
					if (this.g.getCellule(i-1, j+1).getPresenceMine()) 
						nbMines++;
				}
				this.g.getCellule(i, j).setNbMinesVoisines(nbMines);
			}
		}
	}
	
	//////////////////////////////////////////////////////////////
	//////////////////////////  METHODES  ////////////////////////
	/////////////////////////////////////////////////////////////
	
	/**
	 * M�thode permettant � l'ordinateur de jouer une partie de d�mineur tous seul
	 * L'ordinateur peut gagner ou perdre
	 */
	public void jouer()
	{
		/////-----------------------------------/////
		/////--------- Variable locale ---------/////
		/////-----------------------------------/////
		int jouer = 1;
		int compteur = ((this.g.getHauteur()*this.g.getLargeur())-this.g.getNbMines());

		/////-----------------------------------/////
		/////------------ Programme ------------/////
		/////-----------------------------------/////
		System.out.println(this.g.toString());
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			// ici on peut ignorer l exception
		}		
		
		// Tantque jouer est diff�rent de 0, on continue � jouer
		while (jouer != 0)
		{
			Random mineAleatoire = new Random();
			int x = mineAleatoire.nextInt(this.g.getLargeur());
			int y = mineAleatoire.nextInt(this.g.getHauteur());
			
			Cellule c = this.g.getCellule(x,y);
			System.out.println("Cellule choisie : [" + (x+1) + "," + (y+1) + "]");
			
			// On test si la cellule n'a pas encore �t� decouverte
			// Si elle ne l'a pas �t�, on d�cr�mente le compteur
			// et on change sa visibilit�
			if (!c.getVisibilite())
			{
				c.setVisibilite(true);
				--compteur;
			}
			
			// On test si on est sur une mine
			if (c.getPresenceMine())
			{
				jouer = 0;
				System.out.println("GAME OVER");
				System.out.println("Dommage,il vous restait " + (compteur + 1) + " case(s) � d�couvrir");
				System.out.println("---------------------------------------------");
			}
			else
			{
				System.out.println("ATTENTION ! Il y a " + this.g.getCellule(x, y).nbMinesVoisines + " mine(s) autour de la cellule [" + (x+1) + "," + (y+1) + "]");
				System.out.println("/** Nombre de case(s) restante(s) � d�vouvrir : " + compteur + " **/" );
				System.out.println("----------------------------------------------------");
							
				// On test si on a gagn� ou pas
				if (compteur == 0)
					{
					jouer = 0;
					System.out.println("Bravo, vous avez gagn� la partie");
				}
			}
			System.out.println(this.g.toString());
			try
			{
				Thread.sleep(3000);
			}
			catch (InterruptedException e)
			{
				// ici on peut ignorer l exception
			}		
		}
		// Fin du d�mineur
		System.out.println("FIN DE LA PARTIE");
	}
	
	/** M�thode permettant � l'utilisateur de jouer une partie de d�mineur
	 * en ASCII art en choisissant les cellules qu'il veut d�couvrir
	 */
	public void utilisateurJoue()
	{
		/////-----------------------------------/////
		/////--------- Variable locale ---------/////
		/////-----------------------------------/////
		int jouer = 1;
		int compteur = ((this.g.getHauteur()*this.g.getLargeur())-this.g.getNbMines());
		
		/////-----------------------------------/////
		/////------------ Programme ------------/////
		/////-----------------------------------/////
		System.out.println(this.g.toString());
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			// ici on peut ignorer l exception
		}	
		
		while (jouer != 0)
		{
			// On cr�er un nouveau scanner permettant de r�cup�rer ce que tape l'utilisateur
			Scanner sc = new Scanner(System.in);
			
			// Saisie de l'abcisse par l'utilisateur
			System.out.println("veuillez choisir la coordonn�e x de la cellule a decouvrir");
			int choixX = sc.nextInt();
			while ((choixX > this.g.getLargeur()) || (choixX < 1))
			{
				System.out.println("La coordonn�e sp�cifi� est introuvable");
				choixX = sc.nextInt();
			}
			
			// Saisie de l'ordonn�e par l'utilisateur
			System.out.println("veuillez choisir la coordonn�e y de la cellule a decouvrir");
			int choixY = sc.nextInt();
			while ((choixY > this.g.getHauteur()) || (choixY < 1))    
			{
				System.out.println("La coordonn�e sp�cifi� est introuvable");
				choixY = sc.nextInt();
			}
			
			Cellule c = this.g.getCellule(choixX-1, choixY-1);
			System.out.println("Cellule choisie : [" + choixX + "," + choixY + "]");
			
			
			// On test si la cellule n'a pas encore �t� decouverte
			// Si elle ne l'a pas �t�, on d�cr�mente le compteur
			// et on change sa visibilit�
			if (!c.getVisibilite()) 
			{
				c.setVisibilite(true);
				--compteur;
			}
			
			// On test si on est sur une mine
			if (c.getPresenceMine())
			{
				jouer = 0;
				System.out.println("Dommage vous avez perdu alors qu'il vous restait " + compteur + " cellules � d�couvrir");
			}
			else
			{
				System.out.println("ATTENTION ! Il y a " + this.g.getCellule(choixX, choixY).nbMinesVoisines + " mine(s) autour de la cellule [" + choixX + "," + choixX + "]");
				System.out.println("/** Nombre de case(s) restante(s) � d�vouvrir : " + compteur + " **/" );
				System.out.println("----------------------------------------------------");
				
				// On test si on a gagn� ou pas
				if (compteur == 0)
				{
					jouer = 0;
					System.out.println("Bravo, vous avez gagn� la partie");
				}
			}
			System.out.println(this.g.toString());
			try
			{
				Thread.sleep(3000);
			}
			catch (InterruptedException e)
			{
				// ici on peut ignorer l exception
			}	
		}
		
		// Fin du d�mineur
		System.out.println("FIN DE LA PARTIE");
	}
}


