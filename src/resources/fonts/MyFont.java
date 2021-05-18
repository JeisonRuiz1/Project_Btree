package resources.fonts;

import java.awt.Font;
import java.io.InputStream;

public class MyFont {
	
	private Font font;
	
	public Font fuente(String fontName, int estyle, float size){
         try {
            //Se carga la fuente
            InputStream is =  getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);            
        }
         
        Font tfont = font.deriveFont(estyle, size);
        
        return tfont;
    }

}
