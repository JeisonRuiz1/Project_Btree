package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyImage extends JLabel{
	
	private Image image;
	private Dimension size;
	private Point locale;
	
	public MyImage(String pathImage, Dimension size, Point locale) {
		this.size = size; 
		this.locale = locale;
		image = new ImageIcon(getClass().getResource(pathImage)).getImage();
		init();
	}
	
	public void init() {
		this.setSize(size);
		this.setLocation(locale);
	}
	
	@Override
    public void paint(Graphics g) {
		try {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
		} catch (Exception e) {
			this.setBackground(Color.blue);
			setOpaque(true);
		}
	
        super.paint(g);
    }
}
