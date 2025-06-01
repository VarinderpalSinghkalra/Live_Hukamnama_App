package com.example.hukamnamaapp.network;

import com.example.hukamnamaapp.model.Hukamnama;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("hukamnama.js")  // Adjust path based on API structure
    Call<Hukamnama> getHukamnama();
}
