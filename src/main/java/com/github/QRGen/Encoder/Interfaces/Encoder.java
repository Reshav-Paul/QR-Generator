package com.github.QRGen.Encoder.Interfaces;

import com.github.QRGen.Encoder.EncoderException;

public interface Encoder {
    public String encode(String data) throws EncoderException;
}
