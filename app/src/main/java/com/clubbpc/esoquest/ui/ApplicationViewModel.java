/*
 * Copyright (c) 2023 Sierra
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NON-INFRINGEMENT. IN NO EVENT SHALL THE X CONSORTIUM BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Except as contained in this notice, the name of Sierra shall not be used in advertising or
 * otherwise to promote the sale, use or other dealings in this Software without prior written
 * authorization from Sierra.
 */

package com.clubbpc.esoquest.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.clubbpc.esoquest.ui.utility.Constants;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Map;

/**
 * Contains variables/information required for various fragments
 */
public class ApplicationViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<String>> mMainOrder;
    private final MutableLiveData<ArrayList<String>> mAllianceOrder;
    private final MutableLiveData<ArrayList<String>> mGuildOrder;
    private final MutableLiveData<ArrayList<String>> mNeutralOrder;

    /**
     * Used to initialize the ApplicationViewModel.
     * Initializes MainOrder, AllianceOrder, and GuildOrder lists to be empty lists.
     */
    @SuppressWarnings({"unchecked"})
    public ApplicationViewModel() {
        mMainOrder = new MutableLiveData<>(new ArrayList<>());
        mAllianceOrder = new MutableLiveData<>(new ArrayList<>());
        mGuildOrder = new MutableLiveData<>(new ArrayList<>());
        mNeutralOrder = new MutableLiveData<>(new ArrayList<>());

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(Constants.ORDER_KEY)
                .get()
                .addOnCompleteListener(task -> {
                    ArrayList<String> quests;

                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Map<String, Object> map = document.getData();

                            try {
                                quests = (ArrayList<String>) map.get(Constants.QUESTS_KEY);
                            } catch (ClassCastException | NullPointerException e) {
                                quests = null;
                            }

                            if (quests != null) {
                                if (document.getId().equals(Constants.ALLIANCE_KEY)) {
                                    setAllianceOrder(quests);
                                } else if (document.getId().equals(Constants.MAIN_KEY)) {
                                    setMainOrder(quests);
                                } else if (document.getId().equals(Constants.GUILD_KEY)) {
                                    setGuildOrder(quests);
                                } else {
                                    setNeutralOrder(quests);
                                }
                            }
                        }
                    } else {
                        setAllianceOrder(null);
                        setMainOrder(null);
                        setGuildOrder(null);
                        setNeutralOrder(null);
                    }
                });
    }

    public LiveData<ArrayList<String>> getMainOrder() {
        return mMainOrder;
    }

    public void setMainOrder(ArrayList<String> mainOrder) {
        mMainOrder.postValue(mainOrder);
    }

    public LiveData<ArrayList<String>> getAllianceOrder() {
        return mAllianceOrder;
    }

    public void setAllianceOrder(ArrayList<String> allianceOrder) {
        mAllianceOrder.postValue(allianceOrder);
    }

    public LiveData<ArrayList<String>> getGuildOrder() {
        return mGuildOrder;
    }

    public void setGuildOrder(ArrayList<String> guildOrder) {
        mGuildOrder.postValue(guildOrder);
    }

    public LiveData<ArrayList<String>> getNeutralOrder() {
        return mNeutralOrder;
    }

    public void setNeutralOrder(ArrayList<String> neutralOrder) {
        mNeutralOrder.postValue(neutralOrder);
    }
}