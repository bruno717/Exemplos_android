package com.example.brunooliveira.exemplorecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.brunooliveira.exemplorecyclerview.R;
import com.example.brunooliveira.exemplorecyclerview.domain.Car;
import com.example.brunooliveira.exemplorecyclerview.interfaces.RecyclerViewOnClickListenerHack;

import java.util.List;

/**
 * Created by bruno.oliveira on 28/08/2015.
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyviewHolder> {
    private List<Car> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public CarAdapter(Context context, List<Car> l) {
        mList = l;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("LOG", "onCreateViewHolder");
        View v = mLayoutInflater.inflate(R.layout.item_car, parent, false);
        MyviewHolder mvh = new MyviewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
        Log.i("LOG", "onBindViewHolder");
        holder.ivCar.setImageResource(mList.get(position).getPhoto());
        holder.tvModel.setText(mList.get(position).getModel());
        holder.tvBrand.setText(mList.get(position).getBrand());

        try {
            YoYo.with(Techniques.Tada)
                    .duration(700)
                    .playOn(holder.itemView);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r) {
        mRecyclerViewOnClickListenerHack = r;
    }

    public void addListItem(Car c, int position) {
        mList.add(c);
        notifyItemInserted(position);
    }

    public void removeListItem(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView ivCar;
        public TextView tvModel;
        public TextView tvBrand;

        public MyviewHolder(View itemView) {
            super(itemView);

            ivCar = (ImageView) itemView.findViewById(R.id.iv_car);
            tvModel = (TextView) itemView.findViewById(R.id.tv_model);
            tvBrand = (TextView) itemView.findViewById(R.id.tv_brand);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mRecyclerViewOnClickListenerHack != null) {
                mRecyclerViewOnClickListenerHack.onClickListener(v, getPosition());
            }
        }
    }


}
