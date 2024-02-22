package com.github.QRGen.Utilities.CharacterCountIndicator;

import com.github.QRGen.Utilities.CharacterCountIndicator.Interfaces.CharacterCountIndicator;
import com.github.QRGen.Utilities.QRCodeVersion.QRCodeVersionException;
import com.github.QRGen.Utilities.QRCodeVersion.Interfaces.QRCodeVersion;

public class AlphanumericCharacterCountIndicator implements CharacterCountIndicator {
    private int _characterCount;
    private QRCodeVersion _qrCodeVersion;
    private CCILength _cciLength;

    public AlphanumericCharacterCountIndicator(int characterCount, QRCodeVersion qrCodeVersion) {
        this._characterCount = characterCount;
        this._qrCodeVersion = qrCodeVersion;
        this._cciLength = new CCILength(new int[] { -1, 3, 4, 5, 9, 11, 13 });
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

        int desiredLength = _cciLength.getCCIBitsLength(_qrCodeVersion.getVersion());
        String padding = "0".repeat(desiredLength - cciBinary.length());
        return padding + cciBinary;
    }
}
