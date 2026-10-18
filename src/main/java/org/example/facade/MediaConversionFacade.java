package org.example.facade;

import org.example.subsystem.*;

public class MediaConversionFacade {
    private final MetadataReader metadataReader = new MetadataReader();
    private final CodecFactory codecFactory = new CodecFactory();
    private final BitrateReader bitrateReader = new BitrateReader();
    private final AudioMixer audioMixer = new AudioMixer();

    public MediaFile convert(MediaFile source, String targetFormat) {
        System.out.println("=== Converting " + source.name() + " to " + targetFormat + " ===");
        try {
            MediaMetadata metadata = metadataReader.read(source);
            Codec sourceCodec = codecFactory.forFormat(metadata.format());
            Codec targetCodec = codecFactory.forFormat(targetFormat);

            byte[] buffer = bitrateReader.read(source, sourceCodec);
            byte[] converted = bitrateReader.convert(buffer, targetCodec);

            return audioMixer.fix(converted, changeExtension(source.name(), targetFormat));
        } catch (IllegalArgumentException e) {
            throw new ConversionException("Cannot convert " + source.name() + ": " + e.getMessage(), e);
        }
    }

    private String changeExtension(String fileName, String newFormat) {
        int dot = fileName.lastIndexOf('.');
        return fileName.substring(0, dot) + "." + newFormat;
    }
}