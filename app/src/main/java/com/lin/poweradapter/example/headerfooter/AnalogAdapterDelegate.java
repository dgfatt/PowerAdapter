package com.lin.poweradapter.example.headerfooter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lin.poweradapter.AdapterDelegate;
import com.lin.poweradapter.PowerViewHolder;
import com.lin.poweradapter.example.Analog;
import com.lin.poweradapter.example.R;
import com.lin.poweradapter.example.BaseViewHolder;
import com.lin.poweradapter.model.IMulti;

import java.util.List;

import butterknife.BindView;

/**
 * Created by lin18 on 2017/5/2.
 */

public class AnalogAdapterDelegate extends AdapterDelegate<IMulti, PowerViewHolder> {

    @Override
    protected boolean isForViewType(@NonNull IMulti item, int position) {
        return item instanceof Analog;
    }

    @NonNull
    @Override
    protected PowerViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ChildViewHolder(parent, R.layout.analog_item);
    }

    @Override
    protected void onBindViewHolder(@NonNull IMulti item, int position, @NonNull PowerViewHolder holder, @NonNull List<Object> payloads) {
        ChildViewHolder vh = (ChildViewHolder) holder;
        Analog analog = (Analog) item;
        vh.title.setText(analog.text);
        if (analog.resId > 0) {
            vh.icon.setImageResource(analog.resId);
            vh.icon.setVisibility(View.VISIBLE);
        } else {
            vh.icon.setVisibility(View.GONE);
        }
    }

    static class ChildViewHolder extends BaseViewHolder {

        @BindView(android.R.id.icon)
        ImageView icon;
        @BindView(android.R.id.title)
        TextView title;

        ChildViewHolder(@NonNull ViewGroup parent, @LayoutRes int layoutResId) {
            super(parent, layoutResId);
        }

    }

}
