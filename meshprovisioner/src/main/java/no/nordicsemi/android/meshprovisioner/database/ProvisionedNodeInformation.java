package no.nordicsemi.android.meshprovisioner.database;

import android.util.Log;

import com.google.android.gms.common.util.Hex;
import com.google.firebase.database.DataSnapshot;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import no.nordicsemi.android.meshprovisioner.configuration.MeshModel;
import no.nordicsemi.android.meshprovisioner.configuration.ProvisionedMeshNode;
import no.nordicsemi.android.meshprovisioner.models.SigModel;
import no.nordicsemi.android.meshprovisioner.models.SigModelParser;
import no.nordicsemi.android.meshprovisioner.states.UnprovisionedMeshNode;
import no.nordicsemi.android.meshprovisioner.utils.Element;
import no.nordicsemi.android.meshprovisioner.utils.MeshParserUtils;
import no.nordicsemi.android.meshprovisioner.utils.SecureUtils;

public class ProvisionedNodeInformation {
    Boolean isConfigured;
    String nodeName;
    byte[] identityKey;
    byte[] deviceKey;
    long timeStampInMillis;
    int numberOfElements;
    Map<Integer, Element> element;
    int productID;
    int companyID;
    int versonID;
    Boolean isRelayFeatureSupported;
    Boolean isProxyFeatureSupported;
    Boolean isFriendFeatureSupported;
    Boolean isLowPowerFeatureSupported;
    String NodeIdentifier;
    Boolean isProvisioned;
    int sequenceNumber;
    int netSequenceNumber;
    String bluetoothAddress;

    public String getBluetoothAddress() {
        return bluetoothAddress;
    }

    public void setBluetoothAddress(String bluetoothAddress) {
        this.bluetoothAddress = bluetoothAddress;
    }

    public int getNetSequeceNumber() {
        return netSequenceNumber;
    }

    public void setNetSequeceNumber(int netSequenceNumber) {
        this.netSequenceNumber = netSequenceNumber;
    }

    public byte[] getUnicastAddress() {

        return unicastAddress;
    }

    public void setUnicastAddress(byte[] unicastAddress) {
        this.unicastAddress = unicastAddress;
    }

    byte[] unicastAddress;

    public ProvisionedNodeInformation(Boolean isConfigured, String nodeName, byte[] identityKey, byte[] deviceKey, long timeStampInMillis, int numberOfElements, Map<Integer, Element> element, int productID, int companyID, int versonID, Boolean isRelayFeatureSupported, Boolean isProxyFeatureSupported, Boolean isFriendFeatureSupported, Boolean isLowPowerFeatureSupported, String nodeIdentifier, Boolean isProvisioned,
                                      int sequenceNumber, byte[] unicastAddress, int netSequenceNumber) {
        this.isConfigured = isConfigured;
        this.nodeName = nodeName;
        this.identityKey = identityKey;
        this.deviceKey = deviceKey;
        this.timeStampInMillis = timeStampInMillis;
        this.numberOfElements = numberOfElements;
        this.element = element;
        this.productID = productID;
        this.companyID = companyID;
        this.versonID = versonID;
        this.isRelayFeatureSupported = isRelayFeatureSupported;
        this.isProxyFeatureSupported = isProxyFeatureSupported;
        this.isFriendFeatureSupported = isFriendFeatureSupported;
        this.isLowPowerFeatureSupported = isLowPowerFeatureSupported;
        this.NodeIdentifier = nodeIdentifier;
        this.isProvisioned = isProvisioned;
        this.sequenceNumber = sequenceNumber;
        this.unicastAddress = unicastAddress;
        this.netSequenceNumber = netSequenceNumber;
    }

    public Boolean getConfigured() {
        return isConfigured;
    }

    public void setConfigured(Boolean configured) {
        isConfigured = configured;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public byte[] getIdentityKey() {
        return identityKey;
    }

    public void setIdentityKey(byte[] identityKey) {
        this.identityKey = identityKey;
    }

    public byte[] getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(byte[] deviceKey) {
        this.deviceKey = deviceKey;
    }

    public long getTimeStampInMillis() {
        return timeStampInMillis;
    }

    public void setTimeStampInMillis(long timeStampInMillis) {
        this.timeStampInMillis = timeStampInMillis;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public Map<Integer, Element> getElement() {
        return element;
    }

    public void setElement(Map<Integer, Element> element) {
        this.element = element;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public int getVersonID() {
        return versonID;
    }

    public void setVersonID(int versonID) {
        this.versonID = versonID;
    }

    public Boolean getRelayFeatureSupported() {
        return isRelayFeatureSupported;
    }

    public void setRelayFeatureSupported(Boolean relayFeatureSupported) {
        isRelayFeatureSupported = relayFeatureSupported;
    }

    public Boolean getProxyFeatureSupported() {
        return isProxyFeatureSupported;
    }

    public void setProxyFeatureSupported(Boolean proxyFeatureSupported) {
        isProxyFeatureSupported = proxyFeatureSupported;
    }

    public Boolean getFriendFeatureSupported() {
        return isFriendFeatureSupported;
    }

    public void setFriendFeatureSupported(Boolean friendFeatureSupported) {
        isFriendFeatureSupported = friendFeatureSupported;
    }

    public Boolean getLowPowerFeatureSupported() {
        return isLowPowerFeatureSupported;
    }

    public void setLowPowerFeatureSupported(Boolean lowPowerFeatureSupported) {
        isLowPowerFeatureSupported = lowPowerFeatureSupported;
    }

    public String getNodeIdentifier() {
        return NodeIdentifier;
    }

    public void setNodeIdentifier(String nodeIdentifier) {
        NodeIdentifier = nodeIdentifier;
    }

    public Boolean getProvisioned() {
        return isProvisioned;
    }

    public void setProvisioned(Boolean provisioned) {
        isProvisioned = provisioned;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public ProvisionedNodeInformation(){

    }
    public ProvisionedNodeInformation(DataSnapshot item){
            this.isConfigured = Objects.requireNonNull(item.child("isConfigured").getValue(Boolean.class));
            this.isProvisioned = Objects.requireNonNull(item.child("isProvisioned").getValue(Boolean.class));
            this.nodeName = Objects.requireNonNull(item.child("nodeName").getValue(String.class));
            // this.identityKey = MeshParserUtils.toByteArray(Objects.requireNonNull(item.child("identityKey").getValue(String.class)));
            this.deviceKey = MeshParserUtils.toByteArray(Objects.requireNonNull(item.child("deviceKey").getValue(String.class)));
            this.numberOfElements = Objects.requireNonNull(item.child("numberOfElement").getValue(int.class));
            this.NodeIdentifier = Objects.requireNonNull(item.child("NodeIdentifier").getValue(String.class));
            this.isRelayFeatureSupported = Objects.requireNonNull(item.child("isReplayFeatureSupported").getValue(Boolean.class));
            this.unicastAddress = MeshParserUtils.toByteArray(Objects.requireNonNull(item.child("unicastAddress").getValue(String.class)));
            this.bluetoothAddress = item.getKey();
            this.netSequenceNumber = Objects.requireNonNull(item.child("netSequenceNumber").getValue(int.class));


    }
    public Map<String, Object> toMap(){
        Map<String, Object> nodeConfiguration = new HashMap<>();
        nodeConfiguration.put("isConfigured", isConfigured);
        nodeConfiguration.put("isProvisioned", isProvisioned);
        nodeConfiguration.put("nodeName", nodeName);
        // nodeConfiguration.put("identityKey", Hex.bytesToStringUppercase(identityKey));
        nodeConfiguration.put("deviceKey", Hex.bytesToStringUppercase(deviceKey));
        nodeConfiguration.put("timeStampInMillis", new SimpleDateFormat("HH:mm:ss").format(timeStampInMillis));
        nodeConfiguration.put("numberOfElement", numberOfElements);
        for(Map.Entry<Integer, Element> entry: element.entrySet()){
            Map<String, Object> elementObj = new HashMap<>();
            for(Map.Entry<Integer, MeshModel> entryModel: entry.getValue().getMeshModels().entrySet()){
                Map<String, Object> modelObj = new HashMap<>();
                modelObj.put("modelId", entryModel.getValue().getModelId());
                modelObj.put("modelName", entryModel.getValue().getModelName());
                elementObj.put("model", modelObj);
            }
            elementObj.put("eleAddress", Hex.bytesToStringUppercase(entry.getValue().getElementAddress()));
            elementObj.put("eleVendorModelCount", entry.getValue().getVendorModelCount());
            elementObj.put("eleSigModelCount", entry.getValue().getSigModelCount());
            elementObj.put("eleLocation", entry.getValue().getLocationDescriptor());
            nodeConfiguration.put("element"+entry.getKey(), elementObj);
        }
        nodeConfiguration.put("productID", productID);
        nodeConfiguration.put("companyID", companyID);
        nodeConfiguration.put("versonID", versonID);
        nodeConfiguration.put("isReplayFeatureSupported", isRelayFeatureSupported);
        nodeConfiguration.put("isProxyFeatureSupported",isProxyFeatureSupported);
        nodeConfiguration.put("isFriendFeatureSupported", isFriendFeatureSupported);
        nodeConfiguration.put("isLowPowerFeatureSupported", isLowPowerFeatureSupported);
        nodeConfiguration.put("NodeIdentifier", NodeIdentifier);
        nodeConfiguration.put("sequenceNumber", sequenceNumber + 1);
        nodeConfiguration.put("unicastAddress", Hex.bytesToStringUppercase(unicastAddress));
        nodeConfiguration.put("netSequenceNumber", netSequenceNumber);
        return nodeConfiguration;
    }
    public ProvisionedMeshNode createProvisionedMeshNode (byte[] src, String networkKey){
                                    UnprovisionedMeshNode unprovisionedMeshNode = null;
                            unprovisionedMeshNode = new UnprovisionedMeshNode();
                            //unprovisionedMeshNode.setBluetoothDeviceAddress("D6:91:79:FC:6A:EA");
                            unprovisionedMeshNode.setBluetoothDeviceAddress(bluetoothAddress);
                            unprovisionedMeshNode.setNetworkKey(MeshParserUtils.toByteArray(networkKey));
                            unprovisionedMeshNode.setKeyIndex(MeshParserUtils.toByteArray("0000"));
                            unprovisionedMeshNode.setFlags(MeshParserUtils.toByteArray("0000"));
                            unprovisionedMeshNode.setIvIndex(ByteBuffer.allocate(4).putInt(0).array());
                            unprovisionedMeshNode.setUnicastAddress(unicastAddress);
                            //unprovisionedMeshNode.setUnicastAddress(MeshParserUtils.toByteArray("0007"));
                            unprovisionedMeshNode.setTtl(5);
                            unprovisionedMeshNode.setConfigurationSrc(src);
                            //unprovisionedMeshNode.setDeviceKey(MeshParserUtils.toByteArray("B0D2281085C253034C349105E6B7CC75"));
                            unprovisionedMeshNode.setDeviceKey(deviceKey);
                            unprovisionedMeshNode.setProvisionedTime(System.currentTimeMillis());
                            final byte[] provisionerRandom = SecureUtils.generateRandomNumber();
                            //unprovisionedMeshNode.setProvisionerRandom(provisionerRandom);
                            //unprovisionedMeshNode.setDeviceKey(MeshParserUtils.toByteArray("4B00B025F4C9C6650C9AC898F127D08D"));
                            unprovisionedMeshNode.setNodeName(nodeName);
                            //unprovisionedMeshNode.setNodeName("nRF5x Mesh Switch");
                            //startProvisioning(unprovisionedMeshNode);
                            ProvisionedMeshNode node = new ProvisionedMeshNode(unprovisionedMeshNode);
//                            //addAppKey(node, 3, "1230");
                            node.setNumberOfElements(numberOfElements);
//                            //addAppKey(node,3,"D31793106AF8286FD96B6BA8B69F9392");
//                            //node.setAddedAppKey(0000, "B5EA4FB1E854DF1B5CAFBD39AA224D96");
//                            //node.setAddedAppKey(0000, "B7F675E88D8AA1DCF1C2203E5DC6CB1");
        final Map<Integer, MeshModel> models = new LinkedHashMap<>();
        final int modelId = 2;
        models.put(modelId, SigModelParser.getSigModel(modelId));
        Element ele1 = new Element(MeshParserUtils.toByteArray("0001"),0,2,0, models);
        final Map<Integer, MeshModel> models2 = new LinkedHashMap<>();
        final int modelId2 = 4096;
        models2.put(modelId2, SigModelParser.getSigModel(modelId2));
        Element ele2 = new Element(MeshParserUtils.toByteArray("0002"),0,2,0, models2);
        final Map<Integer, MeshModel> models3 = new LinkedHashMap<>();
        final int modelId3 = 4096;
        models3.put(modelId3, SigModelParser.getSigModel(modelId3));
        Element ele3 = new Element(MeshParserUtils.toByteArray("0003"),0,2,0, models3);
        final Map<Integer, Element> mElements = new LinkedHashMap<>();
        mElements.put(1, ele1);
        mElements.put(2, ele2);
        mElements.put(3, ele3);
        node.setElements(mElements);
                            node.setAddedAppKey();
                            node.setNodeIdentifier(NodeIdentifier);
                            //node.setNodeIdentifier("E3D9FFA7E69871B8");
                            node.setReplayFeatureSupport(isRelayFeatureSupported);
                            //node.setConfigured(true);
                            node.setIsProvisioned(isProvisioned);

        return node;
    }

}
