package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.read.customapi.HollowObjectTypeAPI;
import com.netflix.hollow.read.dataaccess.HollowObjectTypeDataAccess;

public class TopNTypeAPI extends HollowObjectTypeAPI {

    private final TopNDelegateLookupImpl delegateLookupImpl;

    TopNTypeAPI(VMSHollowInputAPI api, HollowObjectTypeDataAccess typeDataAccess) {
        super(api, typeDataAccess, new String[] {
            "videoId",
            "attributes"
        });
        this.delegateLookupImpl = new TopNDelegateLookupImpl(this);
    }

    public long getVideoId(int ordinal) {
        if(fieldIndex[0] == -1)
            return missingDataHandler().handleLong("TopN", ordinal, "videoId");
        return getTypeDataAccess().readLong(ordinal, fieldIndex[0]);
    }

    public Long getVideoIdBoxed(int ordinal) {
        long l;
        if(fieldIndex[0] == -1) {
            l = missingDataHandler().handleLong("TopN", ordinal, "videoId");
        } else {
            boxedFieldAccessSampler.recordFieldAccess(fieldIndex[0]);
            l = getTypeDataAccess().readLong(ordinal, fieldIndex[0]);
        }
        if(l == Long.MIN_VALUE)
            return null;
        return Long.valueOf(l);
    }



    public int getAttributesOrdinal(int ordinal) {
        if(fieldIndex[1] == -1)
            return missingDataHandler().handleReferencedOrdinal("TopN", ordinal, "attributes");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[1]);
    }

    public TopNAttributesListTypeAPI getAttributesTypeAPI() {
        return getAPI().getTopNAttributesListTypeAPI();
    }

    public TopNDelegateLookupImpl getDelegateLookupImpl() {
        return delegateLookupImpl;
    }

    @Override
    public VMSHollowInputAPI getAPI() {
        return (VMSHollowInputAPI) api;
    }

}