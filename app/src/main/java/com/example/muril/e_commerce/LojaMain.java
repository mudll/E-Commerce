package com.example.muril.e_commerce;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.muril.e_commerce.fragments.ContentMain;
import com.example.muril.e_commerce.util.MeuAdapter;

import java.util.ArrayList;

public class LojaMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView produtosLista;
    private ArrayList<Produtos> produtos;
    private MeuAdapter meuAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loja_main);


        FragmentManager fragMan = getFragmentManager();
        FragmentTransaction fragTran = fragMan.beginTransaction();

        ContentMain fragmain = new ContentMain();
        fragTran.add(R.id.mainfrag, fragmain);
        fragTran.commit();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Abrir Carrinho", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loja_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_logout) {

            finish();
        }
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        String strDepa = null;

        switch (id) {
            case R.id.nav_todo:
                strDepa = null;
                break;
            case R.id.nav_desk:
                strDepa = "Desktop";
                break;
            case R.id.nav_note:
                strDepa = "Notebook";
                break;
            case R.id.nav_aces:
                strDepa = "Acessorios";
                break;
            case R.id.nav_smarP:
                strDepa = "Smartphone";
                break;
            case R.id.nav_smarT:
                strDepa = "Tv";
                break;
            case R.id.nav_came:
                strDepa = "Camera";
                break;
            default:
                break;

        }

        ArrayList<Produtos> prod1 = Produtos.getProdutos();
        produtosLista = (ListView)findViewById(R.id.listProd);

        for (int i = 0; i < prod1.size(); i++) {
            if (strDepa == null) { break; }
            Produtos prod2 = prod1.get(i);
            String prod3 = prod2.prodDepa;
            if(prod3 != strDepa) {
                prod1.remove(prod2);
                i--;
            }
        }

        produtosLista.setAdapter(null);
        meuAdapter = new MeuAdapter(this, prod1);
        produtosLista.setAdapter(meuAdapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
