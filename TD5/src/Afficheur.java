
import javax.swing.*;

import java.awt.Dimension;
import java.awt.image.*;
import java.awt.*;


/**
 * 
 * Classe dont les instances sont des fenêtres affichées à l'écran
 * contenant une image.
 *
 */
public class Afficheur extends JFrame{

	private static final long serialVersionUID = 1L;
	private int[] tab;
	private JPanel jp;

	/**
	 * @param pixels l'image à afficher
	 */
	public Afficheur(int[][][] pixels){
		int width, height;
		width = pixels.length;
		height = pixels[0].length;
		BufferedImage bim = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		int[] pixtab = arrayFromPix(pixels);
		tab = ( (DataBufferInt) bim.getRaster()
				.getDataBuffer() ).getData();
		System.arraycopy(pixtab, 0, tab, 0, pixtab.length);
		jp = new ImagePanel(bim);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.setPreferredSize(new Dimension(bim.getWidth(),bim.getHeight()));
		this.add(jp);
		this.pack();
		this.setVisible(true);
	}
	/**
	 * @param int l'image à afficher
	 */
	public Afficheur(int[][][] pixels,String name){
		int width, height;
		width = pixels.length;
		height = pixels[0].length;
		BufferedImage bim = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		int[] pixtab = arrayFromTab(pixels);
		tab = ( (DataBufferInt) bim.getRaster()
				.getDataBuffer() ).getData();
		System.arraycopy(pixtab, 0, tab, 0, pixtab.length);
		jp = new ImagePanel(bim);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.setPreferredSize(new Dimension(bim.getWidth(),bim.getHeight()));
		this.add(jp);
		this.pack();
		this.setVisible(true);
	}
	
	
	/**
	 * Méthode servant à afficher une nouvelle image dans la feneêtre.
	 * 
	 * Cette image doit avoir les mêmes dimensions que celle donnée en 
	 * paramètre au constructeur lors de la création de l'objet sur lequel
	 * la méthode est appelée.
	 * @param pixels l'image à afficher
	 * @throws IndexOutOfBoundsException parfois levée si pixels n'a pas
	 * la même dimension que l'image précédemment affichée par l'objet.
	 */
	public void update(int[][][] pixels){
		int[] pixtab = arrayFromPix(pixels);
		System.arraycopy(pixtab, 0, tab, 0, pixtab.length);
		jp.revalidate();
		jp.repaint();
	}
	private int[] arrayFromPix(int[][][] pixels){
		int[] res = new int[pixels.length*pixels[0].length];
		for (int col = 0; col< pixels.length; col++){
			for (int lig=0; lig<pixels[0].length; lig++){
				res[pixels.length*lig+col] = intFromPixel(pixels[col][lig]);
			}
		}
		return res;
	}
	private int intFromPixel(int[] pix){
		int res = pix[3];
		res = (((res<<8) + pix[0]<< 8) + pix[1]);
		return (res<<8) + pix[2];
	}
	
	//
	private int[] arrayFromTab(int[][][] pixels){
		int[] res = new int[pixels.length*pixels[0].length];
		for (int col = 0; col< pixels.length; col++){
			for (int lig=0; lig<pixels[0].length; lig++){
				res[pixels.length*lig+col] = intFromTab(pixels[col][lig]);
			}
		}
		return res;
	}
	private int intFromTab(int[] pix){
		int res = pix[2];
		res = (((res<<8) + pix[0]<< 8) + pix[1]);
		return (res<<8) + pix[2];
	}
	
	

	/** Méthode qui ferme la fenêtre.
	 * 
	 */
	public void fermer(){
		this.dispose();
	}
	class ImagePanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private BufferedImage image;
		public ImagePanel(BufferedImage i) {
			image=i;
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, null); 
		}

	}

}
