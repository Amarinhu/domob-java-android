package com.example.domob;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
/*
public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> {

    private List<Tarefa> tarefaList;

    public TarefaAdapter(List<Tarefa> tarefaList) {
        this.tarefaList = tarefaList;
    }

    @NonNull
    @Override
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarefa, parent, false);
        return new TarefaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {
        Tarefa tarefa = tarefaList.get(position);
        holder.nomeTextView.setText(tarefa.getNome());
        holder.observacaoTextView.setText(tarefa.getObservacao());
        holder.dificuldadeTextView.setText(String.valueOf(tarefa.getDificuldade()));
        holder.atributoIdTextView.setText(String.valueOf(tarefa.getAtributoId()));
    }

    @Override
    public int getItemCount() {
        return tarefaList.size();
    }

    public static class TarefaViewHolder extends RecyclerView.ViewHolder {
        TextView nomeTextView, observacaoTextView, dificuldadeTextView, atributoIdTextView;

        public TarefaViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeTextView = itemView.findViewById(R.id.nomeTextView);
            observacaoTextView = itemView.findViewById(R.id.observacaoTextView);
            dificuldadeTextView = itemView.findViewById(R.id.dificuldadeTextView);
            atributoIdTextView = itemView.findViewById(R.id.atributoIdTextView);
        }
    }
}
*/