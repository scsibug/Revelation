package com.gregheartsfield.revelation;

import java.util.Date;
import com.google.inject.Inject;

/**
 *  The definition of a single change at the lowest level that can be applied.
 */

public class ChangeSet {
    String id; // globally unique identifier
    Date creation_date;
    TargetSystemWriter writer = null; // where we can apply/unapply changes

    @Inject
    public ChangeSet(TargetSystemWriter writer) {
        this.writer = writer;
    }
}