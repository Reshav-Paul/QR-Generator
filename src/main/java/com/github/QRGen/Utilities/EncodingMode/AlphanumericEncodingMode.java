package com.github.QRGen.Utilities.EncodingMode;

import com.github.QRGen.Utilities.EncodingMode.Interfaces.EncodingMode;

public class AlphanumericEncodingMode implements EncodingMode {
  private String modeValue;

  public AlphanumericEncodingMode(String modeValue) {
    this.modeValue = modeValue;
  }

  @Override
  public String getMode(String data) throws EncodingDeterminationException {
    if (data == null)
      throw new EncodingDeterminationException();
    if (isAlphanumeric(data)) {
      return modeValue;
    }
    throw new EncodingDeterminationException();
  }

  private boolean isAlphanumeric(String data) {
    String characterSetRegex = "^[A-Z0-9 $%*+-./:]*$";
    if (data.matches(characterSetRegex))
      return true;
    return false;
  }
}
