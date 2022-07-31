package org.geepawhill.starter;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class StarterTest {

    @Test
    public void nothingInParticular() {
        assertEquals(1,1);
    }

    @Test
    public void assertJStyle() {
        assertThat(1).isEqualTo(1);
    }
}
