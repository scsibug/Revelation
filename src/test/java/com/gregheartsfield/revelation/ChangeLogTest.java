package com.gregheartsfield.revelation;

import org.junit.*;
import static org.junit.Assert.*;

public class ChangeLogTest {
    ChangeLog cl;

    @Before
    public void setup() {
        cl = new ChangeLog();
    }

    @After
    public void tearDown() {
        cl = null;
    }

    @Test
    public void empty() {
        assertEquals("ChangeLog starts empty", 0, cl.size());
    }

}