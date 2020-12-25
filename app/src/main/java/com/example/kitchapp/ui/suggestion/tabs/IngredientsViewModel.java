package com.example.kitchapp.ui.suggestion.tabs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IngredientsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public IngredientsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ingredients fragment goes here...");
    }

    public LiveData<String> getText() {
        return mText;
    }
}