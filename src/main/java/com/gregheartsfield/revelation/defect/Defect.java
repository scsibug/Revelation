package com.gregheartsfield.revelation;

import java.util.ArrayList;
import java.util.List;

public class Defect {
    ArrayList<ChangeSet> defects = new ArrayList<ChangeSet>();
    // Identifier for this type of defect.
    String getDefectType() {
        return "Generic Defect";
    }

    // Which changesets are implicated as being defective?
    List<ChangeSet> getChangeSets() {
        return defects;
    }

    // Add known defective changeset
    void addDefectiveChangeSet(ChangeSet cs) {
        defects.add(cs);
    }

    int getDefectCount() {
        return defects.size();
    }

    // Return human-readable description of the defect (multi-line)
    String describe() {
        StringBuffer d = new StringBuffer(this.describeShort());
        d.append("\n");
        for (ChangeSet cs : defects) {
            d.append("\tCS: "+cs.getId()+"\n");
        }
        return d.toString();
    }

    // Return human-readable description of the defect (single-line)
    String describeShort() {
        return this.getDefectType() + ": " + this.getDefectCount() + " defects found.";
    }
}
