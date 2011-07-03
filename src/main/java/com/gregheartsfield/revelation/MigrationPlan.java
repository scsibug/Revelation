package com.gregheartsfield.revelation;

import java.util.List;
import java.util.ArrayList;
import com.gregheartsfield.revelation.defect.*;

/**
 * Analyzer for changelogs to determine what should be run to bring a system up-to-date.
 * Plans are a list of proposed changes (the plan), with associated defects which inform the user
 * about whether they should execute the plan.  For example, we detect whether migration hashes
 * have changed since they were run, and if back-dated migrations have been introduced.
 *
 */

public class MigrationPlan {
    ChangeLog migrations = null;
    ChangeLog applied = null;

    ChangeLog plan = new ChangeLog();

    List<Defect> defects = new ArrayList<Defect>();

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
    
    public ChangeLog getPlan() {
        return plan;
    }

    public List<Defect> getDefects() {
        return defects;
    }

}