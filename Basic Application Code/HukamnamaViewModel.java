package com.example.hukamnamaapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.hukamnamaapp.model.Hukamnama;
import com.example.hukamnamaapp.repository.HukamnamaRepository;

public class HukamnamaViewModel extends ViewModel {
    private HukamnamaRepository repository = new HukamnamaRepository();

    public HukamnamaViewModel() {
        repository.fetchHukamnama();
    }

    public LiveData<Hukamnama> getHukamnama() {
        return repository.getHukamnamaLiveData();
    }
}
