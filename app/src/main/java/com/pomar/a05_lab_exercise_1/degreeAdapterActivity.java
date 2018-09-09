package com.pomar.a05_lab_exercise_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class degreeAdapterActivity extends ArrayAdapter<String> {

    private Context context;
    private int itemLayoutResource;
    private ArrayList<String> degree = new ArrayList<>();

    public degreeAdapterActivity(@NonNull Context context, int resource, @NonNull List<String> degree) {
        super(context, resource, degree);

        this.context = context;
        this.itemLayoutResource = resource;
        this.degree.addAll(degree);
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return this.degree.get(position);
    }

    @Override
    public int getCount() {
        return this.degree.size();
    }

    @Override
    public int getPosition(@Nullable String item) {
        return this.degree.indexOf(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String degreeName = getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View degreeItemLayout = inflater.inflate(itemLayoutResource, parent, false);

        TextView degreeNameTextView = degreeItemLayout.findViewById(R.id.name_textView);
        degreeNameTextView.setText(degreeName);

        return degreeItemLayout;
    }
}
