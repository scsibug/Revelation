package com.gregheartsfield.revelation;

import static org.junit.Assert.*;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Inject;

import org.junit.*;

public class ChangeSetTest {
    ChangeSet cs;
    Injector injector;

    @Before
    public void setup() {
        injector = Guice.createInjector(new Env());
        cs = injector.getInstance(ChangeSet.class);
    }

    @After
    public void tearDown() {
        cs = null;
        injector = null;
    }

    @Test
    public void deltaDefault() {
        assertFalse("By default, changesets are deltas, not baselines",
                    cs.getIsBaseline());
    }

    @Test
    public void apply() {
        NullSystemWriter sysWriter = (NullSystemWriter) injector.getInstance(TargetSystemWriter.class);
        int prevApplyCount = sysWriter.getApplyCount();
        cs.apply();
        assertEquals("ChangeSet application registers with SystemWriter",
                     prevApplyCount+1, sysWriter.getApplyCount());
    }

}
