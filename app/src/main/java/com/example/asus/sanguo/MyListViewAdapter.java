package com.example.asus.sanguo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> list;
    private List<Map<String, Object>> searchlist;
    private MyFilter mfilter;

    MyListViewAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;
        searchlist = list;
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
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.list_view, null);
            holder.image = view.findViewById(R.id.list_image);
            holder.name = view.findViewById(R.id.list_name);
            holder.sex = view.findViewById(R.id.list_sex);
            holder.date = view.findViewById(R.id.list_date);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.image.setImageResource(ImageGet.getImage(list.get(i).get("image").toString()));
        holder.name.setText(list.get(i).get("name").toString());
        holder.sex.setText(list.get(i).get("sex").toString());
        holder.date.setText(list.get(i).get("birth").toString()+"-"+list.get(i).get("death").toString());

        return view;
    }
    static class ViewHolder{
        ImageView image;
        TextView name;
        TextView sex;
        TextView date;
    }
    void refreshList(List<Map<String, Object>> list){
        this.list = list;
        notifyDataSetChanged();

    }

    Filter getFilter() {
        if (mfilter==null) {
            mfilter = new MyFilter();
        }
        return mfilter;
    }

    class MyFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults result = new FilterResults();
            List<Map<String, Object>> data;
            if (TextUtils.isEmpty(charSequence)){//当过滤的关键字为空的时候，我们则显示所有的数据
                data  = searchlist;
            }else {//否则把符合条件的数据对象添加到集合中
                data = new ArrayList<>();
                String seString = charSequence.toString().toLowerCase();
                for (Map<String, Object> filterlist : searchlist){
                    String name = filterlist.get("name").toString().toLowerCase();
                    String sex = filterlist.get("sex").toString().toLowerCase();
                    String birth = filterlist.get("birth").toString().toLowerCase();
                    String death = filterlist.get("death").toString().toLowerCase();
                    if (name.contains(seString)||sex.contains(seString)||birth.contains(seString)||death.contains(seString)) {
                        data.add(filterlist);
                    }
                }
            }
            result.values = data; //将得到的集合保存到FilterResults的value变量中
            result.count = data.size();//将集合的大小保存到FilterResults的count变量中

            return result;
        }
        //在publishResults方法中告诉适配器更新界面
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            list = (List<Map<String, Object>>)filterResults.values;
            if (filterResults.count>0){
                notifyDataSetChanged();//通知数据发生了改变
            }else {
                notifyDataSetInvalidated();//通知数据失效
            }
        }
    }
}
