package com.gregheartsfield.revelation;

import com.google.inject.Inject;

/**
 *  Test changeset for making mathematical changes to an int.
 */

public class NullChangeSet extends ChangeSet {
    NullDataStore ds;

    OP op;
    int quantity;

    public enum OP {
        ADD,
        SUBTRACT,
        MULTIPLY
    }

    @Inject
    public NullChangeSet(NullDataStore ds) {
        this.ds = ds;
    }

    public void setOp(OP op) {
        this.op = op;        
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void apply() {
        switch (op) {
        case ADD:
            ds.add(quantity);
            break;
        case SUBTRACT:
            ds.subtract(quantity);
        case MULTIPLY:
            ds.multiply(quantity);
        }
    }

    public boolean canUnapply() {
        // can't unapply multiply by zero!
        if ((op.equals(OP.MULTIPLY)) && quantity == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void unapply() {
        switch (op) {
        case ADD:
            ds.add(-quantity);
            break;
        case SUBTRACT:
            ds.subtract(-quantity);
        case MULTIPLY:
            ds.multiply(1/quantity);
        }
    }

}