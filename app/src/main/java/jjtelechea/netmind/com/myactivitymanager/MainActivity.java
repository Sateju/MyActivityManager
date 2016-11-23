package jjtelechea.netmind.com.myactivitymanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private String resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.text_view_central);
        Button boton1 = (Button) findViewById(R.id.button_1);
        Button boton2 = (Button) findViewById(R.id.button_2);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);

        Intent resultIntent = getIntent();
        resultText = resultIntent.getStringExtra("Text");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                textView.setText(resultText);
                break;
            case R.id.button_2:
                startActivity(new Intent(this,SecondActivity.class));
                break;
        }
    }
    // GUARDA EL VALOR DEL TEXTO CENTRAL
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("TextCentral",textView.getText().toString());
    }
    // LO VUELVE A METER
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (this.textView != null){
            textView.setText(savedInstanceState.getString("TextCentral"));
        }

    }
}
