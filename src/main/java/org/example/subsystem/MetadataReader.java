package org.example.subsystem;

public class MetadataReader {

    public MediaMetadata read(MediaFile file) {
        String format = extractExtension(file.name());
        int duration = file.data().length / 100;
        int bitrate = format.equals("mp4") ? 1500 : 320;
        System.out.println("[MetadataReader] " + file.name() + ": " + format
                + ", " + duration + "s, " + bitrate + " kbps");
        return new MediaMetadata(format, duration, bitrate);
    }

    private String extractExtension(String fileName) {
        int dot = fileName.lastIndexOf('.');
        if (dot < 0) {
            throw new IllegalArgumentException("File has no extension: " + fileName);
        }
        return fileName.substring(dot + 1).toLowerCase();
    }
}