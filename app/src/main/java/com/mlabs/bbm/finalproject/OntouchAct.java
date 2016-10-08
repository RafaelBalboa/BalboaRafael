package com.mlabs.bbm.finalproject;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/**
 * Created by androidstudio on 03/09/16.
 */
public class OntouchAct extends AppCompatActivity{
    float x1, y1 , x2, y2, a, b;
    String msg1 = "", msg2="";
    ImageView imageLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontouch);
        final EditText field1 = (EditText) findViewById(R.id.editText8);
        final EditText field2 = (EditText) findViewById(R.id.editText9);
        final EditText field3 = (EditText) findViewById(R.id.editText10);
        final EditText field4 = (EditText) findViewById(R.id.editText11);
        final EditText field5 = (EditText) findViewById(R.id.editText12);
        field1.setKeyListener(null);
        field2.setKeyListener(null);
        field3.setKeyListener(null);
        field4.setKeyListener(null);
        field5.setKeyListener(null);

        imageLogo = (ImageView) findViewById(R.id.imageView);
        imageLogo.setOnTouchListener(new View.OnTouchListener() {
            float x,y,x1,y1;

            @Override
            public boolean onTouch(View view, MotionEvent e) {

                String actionX = "";
                String actionY = "";
                String quadrant = "";

                switch (e.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = e.getX();
                        y = e.getY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        float X = imageLogo.getRight()/2;
                        float Y = imageLogo.getBottom()/2;

                        x1=e.getX();
                        y1=e.getY();

                        actionX = "";
                        actionY = "";
                        quadrant = "";

                        if (x<x1){
                            actionX = "Swiped right ";
                        }
                        if (x>x1){
                            actionX = "Swiped left. ";
                        }
                        if (y<y1){
                            actionY = "Swiped down. ";
                        }
                        if (y>y1)
                        {
                            actionY = "Swiped up. ";
                        }

                        if(x1>X && y1>Y){
                            quadrant = "Quadrant 4";
                        }
                        if(x1<X && y1>Y){
                            quadrant = "Quadrant 3";
                        }
                        if(x1<X && y1<Y){
                            quadrant = "Quadrant 2";
                        }
                        if(x1>X && y1<Y){
                            quadrant = "Quadrant 1";
                        }

                        field1.setText(x + ", " + y);
                        field2.setText(x1 + ", " + y1);
                        field3.setText(  (Math.abs(x1-x))+", "+ (Math.abs(y1-y)) );

                        field5.setText(actionX + actionY);
                        field4.setText(quadrant);

                }
                return  false;
            }

        });
    }
    }



