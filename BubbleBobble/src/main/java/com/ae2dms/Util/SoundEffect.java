package com.ae2dms.Util;

import javafx.scene.media.AudioClip;

/**
 * SoundEffect handles the game's SFX.
 * Classes that want to use SFX will call the static variables in this enum and
 * play them via the play() method.
 */
public class SoundEffect {

	private static AudioClip BGM;
	private static AudioClip bubbled = new AudioClip(SoundEffect.class.getResource("/sound/bubbled.wav").toString());
	private static AudioClip click = new AudioClip(SoundEffect.class.getResource("/sound/click.wav").toString());
	private static AudioClip death = new AudioClip(SoundEffect.class.getResource("/sound/death.wav").toString());
	private static AudioClip explode = new AudioClip(SoundEffect.class.getResource("/sound/explode.wav").toString());
	private static AudioClip fruit = new AudioClip(SoundEffect.class.getResource("/sound/fruit.wav").toString());
	private static AudioClip jump = new AudioClip(SoundEffect.class.getResource("/sound/jump.wav").toString());
	private static AudioClip land = new AudioClip(SoundEffect.class.getResource("/sound/land.wav").toString());
	private static AudioClip shoot = new AudioClip(SoundEffect.class.getResource("/sound/shoot.wav").toString());
	private static AudioClip pop = new AudioClip(SoundEffect.class.getResource("/sound/pop.wav").toString());
	private static AudioClip victory = new AudioClip(SoundEffect.class.getResource("/sound/victory.wav").toString());
	private static AudioClip fail = new AudioClip(SoundEffect.class.getResource("/sound/fail.wav").toString());
	private static AudioClip nextLevel = new AudioClip(SoundEffect.class.getResource("/sound/nextLevel.wav").toString());

	private AudioClip audioClip = bubbled;

    /**
     * The enumeration of Volume.
     */
    public enum Volume {
        /**
         * Mute volume.
         */
        MUTE,
        /**
         * Low volume.
         */
        LOW,
        /**
         * Medium volume.
         */
        MEDIUM,
        /**
         * High volume.
         */
        HIGH
	}
	
	private Volume volume = Volume.LOW;

	private SoundEffect() {}

	private static SoundEffect instance = new SoundEffect();

    /**
     * Gets instance of sound effect.
     *
     * @return the instance
     */
    public static SoundEffect getInstance() {
		return instance;
	}


    /**
     * Play the required sound with specific volume.
     *
     * @param src the src
     */
    public void play(String src) {

		// plays the sound effect
		if (volume != Volume.MUTE) {
			if (audioClip != death && audioClip != victory && audioClip != nextLevel && audioClip.isPlaying()) {
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
					break;

				case  "victory":
					audioClip = victory;
					break;

				case "fail":
					audioClip = fail;
					break;
				case "nextLevel":
					audioClip = nextLevel;
			}

			switch (volume) {
				case LOW:
					audioClip.setVolume(0.33);
					break;

				case MEDIUM:
					audioClip.setVolume(0.66);
					break;

				case HIGH:
					audioClip.setVolume(1);
					break;

				case MUTE:
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

    /**
     * Sets volume of the sound effect.
     *
     * @param volume the volume
     */
    public static void setVolume(SoundEffect.Volume volume) {
		SoundEffect.instance.volume = volume;
	}
}
