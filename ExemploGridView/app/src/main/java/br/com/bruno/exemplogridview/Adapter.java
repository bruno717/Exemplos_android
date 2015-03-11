package br.com.bruno.exemplogridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Bruno on 23/02/2015.
 */
public class Adapter extends BaseAdapter {

    private Context context;
    private int[] lista;

    public Adapter(Context context, int[] lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int position) {
        return lista[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ImageView imageView = new ImageView(context);
        imageView.setImageResource(lista[position]);
        imageView.setAdjustViewBounds(true);

        return imageView;
    }
}
