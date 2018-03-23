package com.wanandroid.tomzem.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.base.CommomViewHolder;
import com.wanandroid.tomzem.base.CommonAdapter;
import com.wanandroid.tomzem.base.CustomBaseAdapter;
import com.wanandroid.tomzem.bean.IndexArticle;
import com.wx.goodview.GoodView;

import java.util.List;

/**
 * Created by Administrator on 2018/3/23.
 */

public class IndexArticleAdapter extends CommonAdapter<IndexArticle> {

    private Context mContext;
    public IndexArticleAdapter(List<IndexArticle> list, Context context, int resID) {
        super(list, context, resID);
        this.mContext = context;
    }

    @Override
    public void fillData(int position, CommomViewHolder holder) {
        final GoodView goodView = new GoodView(mContext);
        IndexArticle indexArticle = mDatas.get(position);
        String author = indexArticle.getAuthor()!=null?indexArticle.getAuthor():"佚名";
        String date = indexArticle.getNiceDate()!=null?indexArticle.getNiceDate():"1999-01-01";
        String title = indexArticle.getTitle()!=null?indexArticle.getTitle():"无标题";
        String chapter = indexArticle.getSuperChapterName()!=null?indexArticle.getSuperChapterName():"未分类";

        holder.setText(R.id.tv_author_index, author);
        holder.setText(R.id.tv_date_index, date);
        holder.setText(R.id.tv_title_index, title);
        holder.setText(R.id.tv_chapter_index, chapter);

        final ImageView imageView = holder.getView(R.id.img_zan_index);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodView.setTextInfo("收藏成功",R.color.red_error,13);
                goodView.show(v);
                imageView.setImageResource(R.mipmap.ic_collection_checked);
            }
        });

    }
}
