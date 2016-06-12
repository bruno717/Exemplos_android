package com.example.bruno.exemplorealm.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.exemplorealm.R;
import com.example.bruno.exemplorealm.models.Guitar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by bruno.oliveira on 6/10/16.
 */
public class ListGuitarAdapter extends RecyclerView.Adapter<ListGuitarAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private RealmResults<Guitar> mGuitars;

    public ListGuitarAdapter(Context context, RealmQuery<Guitar> guitars) {
        mGuitars = guitars.findAll();
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.cell_list_guitar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Guitar guitar = mGuitars.get(position);
        holder.mTextViewName.setText(guitar.getName());
        holder.mTextViewColor.setText(guitar.getColor());

    }

    @Override
    public int getItemCount() {
        return mGuitars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textview_name)
        TextView mTextViewName;
        @BindView(R.id.textview_color)
        TextView mTextViewColor;
        @BindView(R.id.button_remove)
        Button mButtonRemove;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
