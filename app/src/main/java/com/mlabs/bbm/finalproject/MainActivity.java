package com.mlabs.bbm.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnTouchListener;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn;
    TextView btnSignUp,showpass;
    DatabaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginDataBaseAdapter=new DatabaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();


        btnSignIn=(Button)findViewById(R.id.buttonL);
        btnSignUp=(TextView)findViewById(R.id.signup);
        showpass=(TextView)findViewById(R.id.show);

        // Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent intentSignUP=new Intent(getApplicationContext(),SignUp.class);
                startActivity(intentSignUP);
            }
        });
        final  EditText editTextEmail=(EditText)findViewById(R.id.email);
        final  EditText editTextPassword=(EditText)findViewById(R.id.pass);

        Button btnSignIn=(Button)findViewById(R.id.buttonL);

        // Set On ClickListener
        assert btnSignIn != null;
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String email = editTextEmail.getText().toString();
                String pword = editTextPassword.getText().toString();
                String uname = editTextEmail.getText().toString();

                String savePassword = DatabaseAdapter.getSinlgeEntry(email);
                String umail = DatabaseAdapter.getUsername(uname);




                // check if the Stored password matches with  Password entered by user
                if(pword.equals(savePassword)|pword.equals(umail))
                {
                    Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    Intent intentSignUP=new Intent(getApplicationContext(),OntouchAct.class);
                    startActivity(intentSignUP);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Usernaame or Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showpass.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        editTextPassword.setTransformationMethod(null);
                        break;

                    case MotionEvent.ACTION_UP:
                        editTextPassword.setTransformationMethod(new PasswordTransformationMethod());
                        break;
                }
                return true;
            }
        });

    }
    // Methos to handleClick Event of Sign In Button


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}










