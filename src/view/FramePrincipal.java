package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JWindow;

import animation.AnimComponent;
import model.MyThread;
import resources.Constants;
import sound.Sounds;

public class FramePrincipal extends JWindow{
	
	private AnimComponent anim;
	private MyImage image;
	private Sounds sound;
	private BackgroundPanel panel;
	
	public FramePrincipal() {
		this.setSize(Constants.SIZE_PRINCIPAL_WINDOW);
		this.getContentPane().setBackground(Color.blue);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		addElements();
	}
	
	public void init() {
		this.setVisible(true);
		//initAnimationCharge(Constants.TIME_TO_WAIT);
		sound = new Sounds();
		sound.playSound(Constants.CHILDRENS_PLAY, 5);
	}
	
	public void addElements() {
		//añadimos un panel para superPonerlo a la imagen
		panel = new BackgroundPanel(Color.blue, new Dimension((int) this.getWidth(), (int) this.getHeight()/2), new Point(0, this.getHeight()/2));
		this.getContentPane().add(panel);
		
		//añadimos la imagen principal
		image = new MyImage(Constants.IMAGE_FRAME_PINCIPAL, Constants.SIZE_IMAGE_FRAME_PRINCIPAL, 
				new Point(middlePoint(this.getWidth(), (int) Constants.SIZE_IMAGE_FRAME_PRINCIPAL.getWidth()), this.getHeight()/2));
		this.getContentPane().add(image);
		
		//añadimos la linea a el panel
		panel.addImage(Constants.IMAGE_LINE, new Dimension(this.getWidth()-100, 40), new Point(middlePoint(this.getWidth(), this.getWidth()-100), 0));
	
		//añadimos un texto al panel
		panel.addText(Constants.MESSAGE_MY_FAMILY, Constants.SIZE_TEXT_MY_FAMILY, new Point(middlePoint((int) this.getWidth(),(int) Constants.SIZE_TEXT_MY_FAMILY.width), 50), Constants.PATH_FONT_CARTOON, Constants.SIZE_FONT_MY_FAMILY);
	}
	
	public int middlePoint(int size1, int size2) {
		return (size1/2) - (size2/2);
	}
	
	public void initAnimationCharge(int time) {
		panel.setLabelCharge(Constants.MESSAGE_CHARGE, Constants.SIZE_TEXT_CHARGE, new Point(10, panel.getHeight() - 60), Constants.PATH_FONT_ROSE, Constants.SIZE_FONT_CHARGE);
		MyThread thread = new MyThread(panel.getLabelCharge(), this);
		thread.initCharge(time);
	}
	
	public void animImage() {
		anim = new AnimComponent(image, Constants.BACK, Constants.UP_OR_DOWN, image.getY(), 50, 20);
		anim.startAnimation();
	}

}
