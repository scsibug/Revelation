package com.gregheartsfield.revelation;

import static org.junit.Assert.*;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Inject;

import org.junit.*;

public class NullMigrationProviderTest {
    NullMigrationProvider mp;
    Injector injector;

    @Before
    public void setup() {
        mp = new NullMigrationProvider();
        injector = Guice.createInjector(new Env());
    }

    @After
    public void tearDown() {
        mp = null;
        injector = null;
    }

    @Test
    public void changeLogNotNull() {
        assertNotNull(mp);
        assertEquals(0, mp.getChangeLog().size());
    }

    @Test
    public void getChangeLog() {
        NullChangeSet first = injector.getInstance(NullChangeSet.class);
        NullChangeSet second = injector.getInstance(NullChangeSet.class);
        mp.addChangeSet(first);
        assertEquals("ChangeLog size with 1 ChangeSet", 1, mp.getChangeLog().size());
        mp.addChangeSet(second);
        assertEquals("ChangeLog size with 2 ChangeSets", 2, mp.getChangeLog().size());
        assertEquals("First ChangeSet is at position zero", first, mp.getChangeLog().get(0));
        assertEquals("Second ChangeSet is at position one", second, mp.getChangeLog().get(1));
    }

}
