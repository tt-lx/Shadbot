package me.shadorc.shadbot.music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;

import discord4j.voice.AudioProvider;

//TODO Better name
public class IshAudioProvider implements AudioProvider {

	private final AudioPlayer audioPlayer;
	private AudioFrame lastFrame;

	public IshAudioProvider(AudioPlayer audioPlayer) {
		this.audioPlayer = audioPlayer;
	}

	@Override
	public boolean isDone() {
		if(lastFrame == null) {
			lastFrame = audioPlayer.provide();
		}

		return lastFrame == null;
	}

	@Override
	public byte[] provide() {
		if(lastFrame == null) {
			lastFrame = audioPlayer.provide();
		}

		byte[] data = lastFrame == null ? null : lastFrame.getData();
		lastFrame = null;

		return data;
	}

}