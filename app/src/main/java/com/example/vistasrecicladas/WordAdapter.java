package com.example.vistasrecicladas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vistasrecicladas.databinding.WordItemListBinding;

import java.util.List;
                                //3 extenderde recycler.adapter, pasar el viewholder creado
                                //4 imjplementar los metodos.
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    //1 añadir  una representacio de los datos
    private List<String>mWordList;

    // 8 no olvidar el constructor para pasar el istado de datos al instanciar el adapter
    public WordAdapter(List<String> mWordList) {
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public WordAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 6 Instanciamos viewBindingpara retornar nuestro ViewHolder con esa dependencia
        WordItemListBinding mBinding = WordItemListBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WordViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.WordViewHolder holder, int position) {
        // 7 creamos una variable de referencia del contenido del listado y lo asignamos al elemnto visual que viene en el holder.
        String element = mWordList.get(position);
        holder.textView.setText(element);

    }

    @Override
    public int getItemCount() {
        // 5 indicar la cantidad de datos a mostrar
        return mWordList.size();
    }

                                    //añadir clase interior de viewholder
    public class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public WordViewHolder(@NonNull WordItemListBinding mBinding){
            super(mBinding.getRoot());
            textView = mBinding.textView;
        }

    }
}
