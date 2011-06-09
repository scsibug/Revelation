package com.gregheartsfield.revelation;

/**
 *  Controller for applying changes to a target system
 */

public interface TargetSystemWriter {
    public void apply(ChangeSet cs);
    public void unapply(ChangeSet cs);
}