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

package com.clubbpc.esoquest.ui.Utility;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

/**
 * Represents a quest line or grouping.
 * If summary is defined, then the item is a quest line. If not, it's a grouping, such as an alliance.
 */
public class Item {
    private String mTitle;
    private Bitmap mImage;
    private String mDescription;
    private String mSummary;


    /**
     * Default constructor for item; initializes all fields to NULL
     */
    public Item() {
        mTitle = null;
        mImage = null;
        mDescription = null;
        mSummary = null;
    }

    /**
     * Partial constructor for item; initializes summary field to NULL
     * @param title the title of the quest line or grouping
     * @param image the image of the quest line or grouping
     * @param description the description of the quest line or grouping
     */
    public Item(@NonNull String title, @NonNull Bitmap image, @NonNull String description) {
        mTitle = title;
        mImage = image;
        mDescription = description;
        mSummary = null;
    }

    /**
     * Partial constructor for item; initializes summary field to NULL
     * @param title the title of the quest line or grouping
     * @param image the image of the quest line or grouping
     * @param description the description of the quest line or grouping
     * @param summary the summary of the quest line
     */
    public Item(@NonNull String title, @NonNull Bitmap image, @NonNull String description, @NonNull String summary) {
        mTitle = title;
        mImage = image;
        mDescription = description;
        mSummary = summary;
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
}
