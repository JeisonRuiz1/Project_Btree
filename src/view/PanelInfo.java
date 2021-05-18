package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

public class PanelInfo extends JPanel{
	
	private Dimension size;
	private Point locale;
	
	public PanelInfo(Dimension size, Point locale) {
		this.size = size;
		this.locale = locale;
		init();
	}
	
	public void init() {
		this.setSize(size);
		this.setLocation(locale);
	}


}
