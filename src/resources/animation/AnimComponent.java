package resources.animation;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import constants.Constants;

public class AnimComponent {
	
	private Component labelToAnim;
	private String moveTo;
	private String direction;
	private int initMovimient;
	private int findMoviment;
	private int speed;
	
	private boolean finish = false;
	
	private int countOfImages;
	private String pathArrayImages;
	private String formatImage;
	
	private Thread thread;
	
	//private Sounds run;
	
	/**
	* Graf�ca en un label una peque�a animaci�n
	* @param labelToAnim label que vamos a animar
	* @param moveTo indica si queremos mover la imagen hacia el frente o hacia atras
	* @param direction desplazar la imagen de arriba para abajo o al reves
	* @param initMovimient punto inicial del movimiento
	* @param findMoviment punto al que queremos llegar
	*/ 
	public AnimComponent(Component labelToAnim, String moveTo, String direction, int initMovimient, int findMoviment, int speed) {
		super();
		this.labelToAnim = labelToAnim;
		this.moveTo = moveTo;
		this.initMovimient = initMovimient;
		this.findMoviment = findMoviment;
		this.speed = speed;
		this.direction = direction;
	}
	
	/**
	 * Graf�ca en un label una peque�a animaci�n
	 * @param labelToAnim label que vamos a animar
	 * @param moveTo indica si queremos mover la imagen hacia el frente o hacia atras
	 * @param direction desplazar la imagen de arriba para abajo o al reves
	 * @param initMovimient punto inicial del movimiento
	 * @param findMoviment punto al que queremos llegar
	 * @param pathArrayImages direccion de las imagenes o sprite a cambiar
	 * @param countImages cuantas imagenes vamos a cambiar
	 * @param formatImage formato de las imagenes
	 * @param speed velocidad con la que se va a mover el frame
	 */
	public AnimComponent(Component labelToAnim, String moveTo, String direction, int initMovimient, int findMoviment, String pathArrayImages, int countImages, String formatImage, int speed) {
		super();
		this.labelToAnim = labelToAnim;
		this.moveTo = moveTo;
		this.initMovimient = initMovimient;
		this.findMoviment = findMoviment;
		this.speed = speed;
		this.direction = direction;
		this.pathArrayImages = pathArrayImages;
		this.countOfImages = countImages;
		this.formatImage = formatImage;
		//run = new Sounds();
	}
	
	
	/**
	 * inicia la animacion del label
	 */
	public void anim() {
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (findMoviment != initMovimient) {
					if (moveTo == Constants.ADVANCE) {
						if (direction == Constants.UP_OR_DOWN) {
							labelToAnim.setLocation(labelToAnim.getX(), initMovimient);
						}else {
							labelToAnim.setLocation(initMovimient, labelToAnim.getY());
						}
						initMovimient++;
					}else {
						if (direction == Constants.UP_OR_DOWN) {
							labelToAnim.setLocation(labelToAnim.getX(), initMovimient);
						}else {
							labelToAnim.setLocation(initMovimient, labelToAnim.getY());
						}
						initMovimient--;
					}
					//dormimos la ejecucion
					try {
						Thread.sleep(speed);
					} catch (Exception e) {
						
					}
				}
			}
		});
	}
	
	/**
	 * inicia la animacion del label, cambiando en cada iteraci�n la imagen del mismo
	 */
	public void animAndChangeImage() {
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				
				int numImage = 0;
				
				while (findMoviment != initMovimient) {
					
					if (moveTo == Constants.ADVANCE) {
						if (direction == Constants.UP_OR_DOWN) {
							labelToAnim.setLocation(labelToAnim.getX(), initMovimient);
						}else {
							labelToAnim.setLocation(initMovimient, labelToAnim.getY());
						}
						initMovimient++;
					}else {
						if (direction == Constants.UP_OR_DOWN) {
							labelToAnim.setLocation(labelToAnim.getX(), initMovimient);
						}else {
							labelToAnim.setLocation(initMovimient, labelToAnim.getY());
						}
						initMovimient--;
					}
					
					//cambiamos la imagen
					((JLabel) labelToAnim).setIcon(new ImageIcon(this.getClass().getResource(pathArrayImages + numImage + formatImage).getPath()));
					
					//dormimos la ejecucion
					try {
						Thread.sleep(speed);
					} catch (Exception e) {
						
					}
					
					//aumentamos el contador
					numImage ++;
					
					if (numImage >= countOfImages) {
						numImage = 0;
					}
					
					//le ponemos sonido
					if (numImage == 0) {
						//run.playVolumeSound(Constants.RUN_AVATAR, 0, -10.0f);
					}
				}
				finish = true;
				((JLabel) labelToAnim).setIcon(new ImageIcon(this.getClass().getResource(pathArrayImages + 12 + formatImage).getPath()));
			}
		});
	}
	
	/**
	 * inicia la animacion del componente
	 */
	public void startAnimation() {
		anim();
		thread.start();
	}
	
	/**
	 * nos dice si la animacion ya termino o esta en proceso
	 * @return
	 */
	public boolean getFinish() {
		return finish;
	}
	
	/**
	 * cambia el valor de finalizado a verdadero
	 * @param finish
	 */
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	
	/**
	 * inicia la animacion con cambio de imagen
	 */
	public void startAndChange() {
		animAndChangeImage();
		thread.start();
	}
}
