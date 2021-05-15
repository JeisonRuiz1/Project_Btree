package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import resources.Constants;

public class FrameTree extends JFrame{
	
	private BackgroundPanel panel;
	private PanelTree panelTree;
	private PanelInfo panelInfo;
	private JScrollPane scroll;
	
	public FrameTree() {
		this.setSize(Constants.SIZE_FRAME);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		addElements();
		init();
	}
	
	public void addElements() { 
		//añadimos el panel que dibujará el árbol
		panelTree = new PanelTree(new Dimension(((this.getWidth()/4)*3) - 10, ((this.getHeight()/4)*3)- 10) , new Point(5,5));
		this.getContentPane().add(panelTree);
		
		//scollpane que tendrá el panel del árbol
		scroll = new JScrollPane(panelTree);
		scroll.getViewport().setOpaque(false);
		scroll.setBackground(new Color(0,0,0,0));
		this.getContentPane().add(scroll);
		scroll.setSize(panelTree.getSize());
		scroll.setLocation(panelTree.getLocation());
		
		//añadimos el panel que Mostrará la info
		panelInfo = new PanelInfo(new Dimension((this.getWidth()/4) - 20, ((this.getHeight()/4)*3)- 10) , new Point(panelTree.getWidth() + 10, 5));
		this.getContentPane().add(panelInfo);
		
		// añadimos el panel de imagen de fondo
		panel = new BackgroundPanel(Constants.IMAGE_FRAME_TREE, this.getSize(), new Point(0, 0));
		this.getContentPane().add(panel);
	}
	
	public void init() {
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		FrameTree frame = new FrameTree();
	}
}
