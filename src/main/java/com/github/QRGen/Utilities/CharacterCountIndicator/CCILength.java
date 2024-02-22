package com.github.QRGen.Utilities.CharacterCountIndicator;

import com.github.QRGen.Utilities.CharacterCountIndicator.Interfaces.CharacterCountIndicator;

public class CCILength {
    private int[] _characterCountLengths;

    public CCILength(int[] _characterCountLengths) {
        this._characterCountLengths = _characterCountLengths;
    }

    public int getCCIBitsLength(String version) throws CharacterCountIndicatorException {
        if (version.equals("M1")) {
            throw new CharacterCountIndicatorException("CCI not available");
        } else if (version.equals("M2")) {
            return _characterCountLengths[CharacterCountIndicator.QRVersion.M2.getValue()];
        } else if (version.equals("M3")) {
            return _characterCountLengths[CharacterCountIndicator.QRVersion.M3.getValue()];
        } else if (version.equals("M4")) {
            return _characterCountLengths[CharacterCountIndicator.QRVersion.M4.getValue()];
        } else if (version.matches("^([1-9])$")) {
            return _characterCountLengths[CharacterCountIndicator.QRVersion.OneToNine.getValue()];
        } else if (version.matches("^(1[0-9]|2[0-6])$")) {
            return _characterCountLengths[CharacterCountIndicator.QRVersion.TenToTwentySix.getValue()];
        } else if (version.matches("^(2[7-9]|3[0-9]|4[0])$")) {
            return _characterCountLengths[CharacterCountIndicator.QRVersion.TwentySevenToForty.getValue()];
        }
        throw new CharacterCountIndicatorException("CCI couldn't be determined");
    }
}
