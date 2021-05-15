package resources;

import java.awt.Dimension;
import java.awt.Point;

public class Constants {
	
	//dimensiones para ventanas
	public static final Dimension SIZE_FRAME = new Dimension(800,500);
	public static final Dimension SIZE_PRINCIPAL_WINDOW = new Dimension(600,400);
	public static final Dimension SIZE_IMAGE_FRAME_PRINCIPAL = new Dimension(300,150);
	public static final Dimension SIZE_TEXT_MY_FAMILY = new Dimension(500, 100);
	public static final Dimension SIZE_TEXT_CHARGE = new Dimension(180, 50);
	
	//localizacion de componentes
	public static final Point LOCATION_IMAGE_FRAME_PRINCIPAL = null;
	
	//ruta de imagenes 
	public static final String IMAGE_FRAME_PINCIPAL = "../images/familiaPrincipal.png";
	public static final String IMAGE_FRAME_TREE= "../images/FondoCampestre.jpg";
	public static final String IMAGE_LINE = "../images/linea2.png";
	public static final String PATH_FONT_ROSE = "../fontsResources/Rose Cake - Personal Use.otf";
	public static final String PATH_FONT_CARTOON = "../fontsResources/CartooNature.ttf";
	
	//ruta sonidos
	public static final String PATH_DIRECTORY_SOUNDS = "../mySounds/";
	
	//formato de archivos
	public static final String FORMAT_WAV = ".wav";
	
	//nombre de sonidos
	public static final String CHILDRENS_PLAY = "ni�osJugando";
	
	//Mensajes
	public static final String MESSAGE_MY_FAMILY = "MY FAMILIA";
	public static final String MESSAGE_CHARGE = "Cargando....";
	public static final String ADVANCE = "avanzar";
	public static final String BACK = "retroceder";
	public static final String UP_OR_DOWN = "eje_y";
	public static final String MOVING_SIDE = "eje_x";
	
	//tama�os de fuentes
	public static final int SIZE_FONT_MY_FAMILY = 80;
	public static final int SIZE_FONT_CHARGE = 30;
	
	//tiempo que va a esperar el splash
	public static final int TIME_TO_WAIT = 10;
	
}
