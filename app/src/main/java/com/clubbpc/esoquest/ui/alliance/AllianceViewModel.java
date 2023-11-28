package com.clubbpc.esoquest.ui.alliance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllianceViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AllianceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is alliance fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}