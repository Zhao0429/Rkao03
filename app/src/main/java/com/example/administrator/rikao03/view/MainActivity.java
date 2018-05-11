package com.example.administrator.rikao03.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.rikao03.R;
import com.example.administrator.rikao03.model.GoodsBean;
import com.example.administrator.rikao03.model.IModelImpl;
import com.example.administrator.rikao03.model.MyAdapter;
import com.example.administrator.rikao03.presenter.IPresneterImpl;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView{
    private Handler handler=new Handler();
    private XRecyclerView xrecyc;
    private static final String TAG = "MainActivity";
    private int pscid=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IPresneterImpl iPresneter=new IPresneterImpl();
        iPresneter.GetDate(new IModelImpl(iPresneter),this);
        xrecyc = findViewById(R.id.xrecyc);
        xrecyc.setLayoutManager(new LinearLayoutManager(this));
        xrecyc.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.this.pscid=1;
                        IPresneterImpl iPresneter=new IPresneterImpl();
                        iPresneter.GetDate(new IModelImpl(iPresneter),MainActivity.this);
                        xrecyc.refreshComplete();
                    }
                },1000);

            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.this.pscid++;
                        IPresneterImpl iPresneter=new IPresneterImpl();
                        iPresneter.GetDate(new IModelImpl(iPresneter),MainActivity.this);
                        xrecyc.loadMoreComplete();
                    }
                },1000);

            }
        });
    }

    @Override
    public void ShowGoods(List<GoodsBean.DataBean> list) {
        Log.d(TAG, "ShowGoods: "+list.size());
        MyAdapter myAdapter=new MyAdapter(list,MainActivity.this);
        xrecyc.setAdapter(myAdapter);
        myAdapter.setonItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(MainActivity.this, postion+"", Toast.LENGTH_LONG).show();            }
        });
    }

    @Override
    public int pscid() {
        return MainActivity.this.pscid;
    }
}
