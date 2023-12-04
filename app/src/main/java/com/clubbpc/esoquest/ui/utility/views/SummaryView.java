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

package com.clubbpc.esoquest.ui.utility.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.clubbpc.esoquest.R;
import com.clubbpc.esoquest.databinding.ViewSummaryBinding;

/**
 * Represents a collapsible custom view for summaries
 */
public class SummaryView extends ConstraintLayout {
    private final TextView mSummary;
    private final Context mContext;


    /**
     * Creates a custom view instance with the specified context and attribute set.
     * Make sure to call init(...) after initialization.
     * @param context the context for the current fragment
     * @param attrs the attribute set for the item; unused
     */
    public SummaryView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        ViewSummaryBinding binding = ViewSummaryBinding.inflate(
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE),
                this
        );

        mSummary = binding.tvViewSummarySummary;
        mSummary.setVisibility(GONE);

        binding.ivViewSummaryShowIcon.setOnClickListener(onPlusClick());
    }

    /**
     * Initialized needed variables for the view
     * @param summary the summary for the item
     */
    public void init(@NonNull String summary) {
        mSummary.setText(summary);
    }

    public OnClickListener onPlusClick() {
        return v -> {
            Drawable minus = ContextCompat.getDrawable(mContext, R.drawable.ic_minus_48dp);

            mSummary.setVisibility(VISIBLE);
            ((ImageView) v).setImageDrawable(minus);
            v.setOnClickListener(onMinusClick());
        };
    }

    public OnClickListener onMinusClick() {
        return v -> {
            Drawable plus = ContextCompat.getDrawable(mContext, R.drawable.ic_plus_48dp);

            mSummary.setVisibility(GONE);
            ((ImageView) v).setImageDrawable(plus);
            v.setOnClickListener(onPlusClick());
        };
    }
}
