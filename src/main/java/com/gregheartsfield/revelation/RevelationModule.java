package com.gregheartsfield.revelation;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RevelationModule extends AbstractModule {
    final Logger logger = LoggerFactory.getLogger(RevelationModule.class);

    @Override
    protected void configure() {
        logger.info("Configuring RevelationModule");
        bind(LogManager.class).to(NullLogManager.class);
        bind(MigrationProvider.class).to(NullMigrationProvider.class);
        bind(NullDataStore.class).in(Singleton.class);
        bind(NullStore.class).in(Singleton.class);
    }
}