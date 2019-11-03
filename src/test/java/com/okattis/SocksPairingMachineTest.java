package com.okattis;

import static com.okattis.SocksPairingMachine.getMovesToPairSocks2;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class SocksPairingMachineTest {

    @Test
    void pairSocks() {
        assertThat(getMovesToPairSocks2(new int[]{1, 1}, 1), is(2));
    }

    @Test
    void pairSocks1() {
        assertThat(getMovesToPairSocks2(new int[]{1, 2, 2, 1}, 2), is(4));
    }

    @Test
    void pairSocks2() {
        try {
            getMovesToPairSocks2(new int[]{3, 7}, 1);
            fail();
        } catch (RuntimeException e) {

        }
    }

    @Test
    void pairSocks3() {
        assertThat(getMovesToPairSocks2(new int[]{5, 5, 5, 5, 5, 5}, 3), is(6));
    }

    @Test
    void pairSocks_ComplexCombo_Test() {
        assertThat(getMovesToPairSocks2(new int[]{3, 9 ,5, 2, 1, 5, 1, 2, 3, 9}, 5), is(10));
    }

}