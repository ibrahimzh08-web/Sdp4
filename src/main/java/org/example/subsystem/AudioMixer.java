
package org.example.subsystem;

public class AudioMixer {

    public MediaFile fix(byte[] buffer, String newName) {
        System.out.println("[AudioMixer] normalizing audio for " + newName);
        return new MediaFile(newName, buffer);
    }
}