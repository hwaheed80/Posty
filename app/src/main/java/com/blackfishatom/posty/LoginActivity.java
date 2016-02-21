package com.blackfishatom.posty;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class LoginActivity extends BaseActivity {

    private class LoginData {
        public String EmailID;

        public String Password;
    }


    public class LoginTask extends AsyncTask<LoginData, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(LoginData... params) {
            return WebRequest.Process("http://10.0.2.2:8900/api/_user/loginuser", params[0]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void LoginCommand(View obj) {

        EditText emailidtext = (EditText) this.findViewById(R.id.emailid);
        EditText passwordtext = (EditText) this.findViewById(R.id.password);
        LoginData data = new LoginData();
        data.EmailID = emailidtext.getText().toString();
        data.Password = passwordtext.getText().toString();
        LoginTask task = new LoginTask();
        task.execute(data);
        /*
        HttpURLConnection connection = null;
        try
        {
            URL url = new URL("https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=1c677e797eb03c62ac8e14aae3926fbf&format=json&nojsoncallback=1");
            connection = (HttpURLConnection)url.openConnection();
            connection.connect();
            InputStream inputstream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
            String responseline = null;
            StringBuilder reponsebuilder = new StringBuilder();
            while((responseline = reader.readLine()) != null)
            {
                reponsebuilder.append(responseline);
            }

            responseline = reponsebuilder.toString();
            Toast.makeText(this.getApplicationContext(), responseline, Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex)
        {
            Toast.makeText(this.getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        */

    }

    public void RegisterCommand(View obj) {
        Toast.makeText(this.getApplicationContext(), "Register clicked", Toast.LENGTH_SHORT).show();
    }
}
