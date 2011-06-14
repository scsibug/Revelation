package com.gregheartsfield.revelation;

import static org.junit.Assert.*;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Inject;

import org.junit.*;

public class ChangeLogTest {
    ChangeLog cl;
    Injector injector;

    @Before
    public void setup() {
        injector = Guice.createInjector(new Env());
        cl = injector.getInstance(ChangeLog.class);
    }

    @After
    public void tearDown() {
        cl = null;
        injector = null;
    }

    @Test
    public void changeLogNotNull() throws Exception {
        assertNotNull(cl);
    }

    @Test
    public void newChangeSet() {
        ChangeSet cs = injector.getInstance(ChangeSet.class);
        assertNotNull(cs);
        cl.addChangeSet(cs);
        assertEquals(1, cl.size());
    }

    @Test
    public void changeSetOrder() {
        ChangeSet first = injector.getInstance(ChangeSet.class);
        ChangeSet second = injector.getInstance(ChangeSet.class);
        cl.addChangeSet(first);
        assertEquals(1, cl.size());
        cl.addChangeSet(second);
        assertEquals(2, cl.size());
        assertEquals(first, cl.get(0));
        assertEquals(second, cl.get(1));
    }

}
