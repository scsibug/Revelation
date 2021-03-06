package com.gregheartsfield.revelation;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class Env extends AbstractModule{
    protected void configure() {
        bind(LogManager.class).to(NullLogManager.class);
        bind(NullDataStore.class).in(Singleton.class);
        bind(NullStore.class).in(Singleton.class);
        bind(NullChangeSet.class);
    }
}
