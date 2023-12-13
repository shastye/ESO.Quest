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

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.clubbpc.esoquest.R;
import com.clubbpc.esoquest.databinding.FragmentLineBinding;
import com.clubbpc.esoquest.ui.ApplicationViewModel;
import com.clubbpc.esoquest.ui.item.LineAdapter;

public class LineFragment extends Fragment {

    private FragmentLineBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding = FragmentLineBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Toolbar toolbar = requireActivity().findViewById(R.id.toolbar);
        RecyclerView recyclerView = binding.recyclerviewLine;
        LineAdapter adapter = new LineAdapter();


        recyclerView.setNestedScrollingEnabled(false);

        adapter.setOnClickListener((item, view) -> {
            mainViewModel.getClickedHeader().postValue(item);
            //Navigation.findNavController(view).navigate(R.id.action_nav_main_to_nav_line);
        });
        recyclerView.setAdapter(adapter);

        mainViewModel.getClickedHeader().observe(getViewLifecycleOwner(), item -> {
            toolbar.setTitle(item.getTitle());
            ApplicationViewModel.displayImage(item, binding.ivFragmentLineImage);
            binding.tvFragmentLineSummary.setText(item.getSummary());
            mainViewModel.queryLine(item);
        });
        mainViewModel.getLineHeaders().observe(getViewLifecycleOwner(), adapter::submitList);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}