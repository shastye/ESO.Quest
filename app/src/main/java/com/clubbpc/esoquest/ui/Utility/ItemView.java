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

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.clubbpc.esoquest.databinding.ViewItemBinding;


/**
 * Represents a custom view for placement within the grids in each fragment to keep items consistent.
 */
public class ItemView extends ConstraintLayout {
    private final TextView mTitle;
    private final ImageView mImage;
    private final TextView mDescription;
    private final TextView mSummary;
    private final Context mContext;


    /**
     * Creates a custom view instance with the specified context and attribute set. Make sure to call
     * init(...) after initialization.
     * @param context the context for the current fragment
     * @param attrs the attribute set for the item; unused
     */
    public ItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        ViewItemBinding binding = ViewItemBinding.inflate(
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE),
                this
        );

        mTitle = binding.tvViewItemTitle;
        mImage = binding.ivViewItemImage;
        mDescription = binding.tvViewItemDescription;
        mSummary = binding.tvViewItemSummary;
    }


    /**
     * Initializes item view with item
     * @param item the item to be shown, representing a quest line or grouping
     */
    void init(@NonNull Item item) {
        mTitle.setText(item.getTitle());
        mImage.setImageBitmap(item.getImage());
        mDescription.setText(item.getDescription());

        if (item.getSummary() != null && !item.getSummary().equals("")) {
            mSummary.setText(item.getSummary());
        } else {
            mSummary.setVisibility(GONE);
        }
    }

    /**
     * Initialized needed variables for the view
     * @param title the title for the item
     * @param imageId the reference ID for the desired image
     * @param description the description of the item
     */
    void init(@NonNull String title, @NonNull Integer imageId, @NonNull String description) {
        mTitle.setText(title);
        mImage.setImageDrawable(AppCompatResources.getDrawable(mContext, imageId));
        mDescription.setText(description);
        mSummary.setVisibility(GONE);
    }

    /**
     * Initialized needed and optional variables for the view
     * @param title the title for the item
     * @param imageId the reference ID for the desired image
     * @param description the description of the item
     * @param summary the summary of the quest line in the item
     */
    void init(@NonNull String title, @NonNull Integer imageId, @NonNull String description, @NonNull String summary) {
        mTitle.setText(title);
        mImage.setImageDrawable(AppCompatResources.getDrawable(mContext, imageId));
        mDescription.setText(description);
        mSummary.setText(summary);
    }
}
