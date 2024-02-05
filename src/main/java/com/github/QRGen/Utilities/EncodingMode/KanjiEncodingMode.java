package com.github.QRGen.Utilities.EncodingMode;

import com.github.QRGen.Utilities.EncodingMode.Interfaces.EncodingMode;

public class KanjiEncodingMode implements EncodingMode {
  private String modeValue;

  public KanjiEncodingMode(String modeValue) {
    this.modeValue = modeValue;
  }

  @Override
  public String getMode(String data) throws EncodingDeterminationException {
    // TODO Auto-generated method stub
    return modeValue;
  }
}
