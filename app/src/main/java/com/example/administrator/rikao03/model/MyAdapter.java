package com.example.administrator.rikao03.model;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.example.administrator.rikao03.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class MyAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    private OnItemClickListener onItemClickListener;
    private List<GoodsBean.DataBean> list;
    private Context context;
    private static final int TYPE0 = 0;
    private static final int TYPE1 = 1;

    public MyAdapter(List<GoodsBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE0) {
            View view = View.inflate(context, R.layout.item, null);
            MyHodler myHodler = new MyHodler(view);
            return myHodler;

        } else if (viewType == TYPE1) {
            View view02 = View.inflate(context, R.layout.item02, null);
            MyHodler02 myHodler02 = new MyHodler02(view02);
            return myHodler02;

        }

        return null;

    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHodler) {
            MyHodler myHodler = (MyHodler) holder;
            myHodler.tv.setText(list.get(position).getTitle());
            String images = list.get(position).getImages();
            String img = images.split("\\|")[0];
            Uri uri = Uri.parse(img);
            myHodler.draw.setImageURI(uri);

        } else if (holder instanceof MyHodler02) {
            MyHodler02 myHodler02 = (MyHodler02) holder;
            myHodler02.item02_tv.setText(list.get(position).getTitle());
            String images = list.get(position).getImages();
            String img = images.split("\\|")[0];
            Uri uri = Uri.parse(img);
            myHodler02.item02_draw.setImageURI(uri);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE0;
        } else {
            return TYPE1;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyHodler extends XRecyclerView.ViewHolder {


        private final SimpleDraweeView draw;
        private final TextView tv;

        public MyHodler(View itemView) {
            super(itemView);
            draw = itemView.findViewById(R.id.draw);
            tv = itemView.findViewById(R.id.tv);
        }

        public SimpleDraweeView getDraw() {
            return draw;
        }

        public TextView getTv() {
            return tv;
        }
    }

    public class MyHodler02 extends XRecyclerView.ViewHolder  {


        private final SimpleDraweeView item02_draw;
        private final TextView item02_tv;

        public MyHodler02(View itemView) {
            super(itemView);

            item02_draw = itemView.findViewById(R.id.item02_draw);
            item02_tv = itemView.findViewById(R.id.item02_tv);
        }

        public SimpleDraweeView getItem02_draw() {
            return item02_draw;
        }

        public TextView getItem02_tv() {
            return item02_tv;
        }


    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int postion);
    }
    public void setonItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
}
