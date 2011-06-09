package com.gregheartsfield.revelation;

import java.util.Vector;
import com.google.inject.Inject;

/**
 *  Ordered list of changesets
 */

public class ChangeLog {
    Vector<ChangeSet> log = new Vector<ChangeSet>();
    
    /*
    @Inject
    public ChangeSet newChangeSet(ChangeSet cs) {
        log.add(cs);
        return cs;
    }
    */

    public int size() {
        return log.size();
    }

    public ChangeSet elementAt(int i) {
        return log.elementAt(i);
    }
}