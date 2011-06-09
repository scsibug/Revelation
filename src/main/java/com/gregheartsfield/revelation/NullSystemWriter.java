package com.gregheartsfield.revelation;

public class NullSystemWriter implements TargetSystemWriter {
    int changes_applied = 0;
    int changes_unapplied = 0;

    public void apply(ChangeSet cs) {
        changes_applied++;
    }

    public void unapply(ChangeSet cs) {
        changes_unapplied++;
    }

    public int getApplyCount() {
        return changes_applied;
    }

    public int getUnapplyCount() {
        return changes_unapplied;
    }

}