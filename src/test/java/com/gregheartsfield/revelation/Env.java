package com.gregheartsfield.revelation;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class Env extends AbstractModule{
    protected void configure() {
        bind(TargetSystemWriter.class).to(NullSystemWriter.class).in(Singleton.class);
    }
}
