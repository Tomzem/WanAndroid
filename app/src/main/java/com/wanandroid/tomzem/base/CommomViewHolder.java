package com.wanandroid.tomzem.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2018/3/23.
 */

public class CommomViewHolder {

    private final View mContentView;

    private SparseArray<View> mSparseArray = new SparseArray<>();

    private Context mContext;

    public CommomViewHolder(Context context, int resID) {
        mContext = context;
        mContentView = LayoutInflater.from(context).inflate(resID, null);
        mContentView.setTag(this);
    }

    public View getContentView() {
        return mContentView;
    }

    public static CommomViewHolder getHolder(Context context, View convertView, int resID) {
        CommomViewHolder holder = null;
        if(convertView == null){
            holder = new CommomViewHolder(context, resID);
        } else {
            holder = (CommomViewHolder) convertView.getTag();
        }
        return holder;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入mSparseArray
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int id) {
        View view = mSparseArray.get(id);
        if (view == null) {
            view = mContentView.findViewById(id);
            mSparseArray.append(id, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置数据
     *
     * @param id
     * @param text
     * @return
     */
    public CommomViewHolder setText(int id, String text) {
        TextView view = getView(id);
        view.setText(Html.fromHtml(text));
        return this;
    }

    public CommomViewHolder setImageByUrl(int id, String url) {
        ImageView view = getView(id);
        Glide.with(mContext).load(url).into(view);
        return this;
    }

    public CommomViewHolder setImageResource(int id, int resId) {
        ImageView view = getView(id);
        view.setImageResource(resId);
        return this;
    }

    public CommomViewHolder setImageBitmap(int id, Bitmap bitmap) {
        ImageView view = getView(id);
        view.setImageBitmap(bitmap);
        return this;
    }
}
