package com.ae2dms.Util;

import javafx.scene.media.AudioClip;
/**
 * SoundEffect handles the game's SFX.
 * Classes that want to use SFX will call the static variables in this enum and
 * play them via the play() method.
 */
public class SoundEffect {
	
	public enum Volume {
		MUTE, LOW, MEDIUM, HIGH
	}
	
	public static Volume volume = Volume.LOW;

	private static AudioClip audioClip;

	public SoundEffect() {
	}
	
	public static void play(String src) {

		audioClip = new AudioClip(SoundEffect.class.getResource(src).toString());

		switch (volume) {
			case LOW:
				System.out.println("low");
				audioClip.setVolume(0.33);
				break;

			case MEDIUM:
				System.out.println("medium");
				audioClip.setVolume(0.66);
				break;

			case HIGH:
				System.out.println("high");
				audioClip.setVolume(1);
				break;

			case MUTE:
				System.out.println("mute");
				audioClip.setVolume(0);
				break;
		}

		// plays the sound effect
		if (volume != Volume.MUTE) {
			if (audioClip.isPlaying()) {
				audioClip.stop();
			}
			audioClip.play();
		}
	}
	
//	public void setToLoop() {
//		// sets whether or not the sound effect loops
////		clip.loop(clip.LOOP_CONTINUOUSLY);
//		audioClip.setCycleCount(AudioClip.INDEFINITE);
//	}
	
//	public static void setToLoud() {
//		// sets volume to be loud
//		volume = Volume.HIGH;
//	}

	public static void setVolume(SoundEffect.Volume volume) {
		SoundEffect.volume = volume;

	}
}
