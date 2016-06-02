package com.grayraven.ectest4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button mLoginBtn;
    Button mReadBtn;
    Button mPush;
    Firebase mRef;
    private AuthData mAuthData;
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://ectest4.firebaseio.com");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onCreate - OnDataChange");
               /* Map<String, Object> map = (HashMap<String, Object>) dataSnapshot.getValue();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    Log.d(TAG, "Key: " + key + " - Value: " + value);
                }*/
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.d(TAG, "canceled");
            }
        });

        mLoginBtn = (Button)findViewById(R.id.log_in_btn);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mRef.authWithPassword("jim@grayraven.com", "aaaaaaaa", new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        Log.d(TAG, "WE'RE IN!!!!!!");
                        mAuthData = authData;
                    }

                    @Override
                    public void onAuthenticationError(FirebaseError error) {
                        Log.e(TAG, "Pooooo: " + error.getDetails());
                    }
                });
            }
        });

        mReadBtn = (Button)findViewById(R.id.read_data);
        mReadBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "Read data clicked");
                ReadHistoricData();
                //ReadHistoricalData2();
            }
        });

        mPush = (Button)findViewById(R.id.push_data);
        mPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase childRef = mRef.child("states");
                childRef.child("ZZ").setValue(0);
                childRef.child("TX").setValue(50);
                childRef.child("AK").setValue(3);
            }
        });
    }




    private void ReadHistoricData() {
        final Query queryRef = mRef.child("states");
        Log.d(TAG, "query path: " + queryRef.getPath());
        queryRef.orderByKey();
        Log.d(TAG, "Order by key");
        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String s) {
                 Log.d(TAG, "Child value:" + snapshot.getKey() + " - " + snapshot.getValue());


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.d(TAG, "onChildChanged");
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRef.unauth();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        if (this.mAuthData != null) {
            /* logout of Firebase */
            mRef.unauth();
           /* *//* Logout of any of the Frameworks. This step is optional, but ensures the user is not logged into
             * Facebook/Google+ after logging out of Firebase. *//*
            if (this.mAuthData.getProvider().equals("facebook")) {
                *//* Logout from Facebook *//*
                LoginManager.getInstance().logOut();
            } else if (this.mAuthData.getProvider().equals("google")) {
                *//* Logout from Google+ *//*
                if (mGoogleApiClient.isConnected()) {
                    Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
                    mGoogleApiClient.disconnect();
                }
            }*/
            /* Update authenticated user and show login buttons */
        }
    }
}
