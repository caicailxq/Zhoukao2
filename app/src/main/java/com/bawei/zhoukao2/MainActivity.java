package com.bawei.zhoukao2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.zhoukao2.bean.Qbean;
import com.bawei.zhoukao2.presenter.MainActivityPresenter;
import com.bawei.zhoukao2.view.MainActivityViewListener;
import com.liaoinstan.springview.container.MeituanFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityViewListener {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private MainActivityPresenter presenter;
    SpringView springview;
    private Iadapter iadapter;
private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainActivityPresenter(this);
        springview=findViewById(R.id.spring);
        presenter.getData(true);
        manager=new LinearLayoutManager(this);
         recycler.setLayoutManager(manager);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        springview.setHeader(new MeituanHeader(this));
        springview.setFooter(new MeituanFooter(this));
        iadapter=new Iadapter(MainActivity.this);
        recycler.setAdapter(iadapter);

        HorizontalDividerItemDecoration horizontalDividerItemDecoration =  new HorizontalDividerItemDecoration.Builder(this)
                .color(Color.RED)
                .build() ;
        recycler.addItemDecoration(horizontalDividerItemDecoration);


        springview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {

                presenter.getData(true);



            }

            @Override
            public void onLoadmore() {
                presenter.getData(true);

            }
        });


    }


    @Override
    public void callBackSuccess(final Qbean qbean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                iadapter.setData(qbean);
                springview.onFinishFreshAndLoad();
            }
        });





    }

    @Override
    public void callBackFailure(int code) {

    }
}
