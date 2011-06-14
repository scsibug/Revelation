package com.gregheartsfield.revelation;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Singleton;

public class RevelationModule extends AbstractModule {
    @Override
    protected void configure() {
        System.out.println("Configuring RevelationModule");
        bind(LogManager.class).to(NullLogManager.class);
        bind(NullDataStore.class).in(Singleton.class);
        bind(NullStore.class).in(Singleton.class);
    }
}