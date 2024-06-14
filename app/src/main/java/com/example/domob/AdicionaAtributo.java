package com.example.domob;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AdicionaAtributo extends AppCompatActivity {
    private EditText editTextNomeAtt, editTextXpAtt;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_atributo);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Adicionar Atributo");

        editTextNomeAtt = findViewById(R.id.editTextNomeAtt);
        editTextXpAtt = findViewById(R.id.editTextXpAtt);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAtributoToDatabase();
            }
        });
    }

    private void addAtributoToDatabase() {
        String nomeAtt = editTextNomeAtt.getText().toString().trim();
        String xpAttStr = editTextXpAtt.getText().toString().trim();
        int xpAtt = xpAttStr.isEmpty() ? 0 : Integer.parseInt(xpAttStr);
    }
}
