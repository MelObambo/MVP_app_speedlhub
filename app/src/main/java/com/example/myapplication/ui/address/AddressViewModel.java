package com.example.myapplication.ui.address;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.AddressModel;
import com.example.myapplication.tools.JSONParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddressViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<AddressModel>> addresses = new MutableLiveData<>();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final String apiUrl = "http://10.0.2.2:5006/api/address";

    public LiveData<ArrayList<AddressModel>> getTable() {
        return addresses;
    }

    protected void fetchUserData() {
        executorService.execute(() -> {
            JSONParser jsonParser = new JSONParser();
            JSONArray response = jsonParser.makeHttpRequest(apiUrl, null, new HashMap<>());
            ArrayList<AddressModel> theAddresses = new ArrayList<>();
            if (response != null) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject address = response.getJSONObject(i);
                        theAddresses.add(new AddressModel(
                                address.getInt("id"),
                                address.getString("type"),
                                address.getString("firstname"),
                                address.getString("surname"),
                                address.optString("corporateName", ""),
                                address.getString("mail"),
                                address.getString("phoneNumber"),
                                address.getString("country"),
                                address.getString("postCode"),
                                address.getString("city"),
                                address.getString("street"),
                                address.optString("addressComplement", "")));
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            handler.post(() -> {
                addresses.setValue(theAddresses);
            });
        });
    }

    public AddressViewModel() {
        this.fetchUserData();
    }
}