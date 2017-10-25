package com.bawei.zhoukao2.view;

import com.bawei.zhoukao2.bean.Qbean;

/**
 * Created by Administrator on 2017/10/16.
 */

public interface MainActivityViewListener {
    public void callBackSuccess(Qbean qbean);
    public void callBackFailure(int code);

}
