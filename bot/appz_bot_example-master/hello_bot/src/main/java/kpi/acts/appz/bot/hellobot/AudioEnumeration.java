package kpi.acts.appz.bot.hellobot;

import javax.sound.sampled.AudioInputStream;
import java.util.Enumeration;

public final class AudioEnumeration implements Enumeration<AudioInputStream> {
    private AudioInputStream[] streams;
    int cursor;

    public AudioEnumeration(AudioInputStream[] streams) {
        this.streams = streams;
    }

    public boolean hasMoreElements() {
        return (cursor < streams.length);
    }

    public AudioInputStream nextElement() {
        return streams[cursor++];
    }
}
