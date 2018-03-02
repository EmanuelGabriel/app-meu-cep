package br.com.samuelgabriel.meu_cep.br.com.samuelgabrie.service;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.samuelgabriel.meu_cep.R;
import br.com.samuelgabriel.meu_cep.br.com.samuelgabriel.modelo.Endereco;

/**
 * Created by Samuel Gabriel on 02/03/2018.
 */

public class AddressAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Endereco> addresses;

    public AddressAdapter(Context context, List<Endereco> addresses){
        inflater = LayoutInflater.from(context);
        this.addresses = addresses;
    }

    @Override
    public int getCount() {

        return addresses.size();
    }

    @Override
    public Object getItem(int i) {
        return addresses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if( view == null ){
            view = inflater.inflate(R.layout.address_item, null);
            holder = new ViewHolder();
            view.setTag( holder );
            holder.setViews( view );
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        holder.setData( addresses.get(i) );

        return view;
    }


    private static class ViewHolder{

        TextView tvZipCode;
        TextView tvStreet;
        TextView tvNeighbor;


        private void setViews( View view ){

            tvZipCode = (TextView) view.findViewById(R.id.tv_zip_code);
            tvStreet = (TextView) view.findViewById(R.id.tv_street);
            tvNeighbor = (TextView) view.findViewById(R.id.tv_neighbor);
        }

        private void setData( Endereco endereco){

            tvZipCode.setText( "CEP: " + endereco.getCep() );
            tvStreet.setText( "Rua: " + endereco.getLogradouro() );
            tvNeighbor.setText( "Bairro: " + endereco.getBairro() );
        }

    }



}
