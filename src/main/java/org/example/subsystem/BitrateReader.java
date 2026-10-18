package org.example.subsystem;

public class BitrateReader {

    public byte[] read(MediaFile file, Codec sourceCodec) {
        System.out.println("[BitrateReader] reading " + file.name()
                + " with " + sourceCodec.name() + " codec");
        return file.data();
    }

    public byte[] convert(byte[] buffer, Codec targetCodec) {
        System.out.println("[BitrateReader] converting to " + targetCodec.name());
        return targetCodec.encode(buffer);
    }
}