package com.example.chris.strokere;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Settings extends BaseActivity {

    /**
     * Settings
     *
     * <P>Extends AppCompatActivity to include navbar methods. Every class that uses the navbar
     * needs to extend this.
     *
     * @author Sam Ward
     */

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupNavbar();
        context = getApplicationContext();


        Button btnThisApp = (Button) findViewById(R.id.btnThisAppS);
        btnThisApp.setTypeface(FontHelper.getLatoRegular(getApplicationContext()));

        Button btnWorkPref = (Button) findViewById(R.id.btnWorkPrefS);
        btnWorkPref.setTypeface(FontHelper.getLatoRegular(getApplicationContext()));

        Button btnWorkRem = (Button) findViewById(R.id.btnWorkRemS);
        btnWorkRem.setTypeface(FontHelper.getLatoRegular(getApplicationContext()));
        btnWorkRem.setAlpha(0.5f);

        Button btnAccount = (Button) findViewById(R.id.btnAccountS);
        btnAccount.setTypeface(FontHelper.getLatoRegular(getApplicationContext()));

    }

    //Tells the toolbar which acitvity it is being used in
    @Override
    public int getLayout() {
        return R.layout.activity_settings;
    }


    //Methods to open the activities each button leads to
    public void openThisApp(View view) {
        startActivity(new Intent(Settings.this, Account.class));
    }

    public void openWorkPref(View view) {
        startActivity(new Intent(Settings.this, Account.class));
    }

    public void openWorkRem(View view) {
        Toast.makeText(context, "Coming soon!", Toast.LENGTH_SHORT).show();
    }

    public void openAccount(View view) {

        startActivity(new Intent(Settings.this, Account.class));
    }


}

