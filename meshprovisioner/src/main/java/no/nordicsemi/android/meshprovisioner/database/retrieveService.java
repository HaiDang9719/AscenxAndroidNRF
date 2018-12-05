package no.nordicsemi.android.meshprovisioner.database;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.nio.charset.Charset;


import no.nordicsemi.android.meshprovisioner.MeshManagerApi;
import no.nordicsemi.android.meshprovisioner.configuration.ProvisionedMeshNode;
import no.nordicsemi.android.meshprovisioner.states.UnprovisionedMeshNode;


public class retrieveService {

    MeshManagerApi mMeshManagerApi;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void retrieveData(){
        db.collection("test")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    public static final String TAG = "DB";

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData().get("NodeIdentifier"));
                                if(document.getData().get("NodeIdentifier") != null) {


//                                byte[] networkey = new byte[0];
//                                if(document.getData().get("networkKey") == "6A6F9A40EDD0E7A3E4A498752152498A")
//                                {
//                                    networkey = ("6A6F9A40EDD0E7A3E4A498752152498A").getBytes(Charset.forName("UTF-8"));
//                                }
                                    if (document.getData().get("NodeIdentifier").toString().equals("CEDB2EBF6B8F4DA6")) {
                                        UnprovisionedMeshNode unprovisionedMeshNode = null;
                                        unprovisionedMeshNode = new UnprovisionedMeshNode();
                                        unprovisionedMeshNode.setBluetoothDeviceAddress("67572279670323904790D1D636A25461");
                                        unprovisionedMeshNode.setNetworkKey(("6A6F9A40EDD0E7A3E4A498752152498A").getBytes(Charset.forName("UTF-8")));
                                        unprovisionedMeshNode.setKeyIndex(("0").getBytes(Charset.forName("UTF-8")));
                                        unprovisionedMeshNode.setFlags(("0").getBytes(Charset.forName("UTF-8")));
                                        unprovisionedMeshNode.setIvIndex(("0").getBytes(Charset.forName("UTF-8")));
                                        unprovisionedMeshNode.setUnicastAddress(("43").getBytes(Charset.forName("UTF-8")));
                                        unprovisionedMeshNode.setTtl(5);
                                        unprovisionedMeshNode.setConfigurationSrc(("0").getBytes(Charset.forName("UTF-8")));
                                        ProvisionedMeshNode node = new ProvisionedMeshNode(unprovisionedMeshNode);
                                        //mMeshManagerApi.onNodeProvisioned(node);


                                    }
                                }
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });



    }
}
