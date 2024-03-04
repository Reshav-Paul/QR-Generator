package com.github.QRGen.Encoder;

import java.util.List;

import com.github.QRGen.Encoder.Interfaces.Encoder;

public class NumericEncoder implements Encoder {

    private final int groupSize = 3;
    private final int[] desiredLengths = new int[] { 4, 7, 10 }; // 2^10 = 1024 which accomodates max 999

    @Override
    public String encode(String data) throws EncoderException {
        if (data == null || data.isEmpty()) {
            throw new EncoderException("Non null data expected");
        }
        StringBuilder binaryDataBuilder = new StringBuilder();
        List<String> groups = EncoderUtility.getGroups(data, groupSize);
        for (String group : groups) {
            String binaryData = Integer.toBinaryString(Integer.parseInt(group));
            String paddedData = "0".repeat(desiredLengths[group.length() - 1] - binaryData.length());
            binaryDataBuilder.append(paddedData);
            binaryDataBuilder.append(binaryData);
        }
        return binaryDataBuilder.toString();
    }
}
