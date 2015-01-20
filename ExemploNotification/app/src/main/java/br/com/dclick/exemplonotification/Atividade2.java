package br.com.dclick.exemplonotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by bruno.oliveira on 16/01/2015.
 */
public class Atividade2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade2);

        /*
        //destroy a notificação
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        //"R.drawable.ic_launcher" é o id da notificação, ja que ele retorna um inteiro
        notificationManager.cancel(R.drawable.ic_launcher);
        */
    }
}
