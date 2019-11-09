package com.okattis;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

class DRMDecryptorTest {

    @Test
    void decrypt() {
        String result = DRMDecryptor.decrypt("EWPGAJRB");
        assertThat(result, is("ABCD"));
    }
}
