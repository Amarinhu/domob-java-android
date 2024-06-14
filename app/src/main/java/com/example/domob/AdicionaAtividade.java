package com.example.domob;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionaAtividade extends AppCompatActivity {
    private EditText editTextNome, editTextObservacao, editTextDificuldade, editTextAtributo;
    private Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_atividade);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Adiciona Tarefa");

        editTextNome = findViewById(R.id.editTextNome);
        editTextObservacao = findViewById(R.id.editTextObservacao);
        editTextDificuldade = findViewById(R.id.editTextDificuldade);
        editTextAtributo = findViewById(R.id.editTextAtributo);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString().trim();
                String observacao = editTextObservacao.getText().toString().trim();
                String dificuldade = editTextDificuldade.getText().toString().trim();
                String atributoStr = editTextAtributo.getText().toString().trim();

                if (nome.isEmpty() || dificuldade.isEmpty() || atributoStr.isEmpty()) {
                    Toast.makeText(AdicionaAtividade.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int atributo;
                try {
                    atributo = Integer.parseInt(atributoStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(AdicionaAtividade.this, "ID do atributo deve ser um número.", Toast.LENGTH_SHORT).show();
                    return;
                }

                UsaSQLDB db = new UsaSQLDB(AdicionaAtividade.this);

                db.addTarefa(nome, observacao, dificuldade, atributo);
            }
        });
    }
}
