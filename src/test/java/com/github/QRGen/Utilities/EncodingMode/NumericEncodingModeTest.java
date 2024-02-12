package com.github.QRGen.Utilities.EncodingMode;

import com.github.QRGen.Utilities.EncodingMode.Interfaces.EncodingMode;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumericEncodingModeTest {

  @Test
  public void testGetMode_NumericData() {
    EncodingMode numericMode = new NumericEncodingMode("0001");
    try {
      String result = numericMode.getMode("12345");
      assertEquals("0001", result);
      result = numericMode.getMode("0");
      assertEquals("0001", result);
      result = numericMode.getMode("1234567890");
      assertEquals("0001", result);
    } catch (Exception e) {
      fail("Unexpected EncodingDeterminationException");
    }
  }

  @Test(expected = EncodingDeterminationException.class)
  public void testGetMode_NonNumericData1() throws EncodingDeterminationException {
    EncodingMode numericMode = new NumericEncodingMode("0001");
    numericMode.getMode("abc123");
  }

  @Test(expected = EncodingDeterminationException.class)
  public void testGetMode_NonNumericData2() throws EncodingDeterminationException {
    EncodingMode numericMode = new NumericEncodingMode("0001");
    numericMode.getMode("123ABC");
  }

  @Test(expected = EncodingDeterminationException.class)
  public void testGetMode_NonNumericData3() throws EncodingDeterminationException {
    EncodingMode numericMode = new NumericEncodingMode("0001");
    numericMode.getMode("");
  }

  @Test(expected = EncodingDeterminationException.class)
  public void testGetMode_NonNumericData4() throws EncodingDeterminationException {
    EncodingMode numericMode = new NumericEncodingMode("0001");
    numericMode.getMode("abc");
  }

  @Test(expected = EncodingDeterminationException.class)
  public void testGetMode_NonNumericData5() throws EncodingDeterminationException {
    EncodingMode numericMode = new NumericEncodingMode("0001");
    numericMode.getMode("ABC");
  }

  @Test(expected = EncodingDeterminationException.class)
  public void testGetMode_NonNumericData6() throws EncodingDeterminationException {
    EncodingMode numericMode = new NumericEncodingMode("0001");
    numericMode.getMode("123(.)(.)");
  }

  @Test(expected = EncodingDeterminationException.class)
  public void testGetMode_NonNumericData7() throws EncodingDeterminationException {
    EncodingMode numericMode = new NumericEncodingMode("0001");
    numericMode.getMode(" ");
  }

  @Test(expected = EncodingDeterminationException.class)
  public void testGetMode_NonNumericData8() throws EncodingDeterminationException {
    EncodingMode numericMode = new NumericEncodingMode("0001");
    numericMode.getMode("-10");
  }
}
