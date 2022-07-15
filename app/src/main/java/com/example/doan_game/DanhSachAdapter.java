package com.example.doan_game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DanhSachAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DanhSach> danhsachList;
    private List<DanhSach> danhsachListOld;

    public DanhSachAdapter(Context context, int layout, List<DanhSach> danhsachList) {
        this.context = context;
        this.layout = layout;
        this.danhsachList = danhsachList;
    }

    @Override
    public int getCount() {
        return danhsachList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView user;
        TextView txtTen, txtDiem;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            // ánh xạ view
            holder.user = (ImageView)view.findViewById(R.id.imageViewHinh);
            holder.txtTen = (TextView) view.findViewById(R.id.textviewHoTen);
            holder.txtDiem = (TextView) view.findViewById(R.id.textviewDiem);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        DanhSach danhSach = danhsachList.get(i);

        holder.user.setImageResource(R.drawable.user);
        holder.txtTen.setText(danhSach.getTen());
        holder.txtDiem.setText(danhSach.getDiem());



        return view;
    }
}
