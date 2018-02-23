package fr.tse.fise2.ahlouni.graphicinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Thumbnail extends JPanel {
    private  BufferedImage img;
    private  URL url;
    
    /**
     * Constructeur de la classe Thumbnail 
     */
    public Thumbnail () {
    	this.img=null;
    	this.url=null;
    }
    

    public Thumbnail( URL url) throws IOException {
        img = ImageIO.read(url);
        
        //setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));

    }
    
    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override protected void paintComponent(Graphics g) {
    	 super.paintComponent(g);
    	    g.drawImage(img, 0, 0, null);

    }
    public BufferedImage getImg() {
		return img;
	}

    /**
     * ImageIcon permet de retourner l'icone de l'étiquette du comic avec une size adapté au label où sera affiché l'icône.
     * @return
     *
     */
    public ImageIcon getImgIcn() {
    	     	
    	Image dimg =img.getScaledInstance(228, 314,Image.SCALE_SMOOTH);
    	ImageIcon imageIcon = new ImageIcon(dimg);

    	return imageIcon;
    			
    }
	/**
	 * @param img
	 *
	 */
	public void setImg(BufferedImage img) {
		this.img = img;
	}

	/**
	 * @return
	 *
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * @param url
	 *
	 */
	public void setUrl(URL url) {
		this.url = url;
		
	}

	
    
 	
  
   

}
