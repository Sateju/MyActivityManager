package jjtelechea.netmind.com.myactivitymanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private String textEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button buttonEditText = (Button) findViewById(R.id.okey);
        final EditText editText = (EditText) findViewById(R.id.edit_text_central);

        buttonEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textEditText = editText.getText().toString();
                //Toast.makeText(getApplicationContext(),textEditText,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                intent.putExtra("Text",textEditText);
                startActivity(intent);
                finish();
            }
        });

    }
}
