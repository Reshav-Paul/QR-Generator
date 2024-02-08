package com.github.QRGen.Utilities.QRCodeVersion.Interfaces;

import com.github.QRGen.Utilities.QRCodeVersion.QRCodeVersionException;

public interface QRCodeVersion {
    String getVersion() throws QRCodeVersionException;

    int getCodeWord() throws QRCodeVersionException;

    int getCodeWordBits() throws QRCodeVersionException;
}
