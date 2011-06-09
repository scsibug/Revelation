package com.gregheartsfield.revelation;

import static org.junit.Assert.*;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;

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

    public class Env extends AbstractModule{
        protected void configure() {
        }
    }
}
