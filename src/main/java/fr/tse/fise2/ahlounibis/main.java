package fr.tse.fise2.ahlounibis;




import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import fr.tse.fise2.ahlouni.marvelapi.Comic;
import fr.tse.fise2.ahlouni.marvelapi.Result;
import fr.tse.fise2.ahlouni.marvelapi.parameter.ComicParametersBuilder;


public class main extends JComponent {
	 
    private static final String WIKIPEDIA_BASE_URL = "https://en.wikipedia.org/wiki/";

    public static String createWikiURLString (String search){
        return WIKIPEDIA_BASE_URL + search;
}

    public static URL createWikiURL (String search) throws MalformedURLException {
        return new URL (createWikiURLString (search));
    }
    /**
     * @param url
     * @throws IOException
     */

 
	/**
	 * @param args
	 * @throws IOException
	 *
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 
	
		   main m=new main();
		//String k=m.createWikiURLString("spider man");
		URL url=m.createWikiURL("azdazda");
		System.out.println(url);

	}

}
