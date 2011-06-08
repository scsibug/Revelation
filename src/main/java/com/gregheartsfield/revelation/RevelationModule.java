package com.gregheartsfield.revelation;

import com.google.inject.Guice;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;

public class RevelationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TargetSystemWriter.class).to(NullSystemWriter.class);
        System.out.println("Configuring RevelationModule");
    }
}