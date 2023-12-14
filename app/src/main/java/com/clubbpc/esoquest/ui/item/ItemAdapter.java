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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.clubbpc.esoquest.databinding.ViewHeaderBinding;
import com.clubbpc.esoquest.databinding.ViewLineBinding;
import com.clubbpc.esoquest.ui.ApplicationViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A ListAdapter for displaying items as HeaderViewHolders or ListViewHolders in a recyclerview
 */
public class ItemAdapter extends ListAdapter<Item, RecyclerView.ViewHolder> {
    public interface OnClickListener {
        void onClick(Item item, View view);
    }


    private final int mViewType;
    private OnClickListener mOnClickListener;


    public ItemAdapter(int viewType) {
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

        mViewType = viewType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final int HEADER_VIEW_TYPE = 0;
        final int LINE_VIEW_TYPE = 1;

        if (mViewType == HEADER_VIEW_TYPE) {
            ViewHeaderBinding binding = ViewHeaderBinding.inflate(LayoutInflater.from(parent.getContext()));
            return new HeaderViewHolder(binding);
        } else if (mViewType == LINE_VIEW_TYPE) {
            ViewLineBinding binding = ViewLineBinding.inflate(LayoutInflater.from(parent.getContext()));
            return new LineViewHolder(binding);
        } else {
            // TODO: CHANGE TO QUESTVIEWHOLDER
            ViewHeaderBinding binding = ViewHeaderBinding.inflate(LayoutInflater.from(parent.getContext()));
            return new HeaderViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Item item = getItem(position);

        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).title.setText(item.getTitle());
            ((HeaderViewHolder) holder).description.setText(item.getDescription());
            ApplicationViewModel.displayImage(item, ((HeaderViewHolder) holder).image);

            ((HeaderViewHolder) holder).background.setOnClickListener(v -> {
                if (mOnClickListener != null) {
                    mOnClickListener.onClick(item, v);
                }
            });
        } else if (holder instanceof LineViewHolder) {
            ((LineViewHolder) holder).title.setText(item.getTitle());
            ((LineViewHolder) holder).description.setText(item.getDescription());
            ApplicationViewModel.displayImage(item, ((LineViewHolder) holder).image);

            ((LineViewHolder) holder).background.setOnClickListener(v -> {
                if (mOnClickListener != null) {
                    mOnClickListener.onClick(item, v);
                }
            });
        }
    }

    @Override
    public void submitList(final List<Item> list) {
        super.submitList(list != null ? new ArrayList<>(list) : null);
    }

    public void setOnClickListener(OnClickListener listener) {
        mOnClickListener = listener;
    }
}
