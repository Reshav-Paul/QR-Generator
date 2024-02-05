package com.github.QRGen.Utilities.EncodingMode.Interfaces;

import com.github.QRGen.Utilities.EncodingMode.EncodingDeterminationException;

// Functional Interface
public interface EncodingMode {
  String getMode(String data) throws EncodingDeterminationException;
}
