package com.example.odc.ascenxnrf.database;

public class networkInfomation {
    String flags;
    String globalTtl;
    String ivIndex;
    String keyIndex;
    String networkKey;
    String unicastAddress;

    public String getGlobalTtl() {
        return globalTtl;
    }

    public void setGlobalTtl(String globalTtl) {
        this.globalTtl = globalTtl;
    }

    public String getIvIndex() {
        return ivIndex;
    }

    public void setIvIndex(String ivIndex) {
        this.ivIndex = ivIndex;
    }

    public String getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(String keyIndex) {
        this.keyIndex = keyIndex;
    }

    public String getNetworkKey() {
        return networkKey;
    }

    public void setNetworkKey(String networkKey) {
        this.networkKey = networkKey;
    }

    public String getUnicastAddress() {
        return unicastAddress;
    }

    public void setUnicastAddress(String unicastAddress) {
        this.unicastAddress = unicastAddress;
    }


    public String getFlags() {

        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }
}
