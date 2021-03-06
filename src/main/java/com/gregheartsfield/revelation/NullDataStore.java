package com.gregheartsfield.revelation;

// Dummy data store that keeps track of a single integer.

public class NullDataStore {
    int changes_applied;
    int changes_unapplied;
    int store;
    
    public NullDataStore () {
        store = 0;
        changes_applied = 0;
        changes_unapplied = 0;
    }

    public void add(int x) {
        store += x;
    }

    public void multiply(int x) {
        store *= x;
    }

    // Handles multiply unapply
    public void multiply(double x) {
        store = (int) (store * x);
    }

    public void subtract(int x) {
        store -= x;
    }

    public int getStoreValue() {
        return store;
    }

    public void incApply() {
        changes_applied++;
    }

    public void incUnapply() {
        changes_unapplied++;
    }

    public int getApplyCount() {
        return changes_applied;
    }

    public int getUnapplyCount() {
        return changes_unapplied;
    }

}