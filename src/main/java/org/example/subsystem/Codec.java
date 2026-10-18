package org.example.subsystem;

public interface Codec {
    String name();
    byte[] encode(byte[] raw);
}