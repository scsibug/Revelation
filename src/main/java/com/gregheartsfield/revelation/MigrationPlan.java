package com.gregheartsfield.revelation;

import java.util.List;
import java.util.ArrayList;
import com.gregheartsfield.revelation.defect.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Analyzer for changelogs to determine what should be run to bring a system up-to-date.
 * Plans are a list of proposed changes (the plan), with associated defects which inform the user
 * about whether they should execute the plan.  For example, we detect whether migration hashes
 * have changed since they were run, and if back-dated migrations have been introduced.
 *
 */

public class MigrationPlan {
    final Logger logger = LoggerFactory.getLogger(MigrationPlan.class);
    ChangeLog migrations = null;
    ChangeLog applied = null;
    ChangeSet target = null;

    ChangeLog plan = new ChangeLog();

    List<Defect> defects = new ArrayList<Defect>();

    // Given migration definitions, and what has already been applied,
    // produce a plan to bring target completely up-to-date.
    public MigrationPlan(ChangeLog migrations, ChangeLog applied) {
        // Call other constructor, with the latest changeset from the
        // list of migrations.
        this(migrations, applied, migrations.latestChangeSet());
    }

    // Given migration defs, what has been applied, and a desired
    // final changeset, produce a plan to upgrade (or downgrade) the
    // target system.
    public MigrationPlan(ChangeLog migrations, ChangeLog applied, ChangeSet result) {
        this.migrations = migrations;
        this.applied = applied;
        this.target = target;
        // Find a common starting point (last change applied)
        // Verify order of already-applied changes
        //   Verify hashes match
    }    

    // Verify all applied changes exist in migration definition
    public void verifyAppliedChanges() {
    }

    public ChangeLog getPlan() {
        return plan;
    }

    public List<Defect> getDefects() {
        return defects;
    }

}