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
        //ChangeSet first = injector.getInstance(ChangeSet.class);
    }

    @After
    public void tearDown() {
        mp = null;
        injector = null;
    }

    @Test
    public void changeLogNotNull() throws Exception {
        assertNotNull(mp);
    }

}
