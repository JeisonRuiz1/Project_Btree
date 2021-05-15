package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

public class PanelTree <T> extends JPanel{
	
	private Dimension size;
	private Point locale;
	
	public PanelTree(Dimension size, Point locale) {
		this.size = size;
		this.locale = locale;
		init();
	}
	
	public void init() {
		this.setSize(size);
		this.setLocation(locale);
		this.setBackground(new Color(0,0,0,80));
	}
	
	public void drawTree(T[][] list) {
		
	}

}
