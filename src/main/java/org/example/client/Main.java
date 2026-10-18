package org.example.client;

import org.example.facade.ConversionException;
import org.example.facade.MediaConversionFacade;
import org.example.subsystem.MediaFile;

public class Main {
    public static void main(String[] args) {
        MediaConversionFacade converter = new MediaConversionFacade();

        MediaFile video = new MediaFile("video.ogg", new byte[3000]);
        MediaFile result = converter.convert(video, "mp4");
        System.out.println("Result: " + result.name() + ", " + result.data().length + " bytes\n");

        try {
            converter.convert(new MediaFile("song.avi", new byte[1000]), "mp4");
        } catch (ConversionException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}