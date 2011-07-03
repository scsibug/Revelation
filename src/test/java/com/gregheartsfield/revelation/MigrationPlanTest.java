package com.gregheartsfield.revelation;

import static org.junit.Assert.*;
import org.junit.*;

public class MigrationPlanTest {

    @Before
    public void setup() {
    }
    @After
    public void tearDown() {
    }
    @Test
    public void nullPlan() {
        // do the right thing with no changelogs
        MigrationPlan mp = new MigrationPlan(new ChangeLog(), new ChangeLog());
        assertNotNull(mp);
    }
}