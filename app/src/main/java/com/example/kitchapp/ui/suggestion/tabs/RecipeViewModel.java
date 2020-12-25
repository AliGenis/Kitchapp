package com.example.kitchapp.ui.suggestion.tabs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecipeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RecipeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Recipes fragment goes here...");
    }

    public LiveData<String> getText() {
        return mText;
    }
}