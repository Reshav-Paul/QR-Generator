package com.github.QRGen.Utilities.CharacterCountIndicator;

import com.github.QRGen.Utilities.CharacterCountIndicator.Interfaces.CharacterCountIndicator;
import com.github.QRGen.Utilities.QRCodeVersion.Interfaces.QRCodeVersion;

public class ByteCharacterCountIndicator implements CharacterCountIndicator {
    private int _characterCount;
    private QRCodeVersion _qrCodeVersion;

    public ByteCharacterCountIndicator(int characterCount, QRCodeVersion qrCodeVersion) {
        this._characterCount = characterCount;
        this._qrCodeVersion = qrCodeVersion;
    }

    @Override
    public int getCharacterCount() {
        return _characterCount;
    }

    @Override
    public QRCodeVersion getQrCodeVersion() {
        return _qrCodeVersion;
    }

    @Override
    public String getCCI() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCCI'");
    }

}
