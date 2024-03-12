package com.github.QRGen.Encoder;

import com.github.QRGen.Encoder.Interfaces.Encoder;
import com.github.QRGen.Utilities.CharacterCountIndicator.AlphanumericCharacterCountIndicator;
import com.github.QRGen.Utilities.CharacterCountIndicator.Interfaces.CharacterCountIndicator;
import com.github.QRGen.Utilities.EncodingMode.AlphanumericEncodingMode;
import com.github.QRGen.Utilities.EncodingMode.Interfaces.EncodingMode;
import com.github.QRGen.Utilities.ErrorCorrection.ErrorCorrectionLevel;
import com.github.QRGen.Utilities.QRCodeVersion.AlphanumericQRCodeVersion;
import com.github.QRGen.Utilities.QRCodeVersion.Interfaces.QRCodeVersion;

public class AlphanumericEncoder implements Encoder {
  private String _encodingModeValue = "0010";
  private char _errorCorrectionLevel;

  public AlphanumericEncoder(char errorCorrectionLevel) {
    this._errorCorrectionLevel = errorCorrectionLevel;
  }

  @Override
  public String encode(String data) throws EncoderException {

    Encoder dataBitEncoder = new AlphanumericDataBitEncoder();
    QRCodeVersion qrCodeVersion = new AlphanumericQRCodeVersion(
        data.length(),
        new ErrorCorrectionLevel(this._errorCorrectionLevel));
    CharacterCountIndicator cciIndicator = new AlphanumericCharacterCountIndicator(data.length(), qrCodeVersion);
    EncodingMode encodingMode = new AlphanumericEncodingMode(_encodingModeValue);

    QREncoder encoder = new QREncoder(dataBitEncoder, qrCodeVersion, cciIndicator, encodingMode);
    return encoder.encode(data);
  }

}