package com.think42.interview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.think42.interview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    RecyclerAdapter mAdapter;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.rvItemView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerAdapter(new ItemClickListener() {
            @Override
            public void OnClick(int pos) {
                scrollDown();
            }
        });
        mBinding.rvItemView.setAdapter(mAdapter);
    }

    private void scrollDown() {
        if (count == mAdapter.getItemCount()) {
            count = 0;
        }
        if (count < mAdapter.getItemCount()) {
            mBinding.rvItemView.smoothScrollToPosition(++count);
        }
    }
}