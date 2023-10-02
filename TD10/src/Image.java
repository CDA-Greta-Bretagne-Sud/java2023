import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Image {

	
	Pixel tab[][];
	int largeur;
	int hauteur;
	//constructeur
	public Image(Pixel[][] tab, int largeur, int hauteur) {
		super();
		this.tab = tab;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	//méthode retournant un tableau d'int
	public int[][][] Image(Pixel[][] tab) {
		return this.export(tab);
	}
	// setter et getter
	public Pixel[][] getTab() {
		return tab;
	}
	public void setTab(Pixel[][] tab) {
		this.tab = tab;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	@Override
	public String toString() {
		return "Image [tab=" + Arrays.toString(tab) + ", largeur=" + largeur + ", hauteur=" + hauteur + "]";
	}
	/**
	 * methode qui convertit une image en tableau d'entier à 3 dimensions
	 * @param tab
	 * @return
	 */
	private int[][][] export(Pixel[][] tab){
	int res[][][] = new int[tab[0].length][tab.length][3];
	for (int col = 0; col<tab.length; col++){
		for (int lig=0; lig<tab[0].length; lig++){
			res[col][lig][0]=tab[col][lig].rouge;
			res[col][lig][1]=tab[col][lig].bleu;
			res[col][lig][2]=tab[col][lig].vert;
		}
		}
	return res;
	}
	/**
	 * méthode qui sauvegarde le tableau d'entiers en 3 dimensions dans un fichier au format png
	 * @param tab
	 * @param nomFichier
	 */
	public void sauv(int[][][] tab,String nomFichier) {
		
		String path="images"+File.separator+nomFichier;
		
		try {
			BufferedImage bufi = new BufferedImage(tab.length,tab[0].length, BufferedImage.TYPE_INT_ARGB);
			int[] tabbis = packedFromNatural(tab);
			bufi.setRGB(0,0,tab.length,tab[0].length,tabbis,0,tab.length);
			ImageIO.write(bufi, "png", new File(path));
		}catch(IOException ioe) {
			throw new IllegalArgumentException(ioe.getMessage());
		}
		
	}
	/**
	 * méthode permettant de retourner un tableau d'entier
	 * @param tab
	 * @return
	 */
	private  int[] packedFromNatural(int [][][] tab){
		int[] res = new int[tab.length*tab[0].length];
		for (int col = 0; col<tab.length; col++){
			for (int lig=0; lig<tab[0].length; lig++){
				res[lig*tab.length+col] = packedFromArray(tab[col][lig]);
			}
		}
		return res;
	}
/**
 * méthode permettant de décaler de 8 bits vers la gaucheles valeurs des pixels
 * @param pix
 * @return
 */
	private  int packedFromArray(int[] pix){
		int res = pix[2];
		res = (((res<<8) + pix[2]<< 8) + pix[1]);
		return (res<<8) + pix[0];
	}
	/**
	 * affichage de l'image contant uniquemlent les 2 couleurs
	 * @param tab
	 */
	public void afficheImage(int[][][] tab){
		new Afficheur(tab,"monImage");
	}
	/**
	 * Affichage de l'image avac la composante alpha
	 * @param tab
	 */
	public void afficheImageAlpha(int[][][] tab){
		new Afficheur(tab);
	}
	/**
	 * Retourne un objet d'entiers à partir d'une image présente dans un fichier
	 * @param nomFichier
	 * @return
	 */
	public int[][][] afficherImageFichier(String nomFichier) {
		String path="images"+File.separator+nomFichier;
		int[][][] tabImage = ImageUtil.readImage(path);
		return tabImage;
	}
	
}
