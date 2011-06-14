package com.gregheartsfield.revelation;

/**
 * Source of migration definitions.
 */

public class NullMigrationProvider {
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
}
