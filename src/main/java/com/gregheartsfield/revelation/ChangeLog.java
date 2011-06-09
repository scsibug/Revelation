package com.gregheartsfield.revelation;

import java.util.Vector;

/**
 *  Ordered list of changesets
 */

public class ChangeLog {
    Vector<ChangeSet> log = new Vector<ChangeSet>();
    
    public void addChangeSet(ChangeSet cs) {
        log.add(cs);
    }

    public int size() {
        return log.size();
    }

    public ChangeSet elementAt(int i) {
        return log.elementAt(i);
    }
}