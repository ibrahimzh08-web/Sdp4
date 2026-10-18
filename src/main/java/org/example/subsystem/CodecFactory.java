package org.example.subsystem;

public class CodecFactory {

    public Codec forFormat(String format) {
        System.out.println("[CodecFactory] looking up codec for: " + format);
        return switch (format) {
            case "mp4" -> new Mp4Codec();
            case "ogg" -> new OggCodec();
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }
}