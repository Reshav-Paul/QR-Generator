package com.github.QRGen.Encoder;

import java.util.ArrayList;
import java.util.List;

public class EncoderUtility {
    public static List<String> getGroups(String data, int groupSize) throws EncoderException {
        if (groupSize <= 0) {
            throw new EncoderException("Invalid group size");
        }
        List<String> groups = new ArrayList<>();
        for (int i = 0; i < data.length(); i += groupSize) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; (i + j) < data.length() && j < groupSize; j++) {
                sb.append(data.charAt(i + j));
            }
            groups.add(sb.toString());
        }
        return groups;
    }
}
