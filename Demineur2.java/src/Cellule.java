
public class Cellule {
	
		//////////////////////////////////////////////////////////////
		//////////////////////////  ATTRIBUTS  ///////////////////////
		/////////////////////////////////////////////////////////////

		/**
		 * Bool�en sp�cifiant la visibilit� d'une cellule.  
		 */
		private boolean visible;	
		
		/**
		 * Bool�en sp�cifiant si une mine est pr�sente ou non sur une cellule.
		 */
		private boolean presenceMine;
		
		/**
		 * Valeur indiquant le nombre de mines se trouvant aux alentours d'une cellule
		 * (si celle-ci ne contenait d�ja pas une mine)
		 */
		public int nbMinesVoisines;
			
		
		//////////////////////////////////////////////////////////////
		///////////////////////  CONSTRUCTEURS  /////////////////////
		/////////////////////////////////////////////////////////////
		
		/**
		 * Constructeur d'une Cellule par d�faut.
		 * Par defaut, une cellule est cach�.
		 * Le nombre de mines aux alentours reste � 0 tant que l'on ne clique pas sur la cellule.
		 */
		public Cellule()
		{
			this.visible = false;
			this.nbMinesVoisines = 0;
			this.presenceMine = false;
		}
		
		/**
		 * Constructeur d'une Cellule ayant trois param�tres.
		 * @param d - Visibilit� de la cellule ( true ou false)
		 * @param nb - Nombre de mines aux alentours de la cellule
		 * @param p - Bool�e sp�cifiant si la cellule contient une mine
		 */
		public Cellule(boolean d, int nb, boolean p)
		{
			this.visible = d;
			this.nbMinesVoisines = nb;
			this.presenceMine = p;
		}
		
		//////////////////////////////////////////////////////////////
		//////////////////////////  METHODES  ////////////////////////
		/////////////////////////////////////////////////////////////

		/**
		 * M�thode sp�cifiant qu'une cellule est visible
		 */
		public void visible()
		{
			this.visible = true;
		}

		/**
		 * M�thode sp�cifiant qu'une cellule est cach�
		 */
		public void cacher()
		{
			this.visible = false;
		}

		/**
		* M�thode sp�cifiant qu'une mine est pr�sente "sous" une cellule
		*/
		public void ouiMine()
		{
			this.presenceMine = true;
		}
			
		/**
		* M�thode sp�cifiant qu'aucune mine n'est pr�sente "sous" une cellule
		*/
		public void nonMine()
		{
			this.presenceMine = false;
		}

		/**
		* On retourne une chaine de caract�re repr�sentant notre objet, ici nos cellules
		* Si la cellule est visible, nous l'afficherons par le signe "+", sinon, c'est que la cellule est cach� (repr�sent� par "-") 
		* Nous representerons le fait qu'ne cellule contienne une mine par le symbole "�"
		* @return result - Cha�ne de caract�re repr�sentant une mine 
		*/
		public String toString()
		{
			String result = "";
				
			if (this.visible)
			{	
				if (this.presenceMine)
				{	
					result = result + ("+" + this.nbMinesVoisines + "�");
				}	
				else
				{	
					result = result + ("+" + this.nbMinesVoisines + " ");
				}
			}	
			else
			{	
				if (this.presenceMine)
				{	
					result = result + ("-" + this.nbMinesVoisines + "�");
				}	
				else
				{	
					result = result + ("-" + this.nbMinesVoisines + " ");
				}
			}	
			
			return result;
		}	
		
		//////////////////////////////////////////////////////////////
		/////////////////////////  ACCESSEURS  //////////////////////
		/////////////////////////////////////////////////////////////
		
		/**
		 * Accesseur renvoyant un bool�en. Si renvoie "True", alors la cellule est visible, sinon
		 * celle-ci est "cach�".
		 * @return visible - boolean
		 */
		public boolean getVisibilite()
		{
			return this.visible;
		}
		
		/**
		 * Accesseur renvoyant un bool�en. Si renvoie "True", alors la cellule contient une mine,
		 * sinon celle-ci n'en contient pas.
		 * @return presenceMine - boolean
		 */
		public boolean getPresenceMine()
		{
			return this.presenceMine;
		}
		
		/**
		 * Accesseur renvoyant un entien.
		 * @return nbMinesVoisines - entier repr�sentant le nombres de mines voisines.
		 */
		public int getNbMinesVoisines()
		{
			return this.nbMinesVoisines;
		}
		

		//////////////////////////////////////////////////////////////
		//////////////////////////  SETTEURS  ////////////////////////
		/////////////////////////////////////////////////////////////
		
		/**
		 * Mutateur permettant de modifier l'attribut visible
		 * @param visible bool�en indiquant la visibilit� d'une cellule
		 */
		public void setVisibilite(boolean visible)
		{
			this.visible = visible;
		}
		
		/**
		 * Mutateur permettant de modifier l'attribut presenceMine
		 * @param presenceMine bool�en sp�cifiant si une mine est pr�sente
		 */
		public void setPresenceMine(boolean presenceMine)
		{
			this.presenceMine = presenceMine;
		}
		
		/**
		 * Mutateur permettant de modifier l'attribut NbMinesVoisines
		 * @param nbMinesVoisines nombres de mines se trouvant autour de la cellule
		 */
		public void setNbMinesVoisines(int nbMinesVoisines)
		{
			this.nbMinesVoisines = nbMinesVoisines;
		}
	}

