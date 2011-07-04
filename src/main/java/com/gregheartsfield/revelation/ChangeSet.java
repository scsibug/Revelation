package com.gregheartsfield.revelation;

import java.util.Date;

/**
 *  The definition of a single change at the lowest level that can be applied.
 */

public abstract class ChangeSet {
    String id; // globally unique identifier
    Date creation_date;
    boolean is_baseline = false; // Accounts for all previous changesets

    public ChangeSet() {
    }

    public boolean getIsBaseline() {
        return is_baseline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Date getCreationDate() {
        return creation_date;
    }

    public void setCreationDate(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getHash() {
        return "0";
    }

    abstract public void apply();
    abstract public void unapply();
    
    public String toString() {
        return "ChangeSet "+getId()+", hash="+getHash();
    }
}