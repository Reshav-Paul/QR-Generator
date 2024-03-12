package com.github.QRGen.Encoder;

import com.github.QRGen.Encoder.Interfaces.Encoder;
import com.github.QRGen.Utilities.CharacterCountIndicator.Interfaces.CharacterCountIndicator;
import com.github.QRGen.Utilities.EncodingMode.Interfaces.EncodingMode;
import com.github.QRGen.Utilities.QRCodeVersion.Interfaces.QRCodeVersion;

public class QREncoder implements Encoder {
  private Encoder _dataEncoder;
  private QRCodeVersion _qrCodeVersion;
  private CharacterCountIndicator _cciIndicator;
  private EncodingMode _encodingMode;

  public QREncoder(Encoder dataEncoder, QRCodeVersion qrCodeVersion, CharacterCountIndicator cci,
      EncodingMode encodingMode) {
    this._dataEncoder = dataEncoder;
    this._qrCodeVersion = qrCodeVersion;
    this._cciIndicator = cci;
    this._encodingMode = encodingMode;
  }

  public Encoder get_dataEncoder() {
    return _dataEncoder;
  }

  public QRCodeVersion get_qrCodeVersion() {
    return _qrCodeVersion;
  }

  public CharacterCountIndicator get_cciIndicator() {
    return _cciIndicator;
  }

  public EncodingMode get_encodingMode() {
    return _encodingMode;
  }

  @Override
  public String encode(String data) throws EncoderException {
    try {
      String dataBits = this._dataEncoder.encode(data);
      String cciValue = this._cciIndicator.getCCI();
      String encodingModeValue = this._encodingMode.getMode(data);
      return encodingModeValue + cciValue + dataBits;
    } catch (Exception e) {
      throw new EncoderException(e.getMessage());
    }
  }

}
