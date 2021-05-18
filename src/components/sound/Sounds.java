package components.sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import constants.Constants;

/**
 * esta clase es capaz de reproducir sonidos en formato WAV
 * @author Jorge Ayala
 */
public class Sounds {

    Clip infinite;
    Clip clip;
    Clip clip2;

    /**
     * inicia un sonido cualquiera
     * @param sound sonido a reproducir
     * @param wait tiempo que dura el sonido reproduciendose
     */
    public void playSound(String sound, int wait) {
        try {
        	clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(this.getClass().getResource("..\\resources.mySounds\\niñosJugando.wav").getPath()));
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(wait);
        } catch (Exception e) {
        	System.out.println("error al reproducir el sonido");
        }
    }

    /**
     * Inicia la ejecuci�n del sonido con diferente volumen
     * @param nameTrak nombre de la cancion a ejecutar
     * @param waitInSeconds tiempo que va a durar el sonido reproduciendose
     * @param volumeDown la cantidad de volumen a reducir (en decibeles)
     */
    public void playVolumeSound(String nameTrak, int waitInSeconds, float volumeDown) {
        try {
            clip2 = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File( getClass().getResource(Constants.PATH_DIRECTORY_SOUNDS + nameTrak + Constants.FORMAT_WAV).getPath()));
            clip2.open(audioInputStream);
            FloatControl gainControl = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volumeDown); // Reduce volume by 10 decibels.
            clip2.loop(waitInSeconds * 1000);
        } catch (Exception e) {
        	System.out.println("No se encontro el sonido");
        }
    }
    
    /**
     * reduce o aumenta el volumen del sonido principal
     * @param value cuanto volumen desea disminuir o aumentar
     */
    public void setVolumeAllSound(float value) {
    	FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(value);
    }
    
    /**
     * reduce o aumenta el volumen del sonido repetitivo
     * @param value cuanto volumen desea aumentar o disminuir
     */
    public void setVolumeSoundLoop(float value) {
    	if (((int) value) == -15) {
			infinite.stop();
		}else {
			if (!infinite.isActive()) {
				infinite.loop(3000);
			}
			
			if (((int) value) == -5) {
				value = 0;
			}
			
			FloatControl gainControl = (FloatControl) infinite.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(value);
		}
    }

    /**
     * inicia un sonido que se va a repetir indefinidamente
     * @param sound sonido a reproducir
     * @param timeSound tiempo que va a durar el sonido escuchandose
     * @throws InterruptedException en caso de no encontrar la ruta del sonido
     */
    public void loopSound(String sound, int timeSound) throws InterruptedException {
    	try {
    		infinite = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Sounds.class.getResource(Constants.PATH_DIRECTORY_SOUNDS + sound + Constants.FORMAT_WAV));
            infinite.open(audioInputStream);
            infinite.loop(timeSound * 1000);
            Thread.sleep(timeSound);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    /**
     * detiene un sonido que es modificado su volumen a travez de decibeles
     */
    public void stopVolumeClip(){
        try {
            clip2.stop();
        } catch (Exception e) {
        }
    }

    /**
     * detiene un sonido, solamente los sonidos que se ejecutan una vez
     */
    public void stopSound() {
        try {
            clip.stop();
        } catch (Exception e) {

        }
    }

    /**
     * pausa o finaliza el sonido repetitivo
     */
    public void stopLoopSound() {
        try {
            infinite.stop();
        } catch (Exception e) {

        }
    }
    
    public static void main(String[] args) {
		Sounds sound = new Sounds();
		sound.playSound("niñosJugando", 10000);
	}

}