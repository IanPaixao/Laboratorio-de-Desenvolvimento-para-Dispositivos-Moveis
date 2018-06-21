package br.pucminas.computacao.tp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import  android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.pucminas.computacao.tp.R;

import java.util.ArrayList;
import java.util.List;

public class Menu extends ListFragment{

    static List<String> cities = new ArrayList<>(0);
    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_item, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cities);
        setListAdapter(adapter);
        return view;
    }// End onCreateView()

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Text txt = (Text) getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change(cities.get(position));
        getListView().setSelector(android.R.color.holo_blue_dark);
    }// End onListItemClick()
}// End class Menu
