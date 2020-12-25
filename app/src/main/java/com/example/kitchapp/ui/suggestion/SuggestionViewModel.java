package com.example.kitchapp.ui.suggestion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SuggestionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SuggestionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Suggested meal name goes here...");
    }

    public LiveData<String> getText() {
        return mText;
    }
}