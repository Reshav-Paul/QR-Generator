package com.github.QRGen.Utilities.CharacterCountIndicator.Interfaces;

import com.github.QRGen.Utilities.CharacterCountIndicator.CharacterCountIndicatorException;
import com.github.QRGen.Utilities.QRCodeVersion.QRCodeVersionException;
import com.github.QRGen.Utilities.QRCodeVersion.Interfaces.QRCodeVersion;

public interface CharacterCountIndicator {
    public enum QRVersion {
        M1(0), M2(1), M3(2), M4(3), OneToNine(4), TenToTwentySix(5), TwentySevenToForty(6);

        private final int value;

        private QRVersion(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public String getCCI() throws CharacterCountIndicatorException, QRCodeVersionException;

    public int getCharacterCount();

    public QRCodeVersion getQrCodeVersion();
}
