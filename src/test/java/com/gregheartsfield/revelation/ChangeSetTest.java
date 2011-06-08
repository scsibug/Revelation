package com.gregheartsfield.revelation;

import org.junit.*;
import static org.junit.Assert.*;

public class ChangeSetTest {
    ChangeSet cs;

    @Before
    public void setup() {
        cs = new ChangeSet();
    }

    @After
    public void tearDown() {
        cs = null;
    }

    @Test
    public void empty() {
        assertEquals(0, cs.size());
    }

}