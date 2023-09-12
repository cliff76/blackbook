package com.cliftoncraig.blackbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import com.cliftoncraig.blackbook.databinding.ListViewItemBinding;

public class MainAdapter extends BaseAdapter {
    private MainActivity activity;
    private String[] items;
    private Animation animation;

    static int[] backgrounds = {
            R.drawable.gradient_1, R.drawable.gradient_2, R.drawable.gradient_3,
            R.drawable.gradient_4, R.drawable.gradient_5, R.drawable.gradient_6,
            R.drawable.gradient_7, R.drawable.gradient_8
    };

    public MainAdapter(MainActivity activity, String[] items) {
        this.activity = activity;
        this.items = items;
        animation = AnimationUtils.loadAnimation(activity,R.anim.animation);
    }

    public static int getRandom(int max) {
        return (int) (Math.random()*max);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewItemBinding binding = ListViewItemBinding.inflate(LayoutInflater.from(activity));
        View view = binding.getRoot();
        binding.itemBackground.setBackground(activity.getDrawable(backgrounds[getRandom(8)]));
        binding.itemText.setText(items[position]);
        binding.itemText.setAnimation(animation);
        return view;
    }
}
