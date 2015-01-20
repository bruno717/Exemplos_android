package br.com.dclick.exemploactionbar;

import android.app.Activity;
import android.view.MenuItem;

/**
 * Created by bruno.oliveira on 20/01/2015.
 */
public class ProgressBarMenu {

    public static void atualizar(final Activity activity, final MenuItem menuItem) {
        menuItem.setActionView(R.layout.progress_bar_menu);

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                activity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        menuItem.setActionView(null);
                        menuItem.setIcon(android.R.drawable.ic_menu_rotate);
                    }
                });
            }
        }.start();
    }
}
