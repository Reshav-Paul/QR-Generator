package com.github.QRGen.Utilities.EncodingMode;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlphanumericEncodingModeTest {

  @Test
  public void testGetMode_AlphanumericData_ReturnsModeValue() {
    String modeValue = "0001";
    String alphanumericData = "HELLO123";
    AlphanumericEncodingMode encodingMode = new AlphanumericEncodingMode(modeValue);

    try {
      String resultMode = encodingMode.getMode(alphanumericData);
      assertEquals(modeValue, resultMode);
    } catch (EncodingDeterminationException e) {
      fail("Unexpected EncodingDeterminationException");
    }
  }

  @Test(expected = EncodingDeterminationException.class)
  public void testGetMode_NonAlphanumericData_ThrowsException() throws EncodingDeterminationException {
    String modeValue = "0001";
    String nonAlphanumericData = "Hello, World!";
    AlphanumericEncodingMode encodingMode = new AlphanumericEncodingMode(modeValue);
    encodingMode.getMode(nonAlphanumericData);
  }

  @Test
  public void testGetMode_EmptyData_ReturnsModeValue() throws EncodingDeterminationException {
    String modeValue = "0001";
    String emptyData = "";
    AlphanumericEncodingMode encodingMode = new AlphanumericEncodingMode(modeValue);

    try {
      String resultMode = encodingMode.getMode(emptyData);
      assertEquals(modeValue, resultMode);
    } catch (EncodingDeterminationException e) {
      fail("Unexpected EncodingDeterminationException");
    }
  }
}
