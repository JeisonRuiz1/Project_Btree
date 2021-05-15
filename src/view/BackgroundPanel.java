package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fonts.MyFont;

public class BackgroundPanel extends JPanel{

	private JLabel labelCharge;
	private Dimension size;
	private Image image;
	private Point locale;
	private Color color;
	
	/**
	 * Crea el panel y añade una imagen al mismo
	 * @param pathImage
	 * @param size
	 * @param locale
	 */
	public BackgroundPanel(String pathImage, Dimension size, Point locale) {
		this.setLayout(null);
		this.size = size;
		this.locale = locale;
		image = new ImageIcon(getClass().getResource(pathImage)).getImage();
		init();
	}
	
	/**
	 * Crea un panel y pone solamente el color
	 * @param color
	 * @param size
	 * @param locale
	 */
	public BackgroundPanel(Color color, Dimension size, Point locale) {
		this.setLayout(null);
		this.size = size;
		this.locale = locale;
		this.color = color;
		init();
	}
	
	public void init() {
		this.setSize(size);
		this.setLocation(locale);
	}
	
	@Override
    public void paint(Graphics g) {
		if(image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
		} else if(color != null){
			this.setBackground(color);
			setOpaque(true);
		} else {
			System.out.println("No se pudo crear el panel");
		}
        super.paint(g);
    }
	
	public void addImage(String pathImage, Dimension sizeImage, Point localeImage) {
		MyImage imageAux = new MyImage(pathImage, sizeImage, localeImage);
		add(imageAux);
	}
	
	public void addText(String text, Dimension size, Point locale, String font, float sizeFont) {
		JLabel thisText = new JLabel(text);
		thisText.setSize(size);
		thisText.setLocation(locale);
		thisText.setFont(new MyFont().fuente(font, 1, sizeFont));
		thisText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		this.add(thisText);
	}
	
	public void setLabelCharge(String text, Dimension size, Point locale, String font, float sizeFont) {
		labelCharge = new JLabel(text);
		labelCharge.setSize(size);
		labelCharge.setLocation(locale);
		labelCharge.setFont(new MyFont().fuente(font, 1, sizeFont));
		labelCharge.setBackground(Color.BLACK);
		this.add(labelCharge);
	}

	public JLabel getLabelCharge() {
		return labelCharge;
	}
}
