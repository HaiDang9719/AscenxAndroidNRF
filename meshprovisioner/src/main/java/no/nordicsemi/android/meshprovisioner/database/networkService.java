package no.nordicsemi.android.meshprovisioner.database;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import no.nordicsemi.android.meshprovisioner.configuration.MeshModel;
import no.nordicsemi.android.meshprovisioner.utils.Element;


public class networkService {
    private String databaseMessage = "database Message";
    private static final String TAG = networkService.class.getSimpleName();
    private static String netKey = "";
    private FirebaseAuth auth;
    Map<String, Object> nodeConfiguration = new HashMap<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    /**
     * create and send object networkInformation to firebase
     */
    public void createAndSendNetworkInforObj(String networkKey, String keyIndex, String flags, String ivIndex, String unicastAddress, String globalTtl){
        Map<String, Object> networkInformation = new HashMap<>();
        netKey = networkKey;
        networkInformation.put("networkKey", networkKey);
        networkInformation.put("keyIndex", keyIndex);
        networkInformation.put("flags", flags);
        networkInformation.put("ivIndex", ivIndex);
        networkInformation.put("unicastAddress", unicastAddress);
        networkInformation.put("globalTtl", globalTtl);
        sendDatabase(networkInformation);

    }
    /**
     * send object networkInformation to firebase
     */
    private void sendDatabase(Object networkInformation){



//        db.collection("network").whereEqualTo("userId",auth.getCurrentUser().getUid())
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d(TAG, document.getId() + " => " + document.getData().get("networkKey"));
//                                if(document.getData().get("networkKey") == null){
//                                    continue;
//                                }
//                                if(document.getData().get("networkKey").toString() == netKey){
//                                    return;
//                                }
//                            }
//                            // Add a new document with a generated ID
//                            db.collection("network")
//                                    .add(networkInformation)
//                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                        @Override
//                                        public void onSuccess(DocumentReference documentReference) {
//                                            Log.d(databaseMessage, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                        }
//                                    })
//                                    .addOnFailureListener(new OnFailureListener() {
//                                        @Override
//                                        public void onFailure(@NonNull Exception e) {
//                                            Log.w("test", "Error adding document", e);
//                                        }
//                                    });
//                        } else {
//                            Log.d(TAG, "Error getting documents: ", task.getException());
//                        }
//                    }
//                });



    }
    /**
     * create and send object networkInformation to firebase
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    public void createAndSendNodeConfigureObj(
            Boolean isConfigured, String nodeName, byte[] identityKey,
            byte[] deviceKey, long timeStampInMillis, int numberOfElements,
            Map<Integer, Element> element, int productID, int companyID, int versonID,
            Boolean isRelayFeatureSupported, Boolean isProxyFeatureSupported, Boolean isFriendFeatureSupported,
            Boolean isLowPowerFeatureSupported, String NodeIdentifier, Boolean isProvisioned
    ){
        nodeConfiguration = new HashMap<>();
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
        sendDatabase1(nodeConfiguration);

    }
    /**
     * send object networkInformation to firebase
     */
    private void sendDatabase1(Object abc){
        // Add a new document with a generated ID
        db.collection("test")
                .add(abc)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(databaseMessage, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("test", "Error adding document", e);
                    }
                });
    }



}
