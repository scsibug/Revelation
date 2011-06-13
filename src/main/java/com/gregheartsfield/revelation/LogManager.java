package com.gregheartsfield.revelation;

public interface LogManager {
    public boolean isInitialized();
    public void initialize() throws TargetInitializationException;
    public ChangeLog getChangeLog();
}