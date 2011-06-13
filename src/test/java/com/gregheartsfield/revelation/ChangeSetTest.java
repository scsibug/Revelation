package com.gregheartsfield.revelation;

import static org.junit.Assert.*;
import org.junit.*;

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
    public void deltaDefault() {
        assertFalse("By default, changesets are deltas, not baselines",
                    cs.getIsBaseline());
    }

}
