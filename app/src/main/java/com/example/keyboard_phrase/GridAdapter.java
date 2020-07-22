package com.example.keyboard_phrase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class GridAdapter extends BaseAdapter{

    class ViewHolder {
        TextView textView;
    }

    private LayoutInflater layoutInflater;
    private Context context;
    private List<String> items;
    private int layoutId;

    public GridAdapter(Context context, int layoutId, List<String> texts){
        super();
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.layoutId = layoutId;
        items = texts;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(layoutId, parent, false);

            holder = new ViewHolder();

            holder.textView = convertView.findViewById(R.id.fixed_phrase_content);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }



        holder.textView.setText(items.get(position));

        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println(holder.textView.getText());

        return convertView;
    }
}