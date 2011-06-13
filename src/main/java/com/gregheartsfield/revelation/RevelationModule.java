package com.gregheartsfield.revelation;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Singleton;

public class RevelationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(LogManager.class).to(NullLogManager.class);
        bind(DataStore.class).to(NullDataStore.class);
        bind(NullStore.class).to(NullStore.class).in(Singleton.class);
        System.out.println("Configuring RevelationModule");
    }
}