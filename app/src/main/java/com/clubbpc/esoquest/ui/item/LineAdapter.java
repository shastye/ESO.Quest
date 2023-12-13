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

package com.clubbpc.esoquest.ui.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.clubbpc.esoquest.databinding.ViewLineBinding;
import com.google.firebase.firestore.Blob;

import java.util.ArrayList;
import java.util.List;

/**
 * A ListAdapter for displaying items as ListViewHolders in a recyclerview
 */
public class LineAdapter extends ListAdapter<Item, LineViewHolder> {

    public interface OnClickListener {
        void onClick(Item item, View view);
    }

    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener listener) {
        mOnClickListener = listener;
    }


    public LineAdapter() {
        super(new DiffUtil.ItemCallback<Item>() {
            @Override
            public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public LineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewLineBinding binding = ViewLineBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new LineViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LineViewHolder holder, int position) {
        final Item item = getItem(position);

        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.summary.init(item.getSummary());

        Blob blob = item.getImage();
        if (blob != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(
                    blob.toBytes(),
                    0,
                    blob.toBytes().length
            );
            Drawable drawable = new BitmapDrawable(Resources.getSystem(), bitmap);
            holder.image.setBackground(drawable);

            holder.image.post(() -> {
                if (holder.image.getBackground() != null) {
                    int width = holder.description.getWidth();
                    float ratio = (float) bitmap.getWidth() / (float) bitmap.getHeight();
                    int calcHeight = (int) (width / ratio);

                    holder.image.setMinimumWidth(width);
                    holder.image.setMinimumHeight(calcHeight);
                }
            });
        } else {
            holder.image.setBackground(null);
        }

        holder.background.setOnClickListener(v -> {
            if (mOnClickListener != null) {
                mOnClickListener.onClick(item, v);
            }
        });
    }

    @Override
    public void submitList(final List<Item> list) {
        super.submitList(list != null ? new ArrayList<>(list) : null);
    }
}
