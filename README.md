# Assignment 4 — Facade Pattern

Author: Ibrahim Zhumagali
Course:  Software Design Patterns

## Idea
`MediaConversionFacade` hides a complex media-conversion subsystem behind one method:
`convert(MediaFile source, String targetFormat)`.

## Structure
- `subsystem/` — MetadataReader, CodecFactory, Codec, Mp4Codec, OggCodec, BitrateReader, AudioMixer, MediaFile, MediaMetadata
- `facade/` — MediaConversionFacade, ConversionException
- `client/` — Main (uses only the facade)

## Conversion steps inside the facade
1. MetadataReader reads the source format
2. CodecFactory picks source and target codecs
3. BitrateReader reads and re-encodes the data
4. AudioMixer normalizes audio and builds the result file

## How to run
Open in IntelliJ IDEA and run `org.example.client.Main`.