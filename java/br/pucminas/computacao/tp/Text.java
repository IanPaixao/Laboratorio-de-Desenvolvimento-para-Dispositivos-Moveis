package br.pucminas.computacao.tp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.pucminas.computacao.tp.R;

public class Text extends Fragment{
    TextView text,vers;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_fragment, container, false);
        text = (TextView)view.findViewById(R.id.AndroidOs);
        //vers = (TextView)view.findViewById(R.id.Version);
        return view;
    }// End onCreateView()

    public void change(String txt){
        text.setText(txt);
        //vers.setText(txt1);
    }// End change()
}// End class Texto
