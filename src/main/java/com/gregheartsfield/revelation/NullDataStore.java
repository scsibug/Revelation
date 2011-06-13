package com.gregheartsfield.revelation;

import com.google.inject.Inject;

public class NullDataStore implements DataStore {
    int changes_applied = 0;
    int changes_unapplied = 0;
    NullStore ns;
    
    @Inject
    public NullDataStore (NullStore ns) {
        this.ns = ns;
    }

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