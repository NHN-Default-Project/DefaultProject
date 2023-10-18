package com.nhnacademy.gaeun.exercise1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneDirectoryTest {

    @Test
    @DisplayName("find test")
    void findTest() {
        PhoneDirectory kaeunPhoneDirectory = new PhoneDirectory();
        kaeunPhoneDirectory.putNumber("엄마", "010-4610-0303");
        kaeunPhoneDirectory.putNumber("아빠", "010-2680-8949");

        assertEquals(kaeunPhoneDirectory.find("엄마"), 1);
        assertEquals(kaeunPhoneDirectory.find("동생"), -1);
    }

    @Test
    @DisplayName("getNumber test")
    void getNumberTest() {
        PhoneDirectory kaeunPhoneDirectory = new PhoneDirectory();
        kaeunPhoneDirectory.putNumber("엄마", "010-4610-0303");
        kaeunPhoneDirectory.putNumber("아빠", "010-2680-8949");

        assertEquals(kaeunPhoneDirectory.getNumber("엄마"), "010-4610-0303");
        assertEquals(kaeunPhoneDirectory.getNumber("아빠"), "010-2680-8949");
        assertThrows(IllegalArgumentException.class, () -> kaeunPhoneDirectory.getNumber("개구리"));
    }

    @Test
    @DisplayName("putNumber test")
    void putNumberTest() {
        PhoneDirectory kaeunPhoneDirectory = new PhoneDirectory();
        kaeunPhoneDirectory.putNumber("엄마", "010-4610-0303");
        kaeunPhoneDirectory.putNumber("아빠", "010-2680-8949");

        assertEquals(kaeunPhoneDirectory.getDataCount(), 2);
        assertThrows(IllegalArgumentException.class, () -> kaeunPhoneDirectory.putNumber("", ""));
    }
}