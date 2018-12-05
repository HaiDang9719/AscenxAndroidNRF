package no.nordicsemi.android.meshprovisioner.database;

public class networkInfomation {
    int flags;
    int globalTtl;
    int ivIndex;
    int keyIndex;
    String networkKey;
    int unicastAddress;

    public networkInfomation(int flags, int globalTtl, int ivIndex, int keyIndex, String networkKey, int unicastAddress) {
        this.flags = flags;
        this.globalTtl = globalTtl;
        this.ivIndex = ivIndex;
        this.keyIndex = keyIndex;
        this.networkKey = networkKey;
        this.unicastAddress = unicastAddress;
    }

    public networkInfomation() {
    }


    public int getGlobalTtl() {
        return globalTtl;
    }

    public void setGlobalTtl(int globalTtl) {
        this.globalTtl = globalTtl;
    }

    public int getIvIndex() {
        return ivIndex;
    }

    public void setIvIndex(int ivIndex) {
        this.ivIndex = ivIndex;
    }

    public int getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(int keyIndex) {
        this.keyIndex = keyIndex;
    }

    public String getNetworkKey() {
        return networkKey;
    }

    public void setNetworkKey(String networkKey) {
        this.networkKey = networkKey;
    }

    public int getUnicastAddress() {
        return unicastAddress;
    }

    public void setUnicastAddress(int unicastAddress) {
        this.unicastAddress = unicastAddress;
    }


    public int getFlags() {

        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }
}
