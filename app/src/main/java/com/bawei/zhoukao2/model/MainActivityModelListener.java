package com.bawei.zhoukao2.model;

import com.bawei.zhoukao2.bean.Qbean;

/**
 * Created by Administrator on 2017/10/16.
 */

public interface MainActivityModelListener {
    public void callBackSuccess(Qbean qbean);
    public void callBackFailure(int code);
}
