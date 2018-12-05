package no.nordicsemi.android.meshprovisioner.database;

import com.google.android.gms.common.util.Hex;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import no.nordicsemi.android.meshprovisioner.configuration.MeshModel;
import no.nordicsemi.android.meshprovisioner.utils.Element;

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

    public ProvisionedNodeInformation(Boolean isConfigured, String nodeName, byte[] identityKey, byte[] deviceKey, long timeStampInMillis, int numberOfElements, Map<Integer, Element> element, int productID, int companyID, int versonID, Boolean isRelayFeatureSupported, Boolean isProxyFeatureSupported, Boolean isFriendFeatureSupported, Boolean isLowPowerFeatureSupported, String nodeIdentifier, Boolean isProvisioned) {
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
    }
    public ProvisionedNodeInformation(){

    }
    public Map<String, Object> toMap(){
        Map<String, Object> nodeConfiguration = new HashMap<>();
        nodeConfiguration.put("isConfigured", isConfigured);
        nodeConfiguration.put("isProvisoned", isProvisioned);
        nodeConfiguration.put("nodeName", nodeName);
        nodeConfiguration.put("identityKey", Hex.bytesToStringUppercase(identityKey));
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
        return nodeConfiguration;
    }

}
