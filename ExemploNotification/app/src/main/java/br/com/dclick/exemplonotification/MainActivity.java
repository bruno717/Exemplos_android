package br.com.dclick.exemplonotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.botao);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerarNotificacao(v);
            }
        });

    }

    public void gerarNotificacao(View view) {

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //Activity pendente
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, Atividade2.class), 0);

        //Monta a notificação, seus textos e as imagens que aparecerão
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setTicker("Ticker Texto");
        builder.setContentTitle("Título");
        //builder.setContentText("Descrição");
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        //Chama a outra activity quando usuário clicar na notificação
        builder.setContentIntent(pendingIntent);

        //Monta um box para uma descrição de notificação muito grande
        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        String[] descricao = new String[]{"Descrição 1", "Descrição 2", "Descrição 3", "Descrição 4"};

        for (int i = 0; i < descricao.length; i++) {
            style.addLine(descricao[i]);
        }
        builder.setStyle(style);

        //Fazer a notificação
        Notification notification = builder.build();
        //150ms de espera, 300ms de vibração, 150ms de espera, 600ms de vibração
        //notification.vibrate = new long[]{150, 300, 150, 600};
        //fecha notificação quando clicada
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        //enviar a notificação - //"R.drawable.ic_launcher" é o id da notificação
        notificationManager.notify(R.drawable.ic_launcher, notification);

        //Criando o toque da notifição
        try {
            Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone toque = RingtoneManager.getRingtone(this, som);
            toque.play();
        } catch (Exception e) {

        }
    }
}
