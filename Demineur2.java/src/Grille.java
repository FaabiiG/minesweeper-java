
public class Grille {
	/**
	 * Nombre de lignes par d�faut de la grille
	 */
	private final static int LARGEUR_DEFAUT = 10;
	
	/**
	 * Nombre de colonnes par d�faut de la grille
	 */
	private final static int HAUTEUR_DEFAUT = 10;
	
	/**
	 * Nombre de mines par d�faut dans la grille
	 */
	private final static int NB_MINES_DEFAUT = 10;
	
	//////////////////////////////////////////////////////////////
	//////////////////////////  ATTRIBUTS  ///////////////////////
	/////////////////////////////////////////////////////////////
	
	/**
	 * Largeur de la grille
	 */
	private final int largeur;
	
	/**
	 * Hauteur de la grille
	 */
	private final int hauteur;
	
	/**
	 * Nombre de mines pr�sentes dans la grille
	 */
	private final int nbMines;

	/**
	 * Grille de jeu repr�sent� par un tableau de Cellule � deux dimensions
	 * Le tableau est g�r�e par ses coordonn�es (largeur et hauteur)
	 */
	private Cellule[][] grille;
	
	//////////////////////////////////////////////////////////////
	///////////////////////  CONSTRUCTEURS  /////////////////////
	/////////////////////////////////////////////////////////////
	
	/**
	* Constructeur par d�faut d'une grille 
	* Une largeur de 10 cellules, une hauteur de 10 cellules et un nombres de mines �gal � 10.
	*/
	public Grille()
	{
		/* Initialisation des attributs */
		this.largeur = LARGEUR_DEFAUT;
		this.hauteur = HAUTEUR_DEFAUT;
		this.nbMines = NB_MINES_DEFAUT;
		/* Instanciation d'une objet cellule */
		this.grille = new Cellule[LARGEUR_DEFAUT][HAUTEUR_DEFAUT];
		
		int x = 0;
		while (x < this.largeur)
		{
			int y = 0;
			while (y < this.hauteur)
			{
				this.grille[x][y] = new Cellule();
				y++;
			}
			x++;
		}
	}
	
	/**
	 * Constructeur de la grille de jeu personnalis�e
	 * Le joueur choisi la largeur "l", la hauteur "h", et le nombre de mines de la grille "m"
	 * pour cr�er sa grille personnalis�
	 * @param l    largeur de la grille
	 * @param h    hauteur de la grille
	 * @param m    nombre de mines de la grille
	 */
	public Grille(int l, int h, int m)
	{
		this.largeur = l;
		this.hauteur = h;
		this.grille = new Cellule[l][h];
		this.nbMines = m;
		
		int x = 0;
		while (x < this.largeur)
		{
			int y = 0;
			while (y < this.hauteur)
			{
				this.grille[x][y] = new Cellule();
				y++;
			}
			x++;
		}	
	}

	//-----------------------------------------------------------------------
	// <---- M�thodes ---->
	//-----------------------------------------------------------------------
	
	/**
	* On retourne une chaine de caract�re repr�sentant notre objet, ici, une grille
	* @return result - Cha�ne de caract�re repr�sentant la grille en cha�ne ASCII 
	*/
	public String toString()
	{
		String result ="";
		
		int x =0;
		while (x < this.hauteur)
		{
			int y =0;
			while (y < this.largeur)
			{
				result = result + "|" + this.grille[y][x].toString() +"|";
				y++;
			}
			result = result + "\n";
			x++;
		}
		return result;
	}	

	//////////////////////////////////////////////////////////////
	/////////////////////////  ACCESSEURS  //////////////////////
	/////////////////////////////////////////////////////////////
	
	/**
	 * Accesseur renvoyant la largeur de la grille
	 * @return largeur 
	 */
	public int getLargeur()
	{
		return this.largeur;
	}
	
	/**
	 * Accesseur renvoyant la hauteur de la grille
	 * @return hauteur 
	 */
	public int getHauteur()
	{
		return this.hauteur;
	}
	
	/**
	 * Accesseur renvoyant le nombres de mines de la grille
	 * @return nbMines
	 */
	public int getNbMines()
	{
		return this.nbMines;
	}
	
	/**
	 * Accesseur renvoyant une cellule
	 * @param x abscisse de la cellule se situant dans la grille
	 * @param y ordonn�e de la cellule se situant dans la grille
	 * @return grille[x][y]
	 */
	public Cellule getCellule(int x,int y)
	{
		return this.grille[x][y];
	}
	
	//////////////////////////////////////////////////////////////
	//////////////////////////  SETTEURS  ////////////////////////
	/////////////////////////////////////////////////////////////
	
	/**
	 * Setteur permetant de changer la visibilit� d'une cellule se trouvant 
	 * � la position x et y de la grille � true
	 * @param x abscisse de la cellule se situant dans la grille
	 * @param y ordonn�e de la cellule se situant dans la grille 
	 */
	public void setCelluleVisible(int x,int y)
	{	
		this.grille[x][y].setVisibilite(true);
	}
	
	/**
	 * Setteur permetant de changer la visibilit� d'une cellule se trouvant 
	 * � la position x et y de la grille � false
	 * @param x abscisse de la cellule se situant dans la grille
	 * @param y ordonn�e de la cellule se situant dans la grille 
	 */
	public void setCelluleCacher(int x,int y)
	{	
		this.grille[x][y].setVisibilite(false);
	}
	
}

