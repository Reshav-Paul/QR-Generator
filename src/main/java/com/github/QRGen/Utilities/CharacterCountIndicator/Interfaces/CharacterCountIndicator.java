package com.github.QRGen.Utilities.CharacterCountIndicator.Interfaces;

import com.github.QRGen.Utilities.CharacterCountIndicator.CharacterCountIndicatorException;
import com.github.QRGen.Utilities.QRCodeVersion.QRCodeVersionException;
import com.github.QRGen.Utilities.QRCodeVersion.Interfaces.QRCodeVersion;

public interface CharacterCountIndicator {
    public String getCCI() throws CharacterCountIndicatorException, QRCodeVersionException;

    public int getCharacterCount();

    public QRCodeVersion getQrCodeVersion();
}
