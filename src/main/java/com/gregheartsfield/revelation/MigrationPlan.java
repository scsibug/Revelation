package com.gregheartsfield.revelation;

/**
 * Analyzer for changelogs to determine what should be run to bring a system up-to-date.
 */

public class MigrationPlan {
    ChangeLog migrations = null;
    ChangeLog applied = null;

    ChangeLog plan = null;
    
    // Given migration definitions, and what has already been applied,
    // produce a plan to bring target completely up-to-date.
    public MigrationPlan(ChangeLog migrations, ChangeLog applied) {
        // Find a common starting point
    }

    // Given migration defs, what has been applied, and a desired
    // final changeset, produce a plan to upgrade (or downgrade) the
    // target system.
    public MigrationPlan(ChangeLog migrations, ChangeLog applied, ChangeSet result) {
        
    }    

}