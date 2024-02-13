package com.github.QRGen.Utilities.EncodingMode;

import com.github.QRGen.Utilities.EncodingMode.Interfaces.EncodingMode;

public class NumericEncodingMode implements EncodingMode {
  private String modeValue;

  public NumericEncodingMode(String modeValue) {
    this.modeValue = modeValue;
  }

  @Override
  public String getMode(String data) throws EncodingDeterminationException {
    if (data == null || data.length() == 0)
      throw new EncodingDeterminationException();
    if (isNumeric(data)) {
      return modeValue;
    }
    throw new EncodingDeterminationException();
  }

  private boolean isNumeric(String data) {
    String characterSetRegex = "^[0-9]*$";
    return data.matches(characterSetRegex);
  }
}