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

package com.clubbpc.esoquest.ui.utility;

import androidx.annotation.Nullable;

import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.PropertyName;

import java.util.ArrayList;

/**
 * Represents a quest line or grouping.
 */
public class Header {
    @PropertyName("Title")
    private String mTitle;
    @PropertyName("Image")
    private Blob mImage;
    @PropertyName("Description")
    private String mDescription;
    @PropertyName("Summary")
    private String mSummary;
    @PropertyName("Quests")
    private ArrayList<String> mQuests;


    /**
     * Default constructor for header; initializes all fields to NULL
     */
    public Header() {
        mTitle = null;
        mImage = null;
        mDescription = null;
        mSummary = null;
        mQuests = null;
    }



    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Header)) {
            return false;
        }

        Header h = (Header) obj;
        boolean theSame = mTitle.equals(h.mTitle);

        if (mImage != null) {
            theSame = theSame && mImage.equals(h.mImage);
        } else if (h.mImage != null) {
            theSame = false;
        }

        if (mDescription != null) {
            theSame = theSame && mDescription.equals(h.mDescription);
        } else if (h.mDescription != null) {
            theSame = false;
        }

        if (mSummary != null) {
            theSame = theSame && mSummary.equals(h.mSummary);
        } else if (h.mSummary != null) {
            theSame = false;
        }

        if (mQuests != null) {
            theSame = theSame && mQuests.equals(h.mQuests);
        } else if (h.mQuests != null) {
            theSame = false;
        }

        return theSame;
    }


    @SuppressWarnings("unused")
    public String getTitle() {
        return mTitle;
    }

    @SuppressWarnings("unused")
    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @SuppressWarnings("unused")
    public Blob getImage() {
        return mImage;
    }

    @SuppressWarnings("unused")
    public void setImage(Blob mImage) {
        this.mImage = mImage;
    }

    @SuppressWarnings("unused")
    public String getDescription() {
        return mDescription;
    }

    @SuppressWarnings("unused")
    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    @SuppressWarnings("unused")
    public String getSummary() {
        return mSummary;
    }

    @SuppressWarnings("unused")
    public void setSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    @SuppressWarnings("unused")
    public ArrayList<String> getQuests() {
        return mQuests;
    }

    @SuppressWarnings("unused")
    public void setQuests(ArrayList<String> mQuests) {
        this.mQuests = mQuests;
    }
}
