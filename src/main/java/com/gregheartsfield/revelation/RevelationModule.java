package com.gregheartsfield.revelation;

import com.google.inject.AbstractModule;

public class RevelationModule extends AbstractModule {
    protected void configure() {
        System.out.println("Configuring RevelationModule");
    }
}