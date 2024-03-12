package com.github.QRGen.Encoder;

import java.util.HashMap;
import java.util.List;

import com.github.QRGen.Encoder.Interfaces.Encoder;

public class AlphanumericDataBitEncoder implements Encoder {
  private final HashMap<Character, Integer> encodingDecodingTable = new HashMap<>() {
    {
      put('0', 0);
      put('1', 1);
      put('2', 2);
      put('3', 3);
      put('4', 4);
      put('5', 5);
      put('6', 6);
      put('7', 7);
      put('8', 8);
      put('9', 9);
      put('A', 10);
      put('B', 11);
      put('C', 12);
      put('D', 13);
      put('E', 14);
      put('F', 15);
      put('G', 16);
      put('H', 17);
      put('I', 18);
      put('J', 19);
      put('K', 20);
      put('L', 21);
      put('M', 22);
      put('N', 23);
      put('O', 24);
      put('P', 25);
      put('Q', 26);
      put('R', 27);
      put('S', 28);
      put('T', 29);
      put('U', 30);
      put('V', 31);
      put('W', 32);
      put('X', 33);
      put('Y', 34);
      put('Z', 35);
      put(' ', 36);
      put('.', 42);
      put('$', 37);
      put('/', 43);
      put('%', 38);
      put(':', 44);
      put('*', 39);
      put('+', 40);
      put('-', 41);
      put('.', 42);
      put('/', 43);
      put(':', 44);

    }
  };
  private final int groupSize = 2;
  private final int[] desiredLengths = new int[] { 6, 11 };
  private final int multiplier = 45;

  @Override
  public String encode(String data) throws EncoderException {
    if (data == null || data.isEmpty()) {
      throw new EncoderException("Non null data expected");
    }
    StringBuilder binaryDataBuilder = new StringBuilder();
    List<String> groups = EncoderUtility.getGroups(data, groupSize);
    for (String group : groups) {
      Character firstLiteral = group.charAt(0);
      Character secondLiteral = group.length() > 1 ? group.charAt(1) : null;
      int groupDataDecimal = secondLiteral == null ? encodingDecodingTable.get(firstLiteral)
          : encodingDecodingTable.get(firstLiteral) * multiplier + encodingDecodingTable.get(secondLiteral);
      String binaryData = Integer.toBinaryString(groupDataDecimal);
      String paddedData = "0".repeat(desiredLengths[group.length() - 1] - binaryData.length());
      binaryDataBuilder.append(paddedData);
      binaryDataBuilder.append(binaryData);
    }
    return binaryDataBuilder.toString();
  }
}
