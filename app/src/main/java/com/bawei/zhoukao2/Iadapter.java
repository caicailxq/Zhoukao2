package com.bawei.zhoukao2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhoukao2.bean.Qbean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/16.
 */

public class Iadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Qbean.SongListBean> list;
    private int itemWidth ;

    public Iadapter(Context context) {
        this.context = context;
        /*Point point =  Utils.getDisplayInfomation(context);

        itemWidth = point.x / 3 ;*/
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
       MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder){

           MyViewHolder iViewHolder = (MyViewHolder) holder;

           /* LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iViewHolder.img.getLayoutParams() ;
            params.width = itemWidth ;
            int height =  new Random().nextInt(1000);
            params.height =  height < 300 ? 300 : height ;

            iViewHolder.img.setLayoutParams(params);*/
            Glide.with(context).load(list.get(position).getPic_small()).into(iViewHolder.img);


            iViewHolder.title.setText(list.get(position).getTitle());
            iViewHolder.author.setText(list.get(position).getAuthor());




        }

    }

    @Override
    public int getItemCount() {
        return list==null ? 0 :list.size();
    }

    public void setData(Qbean qbean) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(qbean.getSong_list());
        notifyDataSetChanged();

    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.author)
        TextView author;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
