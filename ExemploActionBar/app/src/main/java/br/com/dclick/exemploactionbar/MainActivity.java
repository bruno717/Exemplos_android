package br.com.dclick.exemploactionbar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));

        //TABS
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        /*ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Tab 1");
        tab1.setIcon(R.drawable.ic_launcher);
        tab1.setTabListener(new NavegacaoTabs(new Fragment1()));
        actionBar.addTab(tab1, false);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Tab 2");
        tab2.setTabListener(new NavegacaoTabs(new Fragment2()));
        actionBar.addTab(tab2, false);

        ActionBar.Tab tab3 = actionBar.newTab();
        tab3.setIcon(R.drawable.ic_launcher);
        tab3.setTabListener(new NavegacaoTabs(new Fragment3()));
        actionBar.addTab(tab3, false);

        if (savedInstanceState != null) {
            int indiceTab = savedInstanceState.getInt("indiceTab");
            getSupportActionBar().setSelectedNavigationItem(indiceTab);
        } else {
            getSupportActionBar().setSelectedNavigationItem(0);
        }*/
    }

    private class NavegacaoTabs implements ActionBar.TabListener {

        private Fragment frag;

        public NavegacaoTabs(Fragment frag) {
            this.frag = frag;
        }

        //Método é chamado quando tab é selecionada e mostra tab que esta com o foco atual
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
            fts.replace(R.id.fragmentContainer, frag);
            fts.commit();
        }

        //Método é chamado quando nova tab é selecionada e ele mostra a tab na qual perdeu o foco
        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            getSupportActionBar().setTitle(tab.getText());

            FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
            fts.remove(frag);
            fts.commit();
        }

        //Metodo é chamado quando tab já está selecionada e é clicada novamente
        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            Log.i("Script", "onTabReselected()");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        /*SearchView sv = new SearchView(this);
        sv.setOnQueryTextListener(new SearchFiltro());
        MenuItem menuItem1 = menu.add(0, 0, 0, "Item 1");
        menuItem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menuItem1.setActionView(sv);
        MenuItem menuItem2 = menu.add(0, 1, 1, "Item 2");
        menuItem2.setIcon(android.R.drawable.ic_menu_rotate);//R.drawable.ic_launcher);
        menuItem2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        MenuItem menuItem3 = menu.add(0, 2, 2, "Item 3");
        menuItem3.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        MenuItem menuItem4 = menu.add(0, 3, 3, "Item 4");
        menuItem4.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);*/

        getMenuInflater().inflate(R.menu.menu, menu);

        //Não suportado abaixo da API 11
        //SearchView sv = (SearchView) menu.findItem(R.id.item1).getActionView();
        //sv.setOnQueryTextListener(new SearchFiltro());

        return true;
    }

    private class SearchFiltro implements SearchView.OnQueryTextListener {

        //Metodo envia o texto final digitado pelo usuário
        @Override
        public boolean onQueryTextSubmit(String query) {
            Log.i("Script", "onQueryTextSubmit ->" + query);
            return false;
        }

        //Método chamado toda vez que o usuário digitar ou apagar algum texto na pesquisa
        @Override
        public boolean onQueryTextChange(String newText) {
            Log.i("Script", "onQueryTextChange ->" + newText);
            return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Logo Botão ", Toast.LENGTH_SHORT).show();
                //Retira todas as atividades da pilha e retorna para activity especificada
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            /*case R.id.item1:
                Toast.makeText(this, "Item " + item.getItemId() + 1, Toast.LENGTH_SHORT).show();
                break;*/
            case R.id.item2:
               ProgressBarMenu.atualizar(this, item);
                // Toast.makeText(this, "Item " + item.getItemId() + 1, Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "Item " + item.getItemId() + 1, Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Toast.makeText(this, "Item " + item.getItemId() + 1, Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

   /* @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Logo Botão ", Toast.LENGTH_SHORT).show();
                //Retira todas as atividades da pilha e retorna para activity especificada
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.item1:
                Toast.makeText(this, "Item " + item.getItemId() + 1, Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "Item " + item.getItemId() + 1, Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "Item " + item.getItemId() + 1, Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Toast.makeText(this, "Item " + item.getItemId() + 1, Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }*/

   /* @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("indiceTab", getSupportActionBar().getSelectedNavigationIndex());
    }*/
}