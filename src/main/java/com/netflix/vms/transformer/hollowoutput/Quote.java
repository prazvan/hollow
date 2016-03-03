package com.netflix.vms.transformer.hollowoutput;

import java.util.Arrays;

public class Quote implements Cloneable {

    public int characterId = java.lang.Integer.MIN_VALUE;
    public char[] rawL10nLabel = null;
    public int sequenceNumber = java.lang.Integer.MIN_VALUE;

    public boolean equals(Object other) {
        if(other == this)  return true;
        if(!(other instanceof Quote))
            return false;

        Quote o = (Quote) other;
        if(o.characterId != characterId) return false;
        if(!Arrays.equals(o.rawL10nLabel, rawL10nLabel)) return false;
        if(o.sequenceNumber != sequenceNumber) return false;
        return true;
    }

    public int hashCode() {
        int hashCode = 1;
        hashCode = hashCode * 31 + characterId;
        hashCode = hashCode * 31 + Arrays.hashCode(rawL10nLabel);
        hashCode = hashCode * 31 + sequenceNumber;
        return hashCode;
    }

    public Quote clone() {
        try {
            Quote clone = (Quote)super.clone();
            clone.__assigned_ordinal = -1;
            return clone;
        } catch (CloneNotSupportedException cnse) { throw new RuntimeException(cnse); }
    }

    @SuppressWarnings("unused")
    private int __assigned_ordinal = -1;
}