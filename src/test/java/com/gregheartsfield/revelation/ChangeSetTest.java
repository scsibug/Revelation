package com.gregheartsfield.revelation;

import static org.junit.Assert.*;
import org.junit.*;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Inject;

public class ChangeSetTest {
    NullChangeSet cs;
    Injector injector;

    @Before
    public void setup() {
        injector = Guice.createInjector(new Env());
        cs = injector.getInstance(NullChangeSet.class);
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

}
