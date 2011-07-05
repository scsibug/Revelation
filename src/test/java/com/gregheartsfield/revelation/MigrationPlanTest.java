package com.gregheartsfield.revelation;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.List;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Inject;

public class MigrationPlanTest {
    Injector injector;

    ChangeLog defn;
    ChangeLog applied;
    ChangeSet csa, csb, csc;
    @Before
    public void setup() {
        injector = Guice.createInjector(new Env());
        // Sample data
        defn = new ChangeLog();
        applied = new ChangeLog();
        csa = injector.getInstance(NullChangeSet.class);
        csb = injector.getInstance(NullChangeSet.class);
        csc = injector.getInstance(NullChangeSet.class);
        csa.setId("a");
        csb.setId("b");
        csc.setId("c");
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
    }

    @Test
    public void emptyPlanDefects() {
        // do the right thing with no changelogs
        MigrationPlan mp = new MigrationPlan(new ChangeLog(), new ChangeLog());
        List<Defect> defects = mp.getDefects();
        assertNotNull(defects);
        assertEquals(0, defects.size());
        assertNotNull(mp.getPlan());
        assertEquals(0, mp.getPlan().size());
    }

    @Test
    public void perfectPlan() {
        // Add 'a', 'b', 'c' to migration definition.
        defn.addChangeSet(csa);
        defn.addChangeSet(csb);
        defn.addChangeSet(csc);
        // Add only 'a' to applied log
        applied.addChangeSet(csa);
        // create the plan
        MigrationPlan mp = new MigrationPlan(defn, applied);
        // plan should have zero defects, and 2 migrations ('b' and 'c')
        assertEquals("No defects", 0, mp.getDefects().size());
        assertEquals("2 changesets in plan", 2, mp.getPlan().size());
        assertEquals("First migration in plan is B", csb, mp.getPlan().get(0));
        assertEquals("Second migration in plan is C", csc, mp.getPlan().get(1));
    }

    @Test
    public void upToDatePlan() {
        defn.addChangeSet(csa);
        defn.addChangeSet(csb);
        applied.addChangeSet(csa);
        applied.addChangeSet(csb);
        MigrationPlan mp = new MigrationPlan(defn, applied);
        assertEquals("No defects", 0, mp.getDefects().size());
        assertEquals("No work in plan", 0, mp.getPlan().size());
    }

    @Test
    public void outOfOrderPlan() {
        defn.addChangeSet(csb);
        defn.addChangeSet(csa);
        applied.addChangeSet(csa);
        applied.addChangeSet(csb);
        MigrationPlan mp = new MigrationPlan(defn, applied);
        assertEquals("Out of order defect", 2, mp.getDefects().size());
        assertEquals("No changes in plan", 0, mp.getPlan().size());
    }

    @Test
    public void outOfOrderWithWorkPlan() {
        defn.addChangeSet(csb);
        defn.addChangeSet(csa);
        applied.addChangeSet(csa);
        MigrationPlan mp = new MigrationPlan(defn, applied);
        // one defect for each defined migration.  The first is for
        // the already applied migration, and another for the one
        // added to the plan.
        assertEquals("Out of order defect.", 2, mp.getDefects().size());
        assertEquals("One change in plan.", 1, mp.getPlan().size());
        assertEquals("ChangeSet is B.", csb, mp.getPlan().get(0));
    }

    @Test
    public void hashMismatch() {
        defn.addChangeSet(csa);
        // make changeset A & B have the same ID, but different hashes
        csa.setHash("x3");
        csb.setHash("t8");
        csa.setId("a");
        csb.setId("a");
        applied.addChangeSet(csb);
        MigrationPlan mp = new MigrationPlan(defn, applied);
        assertEquals("Hash defect", 1, mp.getDefects().size());
        assertEquals("No changes in plan", 0, mp.getPlan().size());
    }

    @Test
    public void partialPlan() {
        // only apply 2 out of 3 migrations.
        defn.addChangeSet(csa);
        defn.addChangeSet(csb);
        defn.addChangeSet(csc);
        // create the plan
        MigrationPlan mp = new MigrationPlan(defn, applied,csb);
        // plan should have zero defects, and 2 migrations ('a' and 'b')
        assertEquals("No defects", 0, mp.getDefects().size());
        assertEquals("2 changesets in plan", 2, mp.getPlan().size());
        assertEquals("First migration in plan is A", csa, mp.getPlan().get(0));
        assertEquals("Second migration in plan is B", csb, mp.getPlan().get(1));
    }

}