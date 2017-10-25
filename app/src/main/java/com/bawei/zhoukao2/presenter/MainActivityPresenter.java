package com.bawei.zhoukao2.presenter;

import com.bawei.zhoukao2.bean.Qbean;
import com.bawei.zhoukao2.model.MainActivityModel;
import com.bawei.zhoukao2.model.MainActivityModelListener;
import com.bawei.zhoukao2.view.MainActivityViewListener;

/**
 * Created by Administrator on 2017/10/16.
 */

public class MainActivityPresenter {
     public MainActivityViewListener mainActivityViewListener;
    public MainActivityModel model;
    public MainActivityPresenter(MainActivityViewListener mainActivityViewListener) {
      this.mainActivityViewListener=mainActivityViewListener;
     this.model=new MainActivityModel();
    }

    public void getData(boolean up){
        model.getData(up, new MainActivityModelListener() {
            @Override
            public void callBackSuccess(Qbean qbean) {
                mainActivityViewListener.callBackSuccess(qbean);
            }

            @Override
            public void callBackFailure(int code) {
                mainActivityViewListener.callBackFailure(code);
            }
        });

    }
}
