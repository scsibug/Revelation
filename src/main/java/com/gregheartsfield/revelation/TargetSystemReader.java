package com.gregheartsfield.revelation;

/**
 *  Controller for inspecting already-applied changes to a target system
 */

public interface TargetSystemReader {
    public ChangeLog getChangeLog();
}