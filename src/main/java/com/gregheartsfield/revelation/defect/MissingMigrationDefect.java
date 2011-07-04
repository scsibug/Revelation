package com.gregheartsfield.revelation;

public class MissingMigrationDefect extends Defect {
    // Identifier for this type of defect.
    String getDefectType() {
        return "Missing Migration";
    }
}
