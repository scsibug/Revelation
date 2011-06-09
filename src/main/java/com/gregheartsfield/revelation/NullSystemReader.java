package com.gregheartsfield.revelation;

import com.google.inject.Inject;

public class NullSystemReader implements TargetSystemReader {
    NullStore ns;

    @Inject
    public NullSystemReader(NullStore ns) {
        this.ns = ns;
    }

    public ChangeLog getChangeLog() {
        ChangeLog cl = new ChangeLog();
        for (ChangeSet cs : ns) {
            cl.addChangeSet(cs);
        }
        return cl;
    }

}