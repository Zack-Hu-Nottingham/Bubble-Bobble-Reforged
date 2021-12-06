package com.ae2dms.Util;

import javafx.scene.media.AudioClip;
/**
 * SoundEffect handles the game's SFX.
 * Classes that want to use SFX will call the static variables in this enum and
 * play them via the play() method.
 */
public class SoundEffect {

	private static AudioClip bubbled = new AudioClip(SoundEffect.class.getResource("/sound/bubbled.wav").toString());
	private static AudioClip click = new AudioClip(SoundEffect.class.getResource("/sound/click.mp3").toString());
	private static AudioClip death = new AudioClip(SoundEffect.class.getResource("/sound/death.wav").toString());
	private static AudioClip explode = new AudioClip(SoundEffect.class.getResource("/sound/explode.wav").toString());
	private static AudioClip fruit = new AudioClip(SoundEffect.class.getResource("/sound/fruit.wav").toString());
	private static AudioClip jump = new AudioClip(SoundEffect.class.getResource("/sound/jump.wav").toString());
	private static AudioClip land = new AudioClip(SoundEffect.class.getResource("/sound/land.wav").toString());
	private static AudioClip shoot = new AudioClip(SoundEffect.class.getResource("/sound/shoot.wav").toString());
	private static AudioClip pop = new AudioClip(SoundEffect.class.getResource("/sound/pop.wav").toString());

	private AudioClip audioClip = bubbled;

	public enum Volume {
		MUTE, LOW, MEDIUM, HIGH
	}
	
	private Volume volume = Volume.LOW;


	// singleton
	private static SoundEffect instance = new SoundEffect();

	public static SoundEffect getInstance() {
		return instance;
	}

	public SoundEffect() {}

	public void play(String src) {

		// plays the sound effect
		if (volume != Volume.MUTE) {
			if (audioClip.isPlaying()) {
				audioClip.stop();
			}
			switch (src) {
				case "bubble":
					audioClip = bubbled;
					break;

				case "click":
					audioClip = click;
					break;

					case "death":
					audioClip = death;
						break;

				case "explode":
					audioClip = explode;
					break;

				case "fruit":
					audioClip = fruit;
					break;

				case "jump":
					audioClip = jump;
					break;

				case "land":
					audioClip = land;
					break;

				case "pop":
					audioClip = pop;
					break;

				case "shoot":
					audioClip = shoot;
			}

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

			audioClip.play();
		}
	}
	
//	public void setToLoop() {
//		// sets whether or not the sound effect loops
////		clip.loop(clip.LOOP_CONTINUOUSLY);
//		audioClip.setCycleCount(AudioClip.INDEFINITE);
//	}

	public static void setVolume(SoundEffect.Volume volume) {
		SoundEffect.instance.volume = volume;
	}
}
