package br.com.bruno.exemplogridview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] lista = new int[]{R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher
                , R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher
                , R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher
                , R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher
                , R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher
                , R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher
                , R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new Adapter(this, lista));

    }

}
