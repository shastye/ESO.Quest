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

package com.clubbpc.esoquest.ui.header;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.clubbpc.esoquest.databinding.ViewHeaderBinding;
import com.google.firebase.firestore.Blob;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaDoc class description
 */
public class HeaderAdapter extends ListAdapter<Header, HeaderViewHolder> {

    public HeaderAdapter() {
        super(new DiffUtil.ItemCallback<Header>() {
            @Override
            public boolean areItemsTheSame(@NonNull Header oldItem, @NonNull Header newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull Header oldItem, @NonNull Header newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public HeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHeaderBinding binding = ViewHeaderBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new HeaderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HeaderViewHolder holder, int position) {
        holder.title.setText(getItem(position).getTitle());
        holder.description.setText(getItem(position).getDescription());
        holder.summary.init(getItem(position).getSummary());

        Blob blob = getItem(position).getImage();
        if (blob != null) {
            holder.image.setImageBitmap(BitmapFactory.decodeByteArray(blob.toBytes(), 0, blob.toBytes().length));
        } else {
            holder.image.setImageBitmap(null);
        }
    }

    @Override
    public void submitList(final List<Header> list) {
        super.submitList(list != null ? new ArrayList<>(list) : null);
    }
}
