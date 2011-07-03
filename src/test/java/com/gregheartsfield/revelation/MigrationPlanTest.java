package com.gregheartsfield.revelation;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.List;

public class MigrationPlanTest {

    @Before
    public void setup() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void emptyPlan() {
        // do the right thing with no changelogs
        MigrationPlan mp = new MigrationPlan(new ChangeLog(), new ChangeLog());
        assertNotNull(mp);
        ChangeLog plan = mp.getPlan();
        assertNotNull(plan);
        assertEquals(0, plan.size());
        List<Defect> defects = mp.getDefects();
        assertNotNull(defects);
        assertEquals(0, defects.size());
    }

}