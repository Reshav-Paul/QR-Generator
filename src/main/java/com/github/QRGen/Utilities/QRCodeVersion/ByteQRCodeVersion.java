package com.github.QRGen.Utilities.QRCodeVersion;

import com.github.QRGen.Utilities.ErrorCorrection.ErrorCorrectionLevel;
import com.github.QRGen.Utilities.QRCodeVersion.Interfaces.QRCodeVersion;

public class ByteQRCodeVersion implements QRCodeVersion {
    private int length;
    private ErrorCorrectionLevel errorCorrectionLevel;

    public ByteQRCodeVersion(int length, ErrorCorrectionLevel errorCorrectionLevel) {
        this.length = length;
        this.errorCorrectionLevel = errorCorrectionLevel;
    }

    @Override
    public String getVersion() throws QRCodeVersionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVersion'");
    }

    @Override
    public int getCodeWord() throws QRCodeVersionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCodeWord'");
    }

    @Override
    public int getCodeWordBits() throws QRCodeVersionException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCodeWordBits'");
    }

}
