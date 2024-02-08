package com.github.QRGen.Utilities.CharacterCountIndicator.Interfaces;

import com.github.QRGen.Utilities.QRCodeVersion.Interfaces.QRCodeVersion;

public interface CharacterCountIndicator {
    public String getCCI();

    public int getCharacterCount();

    public QRCodeVersion getQrCodeVersion();
}
