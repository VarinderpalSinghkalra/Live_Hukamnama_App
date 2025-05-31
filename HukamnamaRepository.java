package com.example.hukamnamaapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hukamnamaapp.model.Hukamnama;
import com.example.hukamnamaapp.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HukamnamaRepository {
    private MutableLiveData<Hukamnama> hukamnamaLiveData = new MutableLiveData<>();

    public void fetchHukamnama() {
        RetrofitClient.getApiService().getHukamnama().enqueue(new Callback<Hukamnama>() {
            @Override
            public void onResponse(Call<Hukamnama> call, Response<Hukamnama> response) {
                if (response.isSuccessful() && response.body() != null) {
                    hukamnamaLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Hukamnama> call, Throwable t) {
                hukamnamaLiveData.postValue(null);
            }
        });
    }

    public LiveData<Hukamnama> getHukamnamaLiveData() {
        return hukamnamaLiveData;
    }
}
