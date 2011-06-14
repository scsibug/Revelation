package com.gregheartsfield.revelation;

import com.google.inject.Inject;

public class NullLogManager implements LogManager {
    NullStore ns;

    @Inject
    public NullLogManager(NullStore ns) {
        this.ns = ns;
    }

    public boolean isInitialized() {
        return true;
    }

    public void initialize() {
    }

    public ChangeLog getChangeLog() {
        ChangeLog cl = new ChangeLog();
        for (ChangeSet cs : ns) {
            cl.addChangeSet(cs);
        }
        return cl;
    }

}