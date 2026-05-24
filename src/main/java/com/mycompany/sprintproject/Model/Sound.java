package com.mycompany.sprintproject.Model;

import static com.raylib.Raylib.InitAudioDevice;

public class Sound {
    private int volume;
    private boolean playing;
    private boolean paused;
    private boolean stopped;

    public Sound() {
        this.volume = 100;
        this.playing = false;
        this.paused = false;
        this.stopped = false;
    }

    public void init() {
        InitAudioDevice();
    }

    public void play() {
        this.playing = true;
        this.paused = false;
        this.stopped = false;
    }

    public void pause() {
        this.playing = false;
        this.paused = true;
        this.stopped = false;
    }

    public void stop() {
        this.playing = false;
        this.paused = false;
        this.stopped = true;
    }
}
