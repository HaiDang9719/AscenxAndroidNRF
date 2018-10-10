package com.example.odc.ascenxnrf.database;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.nio.charset.Charset;

import no.nordicsemi.android.meshprovisioner.configuration.ProvisionedMeshNode;
import no.nordicsemi.android.meshprovisioner.states.UnprovisionedMeshNode;

public class retrieveService {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void retrieveData(Object networkInformation){
        db.collection("test")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    public static final String TAG = "DB";

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData().get("networkKey"));
                                if(document.getData().get("nodeIdentifier") == null){
                                    continue;
                                }
                                byte[] networkey = new byte[0];
                                if(document.getData().get("networkKey") == "6A6F9A40EDD0E7A3E4A498752152498A")
                                {
                                    networkey = ("6A6F9A40EDD0E7A3E4A498752152498A").getBytes(Charset.forName("UTF-8"));
                                }

                                if(document.getData().get("nodeIdentifier").toString() == "CEDB2EBF6B8F4DA6"){
                                    UnprovisionedMeshNode node = new UnprovisionedMeshNode();
                                    node.setIsProvisioned((Boolean)document.getData().get("isProvisioned"));
                                    node.setConfigured((Boolean)document.getData().get("isConfigured"));
                                    node.setNetworkKey(networkey);

                                }
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });



    }
}
