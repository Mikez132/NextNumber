package com.mike.nextnumber;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.*;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;


public class OddEven extends ActionBarActivity implements OnTouchListener,OnDragListener {

    private final static int MAXNUM = 10;

    private void setNumbers(){

        Button int1 = (Button)findViewById(R.id.int1_Btn);
        Button int2 = (Button)findViewById(R.id.int2_Btn);
        Button int3 = (Button)findViewById(R.id.int3_Btn);

        String int1_S = Integer.toString(GameUtil.genenratenewNumb(MAXNUM));
        String int2_S = Integer.toString(GameUtil.genenratenewNumb(MAXNUM));
        String int3_S = Integer.toString(GameUtil.genenratenewNumb(MAXNUM));

        int1.setText(int1_S);
        int2.setText(int2_S);
        int3.setText(int3_S);

    }
    @Override
    public boolean onDrag(View v,DragEvent e){

        if(e.getAction() == DragEvent.ACTION_DROP){

            View view = (View)e.getLocalState();
            ViewGroup from = (ViewGroup)view.getParent();
            from.removeView(view);
            LinearLayout linLay = (LinearLayout) v;
            linLay.addView(view);
            view.setVisibility(View.VISIBLE);

        }
        return true;


    }
    @Override
    public boolean onTouch(View v,MotionEvent m){
        if(m.getAction() == MotionEvent.ACTION_DOWN) {

            DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null,shadowBuilder,v,0);
            v.setVisibility(View.INVISIBLE);

            return true;

        }
        else{

            return false;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_odd_even);
        Intent intent = getIntent();

        findViewById(R.id.int1_Btn).setOnTouchListener(this);
        findViewById(R.id.int2_Btn).setOnTouchListener(this);
        findViewById(R.id.int3_Btn).setOnTouchListener(this);
        findViewById(R.id.oddbox_Lyt).setOnDragListener(this);
        findViewById(R.id.evenbox_Lyt).setOnDragListener(this);

        setNumbers();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_odd_even, menu);
        return true;
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


}
