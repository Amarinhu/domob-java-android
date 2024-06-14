package com.example.domob;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class UsaSQLDB extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "DomoTarefas.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Tarefa";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_OBSERVACAO = "observacao";
    private static final String COLUMN_DIFICULDADE = "dificuldade";
    private static final String COLUMN_ATRIBUTOID = "atributoid";

    public static final String TABLE_NAME_ATT = "Atributo";
    public static final String COLUMN_ID_ATT = "id";
    public static final String COLUMN_NOME_ATT = "nome";
    public static final String COLUMN_XP_ATT = "xp";


    public UsaSQLDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTarefa =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NOME + " TEXT NOT NULL, " +
                        COLUMN_OBSERVACAO + " TEXT, " +
                        COLUMN_DIFICULDADE + " INTEGER, " +
                        COLUMN_ATRIBUTOID + " INTEGER, " +
                        "FOREIGN KEY (" + COLUMN_ATRIBUTOID + ") REFERENCES " + TABLE_NAME_ATT + "(" + COLUMN_ID_ATT + "));";

        String queryAtributo =
                "CREATE TABLE " + TABLE_NAME_ATT + " (" +
                        COLUMN_ID_ATT + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NOME_ATT + " TEXT NOT NULL, " +
                        COLUMN_XP_ATT + " INTEGER);";

        db.execSQL(queryAtributo);
        db.execSQL(queryTarefa);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ATT);
        onCreate(db);
    }

    void addTarefa(String nome, String observacao, String dificuldade, int atributo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NOME, nome);
        cv.put(COLUMN_OBSERVACAO, observacao);
        cv.put(COLUMN_DIFICULDADE, dificuldade);
        cv.put(COLUMN_ATRIBUTOID, atributo);
        long resultado = db.insert(TABLE_NAME, null, cv);
        if (resultado == -1){
            Toast.makeText(context, "Falha em adicionar a DB", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Adicionado com Sucesso", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }



}
