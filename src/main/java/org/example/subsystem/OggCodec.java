package org.example.subsystem;

import java.util.Arrays;

public class OggCodec implements Codec {

    @Override
    public String name() {
        return "ogg";
    }

    @Override
    public byte[] encode(byte[] raw) {
        System.out.println("[OggCodec] encoding " + raw.length + " bytes to OGG");
        return Arrays.copyOf(raw, raw.length / 3);
    }
}