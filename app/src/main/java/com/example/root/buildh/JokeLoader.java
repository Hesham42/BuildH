package com.example.root.buildh;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.root.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by root on 1/25/18.
 */

public class JokeLoader extends AsyncTask <Void,Void,String>{
    private static MyApi myApi = null;
    private Context context;
    ProgressBar progressBar;
    public JokeLoader (Context context,ProgressBar progress){
        this.context = context;
        progressBar = progress;
    }
    @Override
    protected String doInBackground(Void... params) {

        if(myApi == null){

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null)
                    .setRootUrl("http://192.168.1.6:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApi = builder.build();
        }

        try {
            return myApi.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
//        Intent intent = new Intent(context, .class);
//        intent.putExtra("joke",s);
//        context.startActivity(intent);
//        progressBar.setVisibility(View.INVISIBLE);
    }
}