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

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import java.util.ArrayList;

/**
 * Represents a quest line or grouping.
 */
public class Header {
    private String mTitle;
    private Bitmap mImage;
    private String mDescription;
    private String mSummary;
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

    /**
     * Partial constructor for header; initializes summary and quest list fields to NULL
     * @param title the title of the quest line or grouping
     * @param image the image of the quest line or grouping
     * @param description the description of the quest line or grouping
     */
    public Header(@NonNull String title, @NonNull Bitmap image, @NonNull String description) {
        mTitle = title;
        mImage = image;
        mDescription = description;
        mSummary = null;
        mQuests = null;
    }

    /**
     * Partial constructor for header; initializes quest list field to NULL
     * @param title the title of the quest line or grouping
     * @param image the image of the quest line or grouping
     * @param description the description of the quest line or grouping
     * @param summary the summary of the quest line
     */
    public Header(@NonNull String title, @NonNull Bitmap image, @NonNull String description, @NonNull String summary) {
        mTitle = title;
        mImage = image;
        mDescription = description;
        mSummary = summary;
        mQuests = null;
    }

    /**
     * Copy constructor for header
     * @param header the object to be copied
     */
    public Header(@NonNull Header header) {
        mTitle = header.mTitle;
        mImage = header.mImage;
        mDescription = header.mDescription;
        mSummary = header.mSummary;
        mQuests = new ArrayList<>(header.mQuests);
    }


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Bitmap getImage() {
        return mImage;
    }

    public void setImage(Bitmap mImage) {
        this.mImage = mImage;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    public ArrayList<String> getmQuests() {
        return mQuests;
    }

    public void setmQuests(ArrayList<String> mQuests) {
        this.mQuests = mQuests;
    }
}
