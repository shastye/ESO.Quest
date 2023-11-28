package com.clubbpc.esoquest.ui.guild;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GuildViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GuildViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}