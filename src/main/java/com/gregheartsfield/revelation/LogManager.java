package com.gregheartsfield.revelation;

public interface LogManager {
    public boolean isInitialized();
    public void initialize();
    public ChangeLog getChangeLog();
}