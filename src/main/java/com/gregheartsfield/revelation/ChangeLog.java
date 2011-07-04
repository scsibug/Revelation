package com.gregheartsfield.revelation;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Ordered list of changesets
 */

public class ChangeLog extends ArrayList<ChangeSet> {
    final Logger logger = LoggerFactory.getLogger(ChangeLog.class);

    // Add changeset to end of log
    public void addChangeSet(ChangeSet cs) {
        logger.debug("Adding change set: "+cs.getId());
        this.add(cs);
    }

    public ChangeSet getById(String id) {
        for (ChangeSet cs : this) {
            if (cs.getId() == id) {
                return cs;
            }
        }
        return null;
    }

    public ChangeSet latestChangeSet() {
        if (this.isEmpty()) {
            return null;
        }
        int last_mig_index = this.size()-1;
        return this.get(last_mig_index);
    }
}