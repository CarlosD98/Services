package com.example.alumno.services;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import java.net.URL;

public class HelloService extends Service {
    private static final String TAG = "HelloService";

    private boolean isRunning  = false;

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");

        isRunning = true;
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "ServiceOnStartCom");

        new Thread(new Runnable() {
            @Override
            public void run() {


                //Your logic that service will perform will be placed here
                //In this example we are just looping and waits for 1000 milliseconds in each loop.
                DownloaderAsync DownTask = new DownloaderAsync();
                DownTask.execute();


                //Stop service once it finishes its task
                stopSelf();
            }
        }).start();

        return Service.START_STICKY;


    }

    @Override
    public void onDestroy() {
        isRunning = false;
        Log.d(TAG, "ServiceonDest");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "Service onBind");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public class DownloaderAsync extends AsyncTask<URL,Integer,String>{
        @Override
        protected void onPreExecute() {
            Log.i(TAG,"OnPre" );
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG,"OnProgress" );
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(URL... urls) {
            Log.i(TAG,"DoInBack" );
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.i(TAG,"EXEcute" );
            super.onPostExecute(s);
        }
    }
}
