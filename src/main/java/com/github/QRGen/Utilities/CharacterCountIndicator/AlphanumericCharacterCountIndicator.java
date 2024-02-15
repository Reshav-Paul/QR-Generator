package com.github.QRGen.Utilities.CharacterCountIndicator;

import com.github.QRGen.Utilities.CharacterCountIndicator.Interfaces.CharacterCountIndicator;
import com.github.QRGen.Utilities.QRCodeVersion.QRCodeVersionException;
import com.github.QRGen.Utilities.QRCodeVersion.Interfaces.QRCodeVersion;

public class AlphanumericCharacterCountIndicator implements CharacterCountIndicator {
    private int _characterCount;
    private QRCodeVersion _qrCodeVersion;

    public AlphanumericCharacterCountIndicator(int characterCount, QRCodeVersion qrCodeVersion) {
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
    public String getCCI() throws CharacterCountIndicatorException, QRCodeVersionException {
        String cciBinary = Integer.toBinaryString(_characterCount);
        int desiredLength = getCCIBitsLength();
        String padding = "0".repeat(desiredLength - cciBinary.length());
        return padding + cciBinary;
    }

    private int getCCIBitsLength() throws CharacterCountIndicatorException, QRCodeVersionException {
        String version = _qrCodeVersion.getVersion();
        if (version.equals("M1")) {
            throw new CharacterCountIndicatorException("CCI not available");
        } else if (version.equals("M2")) {
            return 3;
        } else if (version.equals("M3")) {
            return 4;
        } else if (version.equals("M4")) {
            return 5;
        } else if (version.matches("^([1-9])$")) {
            return 9;
        } else if (version.matches("^(1[0-9]|2[0-6])$")) {
            return 11;
        } else if (version.matches("^(2[7-9]|3[0-9]|4[0])$")) {
            return 13;
        }
        throw new CharacterCountIndicatorException("CCI couldn't be determined");
    }
}
