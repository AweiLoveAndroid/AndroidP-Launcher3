package com.android.launcher3.pageindicators;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.android.launcher3.PagedView;

/**
 * author :  luzhaowei
 * create : 2022/2/25 0025
 * desc   : 自定义分页指示器
 */
public class PageSlideIndicator extends LinearLayout {

    private final static String TAG = PageSlideIndicator.class.getSimpleName();
    //
    // //控件页面滑动，操作PagedView
    // PagedView mPagedView = null;
    //
    // Context mContext;
    //
    // //其他页面标识
    // Drawable mNormalDrawable;
    // //当前页面标识
    // Drawable mFocusDrawable;
    //
    // //总页面数
    // int mTotalPage = 0;
    // //当前页面
    // int mCurPageNum = 0;

    public PageSlideIndicator(Context context) {
        super(context);
    }

    public PageSlideIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PageSlideIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}