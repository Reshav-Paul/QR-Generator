package com.github.QRGen.Utilities.CharacterCountIndicator;

import com.github.QRGen.Utilities.CharacterCountIndicator.Interfaces.CharacterCountIndicator;
import com.github.QRGen.Utilities.QRCodeVersion.Interfaces.QRCodeVersion;

public class ByteCharacterCountIndicator implements CharacterCountIndicator {
    private int characterCount;
    private QRCodeVersion qrCodeVersion;

    public ByteCharacterCountIndicator(int characterCount, QRCodeVersion qrCodeVersion) {
        this.characterCount = characterCount;
        this.qrCodeVersion = qrCodeVersion;
    }

    @Override
    public int getCharacterCount() {
        return characterCount;
    }

    @Override
    public QRCodeVersion getQrCodeVersion() {
        return qrCodeVersion;
    }

    @Override
    public String getCCI() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCCI'");
    }

}
