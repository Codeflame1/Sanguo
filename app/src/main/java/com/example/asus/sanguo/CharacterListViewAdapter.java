package com.example.asus.sanguo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;
import java.util.Map;

public class CharacterListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> list;

    CharacterListViewAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        String birth = list.get(i).get("birth").toString();
        String death = list.get(i).get("death").toString();

        if (birth.equals("0"))
            birth = "?";
        if (death.equals("0"))
            death = "?";

        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.character_list, null);
            holder.image = view.findViewById(R.id.list_image);
            holder.frame = view.findViewById(R.id.list_frame);
            holder.name = view.findViewById(R.id.list_name);
            holder.date = view.findViewById(R.id.list_date);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.image.setImageResource(ImageGet.getImage(list.get(i).get("image").toString()));
        holder.frame.setImageResource(ImageGet.getSmallFrame(list.get(i).get("job").toString()));
        holder.name.setText(list.get(i).get("name").toString());
        holder.date.setText(birth+"-"+death);

        return view;
    }
    static class ViewHolder{
        ImageView image;
        ImageView frame;
        TextView name;
        TextView date;
    }
    void refreshList(List<Map<String, Object>> list){
        this.list = list;
        notifyDataSetChanged();

    }
}
