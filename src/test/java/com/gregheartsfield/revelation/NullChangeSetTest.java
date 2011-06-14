package com.gregheartsfield.revelation;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.Date;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Inject;

public class NullChangeSetTest {
    NullChangeSet cs;
    NullDataStore ds;
    Injector injector;

    @Before
    public void setup() {
        injector = Guice.createInjector(new Env());
        cs = injector.getInstance(NullChangeSet.class);
        ds = injector.getInstance(NullDataStore.class);
    }

    @After
    public void tearDown() {
        cs = null;
        injector = null;
    }

    @Test
    public void create() {
        assertNotNull(cs);
        assertNotNull(ds);
    }

    @Test
    public void creationDate() {
        Date now = new Date();
        cs.setCreationDate(now);
        assertEquals(now, cs.getCreationDate());
    }

    @Test
    public void deltaDefault() {
        assertFalse("By default, changesets are deltas, not baselines",
                    cs.getIsBaseline());
    }

    @Test
    public void apply() {
        cs.setOp(NullChangeSet.OP.ADD);
        cs.setQuantity(1);
        cs.apply();
        assertEquals(1, ds.getStoreValue());
    }

    @Test
    public void canUnapplyAdd() {
        cs.setOp(NullChangeSet.OP.ADD);
        cs.setQuantity(1);
        cs.setId("Add 1");
        assertTrue("Can unapply addition", cs.canUnapply());
        assertEquals("No apply occurred", 0, ds.getApplyCount());
        assertEquals("No unapply occurred", 0, ds.getUnapplyCount());
    }

    @Test
    public void cannotUnapplyMultZero() {
        cs.setOp(NullChangeSet.OP.MULTIPLY);
        cs.setQuantity(0);
        cs.setId("Multiply by zero");
        assertFalse("Cannot unapply multiply-by-zero", cs.canUnapply());
    }

    @Test
    public void unapply() {
        int orig = ds.getStoreValue();
        cs.setOp(NullChangeSet.OP.ADD);
        cs.setQuantity(1);
        cs.setId("Add 1");
        cs.apply();
        assertEquals(1, ds.getStoreValue());
        cs.unapply();
        assertEquals(orig, ds.getStoreValue());
    }

    @Test
    public void applyMultiple() {
        // setup changesets
        NullChangeSet cs_add = injector.getInstance(NullChangeSet.class);
        cs_add.setOp(NullChangeSet.OP.ADD);
        cs_add.setQuantity(4);
        cs_add.setId("Add 4");
        NullChangeSet cs_mul = injector.getInstance(NullChangeSet.class);
        cs_mul.setOp(NullChangeSet.OP.MULTIPLY);
        cs_mul.setQuantity(3);
        cs_mul.setId("Mult 3");
        NullChangeSet cs_sub = injector.getInstance(NullChangeSet.class);
        cs_sub.setOp(NullChangeSet.OP.SUBTRACT);
        cs_sub.setQuantity(1);
        cs_sub.setId("Sub 1");
        // apply
        assertEquals(0, ds.getStoreValue());
        cs_add.apply();
        assertEquals(4, ds.getStoreValue());
        cs_sub.apply();
        assertEquals(3, ds.getStoreValue());
        cs_mul.apply();
        assertEquals(9, ds.getStoreValue());
        cs_mul.unapply();
        assertEquals(3, ds.getStoreValue());
        cs_sub.unapply();
        assertEquals(4, ds.getStoreValue());
        cs_add.unapply();
        assertEquals(0, ds.getStoreValue());
    }

}
