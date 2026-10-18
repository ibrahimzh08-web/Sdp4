package org.example.subsystem;

import java.util.Arrays;

public class Mp4Codec implements Codec {

    @Override
    public String name() {
        return "mp4";
    }

    @Override
    public byte[] encode(byte[] raw) {
        System.out.println("[Mp4Codec] encoding " + raw.length + " bytes to MP4");
        return Arrays.copyOf(raw, raw.length / 2);
    }
}