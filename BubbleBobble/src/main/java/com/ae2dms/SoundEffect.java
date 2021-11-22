package com.ae2dms;

//import java.io.*;
//import java.net.URL;
//import javax.sound.sampled.*;

import javafx.scene.media.AudioClip;

/**
 * SoundEffect handles the game's SFX.
 * Classes that want to use SFX will call the static variables in this enum and
 * play them via the play() method.
 */
public enum SoundEffect {
	FRUIT("/sound/fruit.wav"),
	DEATH("/sound/death.wav"),
	SHOOT("/sound/shoot.wav"),
	POP("/sound/pop.wav"),
	BUBBLED("/sound/bubbled.wav"),
	JUMP("/sound/jump.wav"),
	EXPLODE("/sound/explode.wav"),
	LAND("/sound/land.wav");
	
	public static enum Volume {
		MUTE, LOW, MEDIUM, HIGH
	}
	
	public static Volume volume = Volume.LOW;
	
//	private Clip clip;
	private AudioClip audioClip;
	
	SoundEffect(String src) {
		// sets the sound effect
//		try {
//			URL url = this.getClass().getClassLoader().getResource(soundFileName);
//			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
//			clip = AudioSystem.getClip();
//			clip.open(audioInputStream);
//		} catch (UnsupportedAudioFileException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (LineUnavailableException e) {
//			e.printStackTrace();
//		}

	}
	
	public void play() {
		// plays the sound effect
		if (volume != Volume.MUTE) {
			if (audioClip.isPlaying()) {
				audioClip.stop();
			}
			audioClip.play();
//			if (clip.isRunning()) {
//				clip.stop();
//			}
//			clip.setFramePosition(0);
//			clip.start();
		}
	}
	
	public void setToLoop() {
		// sets whether or not the sound effect loops
//		clip.loop(clip.LOOP_CONTINUOUSLY);
		audioClip.setCycleCount(AudioClip.INDEFINITE);
	}
	
	public void setToLoud() {
		// sets volume to be loud
		volume = Volume.HIGH;
	}
}
