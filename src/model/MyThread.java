package model;

import javax.swing.JLabel;
import javax.swing.JWindow;

public class MyThread extends Thread{
	
	private JLabel labelText;
	private JWindow window;
	
	public MyThread(JLabel labelText, JWindow window) {
		this.labelText = labelText;
		this.window = window;
	}
	
	/**
	 * Metodo encargado de iniciar el estado de carga del label instanciado
	 * @param timeToRun tiempo en segundos que va a estar la ventana abierta o el label cargando
	 */
	public void initCharge(int timeToRun) {
		timeToRun = timeToRun * 5;
		String[] list = labelText.getText().split("");
		int size = list.length;
		String auxText = "";
		int aux = 0;
		try {
			while (timeToRun != 0) {
				if (aux != size) {
					auxText += list[aux];
					this.sleep(200);
					timeToRun--;
				} else {
					auxText = "";
					aux = -1;
				}
				aux++;
				labelText.setText(auxText);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.start();
		window.setVisible(false);
	}	
}
