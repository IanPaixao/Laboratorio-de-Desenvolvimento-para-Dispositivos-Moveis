package br.pucminas.computacao.ldddm.myapplicationfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuFragment extends ListFragment{
    String[] Cidades = new String[] {"Rio Branco","Macapá","Manuas","Belém","Porto Velho","Boa Vista","Palmas","Maceió","Salvador","Fortaleza","São Luis","João Pessoa","Recife","Teresina","Natal","Aracaju","Goiânia","Cuiabá",
            "Campo Grande","Brasília","Belo Horizonte","Rio De Janeiro","São Paulo","Vitória","Curitiba","Porto Alegre","Florianópolis"};


    String[] Capitais = new String[]{" Acre","  Amapá","  Amazonas ","  Pará",
            " Rondônia ","  Roraima ","Tocantins", "Alagoas ","  Bahia ","  Ceará",
            "  Maranhão","  Paraíba","  Pernambuco","  Piauí","  Rio grande do Norte",
            "  Sergipe","  Goiás","  Mato Grosso","  Mato Grosso do Sul", " Distrito Federal",
            "  Minas Gerais","   Rio De Janeiro","   São Paulo","   Espírito Santo","  Paraná","  Rio Grande Do Sul","  Santa Catarina"};



    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, Capitais);
        setListAdapter(adapter);

        return view;

    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        TextFragment txt = (TextFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change(Cidades[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}