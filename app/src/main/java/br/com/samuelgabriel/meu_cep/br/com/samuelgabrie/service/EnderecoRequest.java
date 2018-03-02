package br.com.samuelgabriel.meu_cep.br.com.samuelgabrie.service;

import android.os.AsyncTask;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;

import br.com.samuelgabriel.meu_cep.SignUpActivity;
import br.com.samuelgabriel.meu_cep.br.com.samuelgabriel.modelo.Endereco;

/**
 * Created by Samuel Gabriel on 01/03/2018.
 */

public class EnderecoRequest extends AsyncTask<Void, Void, Endereco> {


    private WeakReference<SignUpActivity> activity;

    public EnderecoRequest( SignUpActivity activity ){
        this.activity = new WeakReference<>( activity );
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        activity.get().lockFields( true );
    }



    @Override
    protected Endereco doInBackground(Void... voids) {

        try{
            String jsonString = JsonRequest.request( activity.get().getUriZipCode() );
            Gson gson = new Gson();

            return gson.fromJson(jsonString, Endereco.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPostExecute(Endereco address) {
        super.onPostExecute(address);


        if( activity.get() != null ){
            activity.get().lockFields( false );

            if( address != null ){
                activity.get().setDataViews( address );
            }
        }
    }

}
