package com.gregheartsfield.revelation;

/**
 * Source of migration definitions.
 */

public interface MigrationProvider {
    public ChangeLog getChangeLog();
    public boolean isInitialized();
    public void initialize() throws MigrationProviderInitException;
}