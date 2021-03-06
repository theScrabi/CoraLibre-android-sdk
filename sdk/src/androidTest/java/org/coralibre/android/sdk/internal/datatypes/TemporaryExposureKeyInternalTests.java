package org.coralibre.android.sdk.internal.datatypes;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class TemporaryExposureKeyInternalTests {
    private static final byte[] TEK_VAL1 = new byte[] {
            (byte) 0x12,
            (byte) 0x34,
            (byte) 0x56,
            (byte) 0x67,
            (byte) 0x78,
            (byte) 0x9A,
            (byte) 0xBC,
            (byte) 0xDE,
            (byte) 0xF1,
            (byte) 0x23,
            (byte) 0x45,
            (byte) 0x67,
            (byte) 0x89,
            (byte) 0xAB,
            (byte) 0xCD,
            (byte) 0xEF
    };
    public static final long RAW_INPUT_ENNUMBER_VAL1 = 0x12345678L;
    public static final long RAW_OUTPUT_ENNUMBER_VAL1 = 305419824;

    @Test
    public void testSetTEKWithENNumberInterval() {
        ENInterval i = new ENInterval(RAW_INPUT_ENNUMBER_VAL1);
        InternalTemporaryExposureKey tek = new InternalTemporaryExposureKey(i, TEK_VAL1);
        assertArrayEquals(TEK_VAL1, tek.getKey());
        assertEquals(RAW_OUTPUT_ENNUMBER_VAL1, tek.getInterval().get());
    }

    @Test
    public void testSetTEKFromRawData() {
        InternalTemporaryExposureKey tek = new InternalTemporaryExposureKey(RAW_INPUT_ENNUMBER_VAL1, TEK_VAL1);
        assertArrayEquals(TEK_VAL1, tek.getKey());
        assertEquals(RAW_OUTPUT_ENNUMBER_VAL1, tek.getInterval().get());
    }

    @Test
    public void testSetExactInterval() {
        InternalTemporaryExposureKey tek = new InternalTemporaryExposureKey(RAW_OUTPUT_ENNUMBER_VAL1, TEK_VAL1);

        assertArrayEquals(TEK_VAL1, tek.getKey());
        assertEquals(RAW_OUTPUT_ENNUMBER_VAL1, tek.getInterval().get());
    }



}
