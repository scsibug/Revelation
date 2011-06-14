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

}