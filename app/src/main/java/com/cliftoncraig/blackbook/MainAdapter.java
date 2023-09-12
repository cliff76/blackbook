package com.cliftoncraig.blackbook;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cliftoncraig.blackbook.databinding.ListViewItemBinding;

public class MainAdapter extends BaseAdapter {
    private final ListViewItemBinding binding;
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
        this.binding = ListViewItemBinding.inflate(LayoutInflater.from(activity));
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
        View view = LayoutInflater.from(activity).inflate(R.layout.list_view_item, parent, false);
        LinearLayout background = view.findViewById(R.id.itemBackground);
        Drawable drawable = activity.getDrawable(backgrounds[getRandom(8)]);
        background.setBackground(drawable);
        TextView textView = view.findViewById(R.id.itemText);
        textView.setText(items[position]);
        textView.setAnimation(animation);
        return view;
    }
}
