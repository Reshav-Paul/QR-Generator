package com.github.QRGen.Encoder;

import com.github.QRGen.Encoder.Interfaces.Encoder;
import com.github.QRGen.Utilities.CharacterCountIndicator.NumericCharacterCountIndicator;
import com.github.QRGen.Utilities.CharacterCountIndicator.Interfaces.CharacterCountIndicator;
import com.github.QRGen.Utilities.EncodingMode.NumericEncodingMode;
import com.github.QRGen.Utilities.EncodingMode.Interfaces.EncodingMode;
import com.github.QRGen.Utilities.ErrorCorrection.ErrorCorrectionLevel;
import com.github.QRGen.Utilities.QRCodeVersion.NumericQRCodeVersion;
import com.github.QRGen.Utilities.QRCodeVersion.Interfaces.QRCodeVersion;

public class NumericEncoder implements Encoder {
  private String _encodingModeValue = "0001";
  private char _errorCorrectionLevel;

  public NumericEncoder(char errorCorrectionLevel) {
    this._errorCorrectionLevel = errorCorrectionLevel;
  }

  @Override
  public String encode(String data) throws EncoderException {

    Encoder dataBitEncoder = new NumericDataBitEncoder();
    QRCodeVersion qrCodeVersion = new NumericQRCodeVersion(
        data.length(),
        new ErrorCorrectionLevel(this._errorCorrectionLevel));
    CharacterCountIndicator cciIndicator = new NumericCharacterCountIndicator(data.length(), qrCodeVersion);
    EncodingMode encodingMode = new NumericEncodingMode(_encodingModeValue);

    QREncoder encoder = new QREncoder(dataBitEncoder, qrCodeVersion, cciIndicator, encodingMode);
    return encoder.encode(data);
  }

}