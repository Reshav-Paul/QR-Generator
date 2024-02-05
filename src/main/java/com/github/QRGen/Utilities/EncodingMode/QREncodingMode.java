package com.github.QRGen.Utilities.EncodingMode;

import java.util.List;

import com.github.QRGen.Utilities.EncodingMode.Interfaces.EncodingMode;

public class QREncodingMode {
  private List<EncodingMode> encodingModes;

  public QREncodingMode(List<EncodingMode> encodingModes) {
    this.encodingModes = encodingModes;
  }

  public String determine(String data) throws EncodingDeterminationException {
    for (EncodingMode encodingMode : this.encodingModes) {
      try {
        return encodingMode.getMode(data);
      } catch (Exception e) {
      }
    }
    throw new EncodingDeterminationException();
  }
}