package br.pucminas.computacao.ldddm.trabalhopratico1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_main);

        // data to populate the RecyclerView with
        ArrayList<String> pages = new ArrayList<>();
        pages.add("Facebook Page");
        pages.add("Instagram Page");
        pages.add("LInkedIn Page");
        pages.add("Spotify Page");
        pages.add("Other Page");
        pages.add("Other Page");
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvpages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, pages);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    } //end on create

    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }// en on item click
}// end display

