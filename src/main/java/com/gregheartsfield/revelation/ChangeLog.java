package com.gregheartsfield.revelation;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Ordered list of changesets
 */

public class ChangeLog {
    final Logger logger = LoggerFactory.getLogger(ChangeLog.class);

    Vector<ChangeSet> log = new Vector<ChangeSet>();
    
    public void addChangeSet(ChangeSet cs) {
        logger.debug("Adding change set: "+cs.getId());
        log.add(cs);
    }

    public int size() {
        return log.size();
    }

    public ChangeSet elementAt(int i) {
        return log.elementAt(i);
    }
}