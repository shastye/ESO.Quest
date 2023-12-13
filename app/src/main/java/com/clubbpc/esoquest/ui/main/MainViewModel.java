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

package com.clubbpc.esoquest.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.clubbpc.esoquest.ui.item.Item;
import com.clubbpc.esoquest.ui.Constants;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Contains variables/information required for the Main Fragment
 */
public class MainViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Item>> mMainHeaders;
    private final MutableLiveData<ArrayList<Item>> mLineHeaders;
    private final MutableLiveData<Item> mClickedHeader;


    /**
     * Used to initialize the MainViewModel.
     * Initializes MainHeaders lists to be empty lists.
     */
    public MainViewModel() {
        mMainHeaders = new MutableLiveData<>(new ArrayList<>());
        mLineHeaders = new MutableLiveData<>(new ArrayList<>());
        mClickedHeader = new MutableLiveData<>(null);
    }

    /**
     * Used to assign the proper headers in order into the MainHeaders list.
     * @param mainOrder the order in which the headers are supposed to appear.
     */
    public void queryDatabase(ArrayList<String> mainOrder) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        if (mainOrder != null && mainOrder.size() != 0) {
            db.collection(Constants.MAIN_KEY)
                    .get()
                    .addOnCompleteListener(task -> {
                        Item[] items = new Item[mainOrder.size()];

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Item item = document.toObject(Item.class);
                                item.setTitle(document.getId());

                                int index = mainOrder.indexOf(document.getId());
                                items[index] = item;
                            }
                        } else {
                            items = null;
                        }

                        assert items != null;
                        mMainHeaders.postValue(new ArrayList<>(Arrays.asList(items)));
                    });
        }
    }

    /**
     * Used to assign the proper headers in order into the LineHeaders list.
     * @param item the item that was clicked on the MainFragment section.
     */
    public void queryLine(Item item) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        if (item.getQuests() != null && item.getQuests().size() != 0) {
            db.collection(Constants.MAIN_KEY)
                    .document(item.getTitle())
                    .collection(Constants.QUESTS_KEY)
                    .get()
                    .addOnCompleteListener(task -> {
                        Item[] items = new Item[item.getQuests().size()];

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Item h = document.toObject(Item.class);

                                h.setTitle(document.getId());

                                int index = item.getQuests().indexOf(document.getId());
                                items[index] = h;
                            }
                        } else {
                            items = null;
                        }

                        assert items != null;

                        ArrayList<Item> tempList = new ArrayList<>(Arrays.asList(items));
                        tempList.removeAll(Collections.singleton(null));
                        mLineHeaders.postValue(tempList);
                    });
        }
    }

    public MutableLiveData<ArrayList<Item>> getMainHeaders() {
        return mMainHeaders;
    }

    public MutableLiveData<ArrayList<Item>> getLineHeaders() {
        return mLineHeaders;
    }

    public MutableLiveData<Item> getClickedHeader() {
        return mClickedHeader;
    }
}