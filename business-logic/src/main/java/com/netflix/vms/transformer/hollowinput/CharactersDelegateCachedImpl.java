package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.api.objects.delegate.HollowObjectAbstractDelegate;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;
import com.netflix.hollow.core.schema.HollowObjectSchema;
import com.netflix.hollow.api.custom.HollowTypeAPI;
import com.netflix.hollow.api.objects.delegate.HollowCachedDelegate;

@SuppressWarnings("all")
public class CharactersDelegateCachedImpl extends HollowObjectAbstractDelegate implements HollowCachedDelegate, CharactersDelegate {

    private final Long id;
    private final int prefixOrdinal;
    private final int bOrdinal;
    private final int cnOrdinal;
    private CharactersTypeAPI typeAPI;

    public CharactersDelegateCachedImpl(CharactersTypeAPI typeAPI, int ordinal) {
        this.id = typeAPI.getIdBoxed(ordinal);
        this.prefixOrdinal = typeAPI.getPrefixOrdinal(ordinal);
        this.bOrdinal = typeAPI.getBOrdinal(ordinal);
        this.cnOrdinal = typeAPI.getCnOrdinal(ordinal);
        this.typeAPI = typeAPI;
    }

    public long getId(int ordinal) {
        if(id == null)
            return Long.MIN_VALUE;
        return id.longValue();
    }

    public Long getIdBoxed(int ordinal) {
        return id;
    }

    public int getPrefixOrdinal(int ordinal) {
        return prefixOrdinal;
    }

    public int getBOrdinal(int ordinal) {
        return bOrdinal;
    }

    public int getCnOrdinal(int ordinal) {
        return cnOrdinal;
    }

    @Override
    public HollowObjectSchema getSchema() {
        return typeAPI.getTypeDataAccess().getSchema();
    }

    @Override
    public HollowObjectTypeDataAccess getTypeDataAccess() {
        return typeAPI.getTypeDataAccess();
    }

    public CharactersTypeAPI getTypeAPI() {
        return typeAPI;
    }

    public void updateTypeAPI(HollowTypeAPI typeAPI) {
        this.typeAPI = (CharactersTypeAPI) typeAPI;
    }

}