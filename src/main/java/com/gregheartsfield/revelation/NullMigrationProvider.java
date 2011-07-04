package com.gregheartsfield.revelation;

/**
 * Source of migration definitions.
 */

public class NullMigrationProvider implements MigrationProvider {
    ChangeLog cl;

    public NullMigrationProvider() {
        cl = new ChangeLog();
    }

    public void addChangeSet(NullChangeSet cs) {
        cl.add(cs);
    }

    public ChangeLog getChangeLog() {
        return cl;
    }

    public boolean isInitialized() {
        return true;
    }

    public void initialize() throws MigrationProviderInitException {
    }
}
