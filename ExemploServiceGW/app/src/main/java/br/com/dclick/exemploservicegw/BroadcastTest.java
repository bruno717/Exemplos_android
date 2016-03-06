package br.com.dclick.exemploservicegw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Bruno on 11/03/2015.
 */
public class BroadcastTest extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Script", "onReceive()");
        intent = new Intent("SERVICO_TEST");
        context.startService(intent);
    }
}
