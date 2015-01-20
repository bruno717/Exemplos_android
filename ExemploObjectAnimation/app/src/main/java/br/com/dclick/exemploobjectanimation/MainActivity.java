package br.com.dclick.exemploobjectanimation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

    private boolean flag = true;
    private Button botaoXml, botaoApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoApi = (Button) findViewById(R.id.botao_api);
        botaoXml = (Button) findViewById(R.id.botao_xml);

        botaoApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efeitoAPI(v);
            }
        });
    }

    public void efeitoAPI(View view) {
        ImageView img = (ImageView) findViewById(R.id.img);

        ObjectAnimator anim = ObjectAnimator.ofFloat(img, "alpha", 1f, 0f);

        if (flag) {
            anim.start();
        } else {
            anim.reverse();
        }
        flag = !flag;

    }

}
