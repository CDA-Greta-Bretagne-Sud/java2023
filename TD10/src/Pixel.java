
public class Pixel {
	int rouge;
	int bleu;
	int vert;
	int alpha;
//constructeur
	public Pixel(int rouge, int bleu, int vert, int alpha) {
		super();
		this.rouge = rouge;
		this.bleu = bleu;
		this.vert = vert;
		this.alpha = alpha;
	}
//getter et setter
	public int getRouge() {
		return rouge;
	}

	public void setRouge(int rouge) {
		this.rouge = rouge;
	}

	public int getBleu() {
		return bleu;
	}

	public void setBleu(int bleu) {
		this.bleu = bleu;
	}

	public int getVert() {
		return vert;
	}

	public void setVert(int vert) {
		this.vert = vert;
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	@Override
	public String toString() {
		return "Pixel [rouge=" + rouge + ", bleu=" + bleu + ", vert=" + vert + ", alpha=" + alpha + "]";
	}

	public static void main(String[] args) {
		// question 2
		Pixel p1 = new Pixel(12, 45, 255, 10);
		Pixel p2 = new Pixel(255, 0, 255, 20);

		System.out.println(p1.toString());
		System.out.println(p2.toString());
		p1.setBleu(50);
		p1.setRouge(51);
		p1.setVert(0);
		p1.setAlpha(40);
		System.out.println(p1.toString());
		p2.setBleu(155);
		p2.setRouge(155);
		p2.setVert(0);
		p2.setAlpha(50);
		System.out.println(p2.toString());
		// question3
		Pixel tab[][] = { { new Pixel(12, 45, 255, 10), new Pixel(255, 0, 255, 20) },
				{ new Pixel(255, 0, 255, 20), new Pixel(255, 0, 255, 20) } };
		Image i = new Image(tab, 300, 200);
		int tab2[][][] = i.Image(tab);
		// affichage des valeurs de l'image
		for (int col = 0; col < tab2.length; col++) {
			for (int lig = 0; lig < tab2[0].length; lig++) {
				System.out.print(tab2[col][lig][0] + "-");
				System.out.print(tab2[col][lig][1] + "-");
				System.out.print(tab2[col][lig][2]);
				System.out.println();
			}
			// sauvegarde de l'image dans un fichier
			i.sauv(tab2, "test.png");
			// affichage image
			i.afficheImage(tab2);
			// question 4
			int tab3[][][] = i.afficherImageFichier("prairie.png");
			i.afficheImageAlpha(tab3);
		}
	}
}
