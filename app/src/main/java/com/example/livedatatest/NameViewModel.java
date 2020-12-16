package com.example.livedatatest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NameViewModel extends ViewModel {
    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName(String name) {
        if (currentName == null) {
            currentName = new MutableLiveData<String>();
            createName(name);
        }
        return currentName;
    }

    public void createName(String name) {
        currentName.setValue(name);
    }
}
