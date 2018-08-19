package pz;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Music {
	private Clip clip;
	URL soundURL;
	private boolean play = true;

	public Music() {
		CreatMusic();
		run();
	}

	private void CreatMusic() {
		soundURL = getClass().getResource("/sound/ThemeWav.wav"); 
		
			AudioInputStream ais;
			try {
				ais = AudioSystem.getAudioInputStream(soundURL);
				clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	private Timeline timeline;

	private void run() {
		timeline = new Timeline(new KeyFrame(Duration.seconds(2), ev -> {
			if (!clip.isActive()) {
				clip.setFramePosition(0);
				clip.start();
			}
		}));

		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	public void Los() {
		if (play) {
			timeline.stop();
			clip.stop();
			soundURL = getClass().getResource("/sound/Los.wav"); 
			
			AudioInputStream ais;
			try {
				ais = AudioSystem.getAudioInputStream(soundURL);
				clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			play = false;
		}
	}

	public void Win() {
		if (play) {
			timeline.stop();
			clip.stop();
			soundURL = getClass().getResource("/sound/Win.wav"); 
			
			AudioInputStream ais;
			try {
				ais = AudioSystem.getAudioInputStream(soundURL);
				clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			play = false;
		}
	}
}
