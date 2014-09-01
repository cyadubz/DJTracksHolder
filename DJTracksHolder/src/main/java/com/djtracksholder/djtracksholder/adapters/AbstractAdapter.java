package com.djtracksholder.djtracksholder.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.AbstractItem;

import java.util.Collections;
import java.util.List;

/**
 * Created by Вадим on 21.08.2014.
 */
public abstract class AbstractAdapter<T extends AbstractItem, H extends AbstractAdapter.ViewHolder> extends BaseAdapter {

    protected int itemViewId;
    protected List<T> items;
    protected Context context;

    public AbstractAdapter(Context context, int resId) {
        this.context = context;
        this.itemViewId = resId;
    }

    public AbstractAdapter(Context context, int resId, List<T> items) {
        this(context, resId);
        setData(items);
    }

    public void setData(List<T> items) {
        this.items = preventNull(items);
        notifyDataSetChanged();
    }

    protected List<T> getData() {
        return this.items;
    }

    private List<T> preventNull(final List<T> items) {
        return items == null ? Collections.<T>emptyList() : items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public T getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final H viewHolder = getHolder(convertView, parent);
        viewHolder.setPosition(position);
        bindView(viewHolder, getItem(position));
        return viewHolder.view;
    }

    private H getHolder(View convertView, ViewGroup parent) {
        if (convertView == null) {
            final View view = LayoutInflater.from(this.context).inflate(itemViewId, parent, false);
            return createHolder(view);
        } else {
            return (H) convertView.getTag();
        }
    }

    protected abstract void bindView(H viewHolder, T item);
    protected abstract H createHolder(final View view);

    public static class ViewHolder {
        public final View view;
        protected int position;

        public ViewHolder(final View view) {
            this.view = view;
            view.setTag(this);
        }

        protected void setPosition(int position) {
            this.position = position;
        }

        public int getPosition() {
            return this.position;
        }

        public <T extends View> T get(int resId) {
            return (T) view.findViewById(resId);
        }
    }
}
