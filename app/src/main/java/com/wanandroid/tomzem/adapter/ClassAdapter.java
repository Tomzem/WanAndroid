package com.wanandroid.tomzem.adapter;


import android.view.View;
import android.widget.ImageView;

import com.wanandroid.tomzem.R;
import com.wanandroid.tomzem.bean.ClassDatas;

import java.util.List;

import iammert.com.expandablelib.ExpandCollapseListener;
import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;

/**
 * Created by Tomzem on 2018/3/24.
 */

public class ClassAdapter{
    private ExpandableLayout mElClassList;
    private Boolean isOpen = false;

    public ClassAdapter(ExpandableLayout mElClassList){
        this.mElClassList = mElClassList;
    }

    public void setData(List<ClassDatas> data){
        if (data == null){
            throw new NullPointerException("ClassAdapter数据源不能为NULL");
        }
        if (data.size() == 0){
            throw new RuntimeException("ClassAdapter数据源size为0");
        }
        for (ClassDatas classDatas : data){
            mElClassList.addSection(getSection(classDatas));
        }
        Listen();
    }

    private Section<ClassDatas, ClassDatas> getSection(ClassDatas classDatas) {
        Section<ClassDatas, ClassDatas> section = new Section<>();
        section.parent = classDatas;
        for(ClassDatas childData : classDatas.getChildren()){
            section.children.add(childData);
        }
        section.expanded = false;
        return section;
    }

    private void Listen(){
        mElClassList.setExpandListener(new ExpandCollapseListener.ExpandListener<ClassDatas>() {
            @Override
            public void onExpanded(int parentIndex, ClassDatas parent, View view) {
                //展开
                ImageView imageView = view.findViewById(R.id.arrow);
                imageView.setBackgroundResource(R.drawable.ic_arrow_up);
                isOpen = !isOpen;
            }
        });

        mElClassList.setCollapseListener(new ExpandCollapseListener.CollapseListener<ClassDatas>() {
            @Override
            public void onCollapsed(int parentIndex, ClassDatas parent, View view) {
                //合并
                ImageView imageView = view.findViewById(R.id.arrow);
                imageView.setBackgroundResource(R.drawable.ic_arrow_down);
                isOpen = !isOpen;
            }
        });
    }


}
