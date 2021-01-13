package com.example.vistasrecicladas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.vistasrecicladas.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
private FragmentFirstBinding mBinding;
private List <String> dataList = new ArrayList<>();

     @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
         mBinding = FragmentFirstBinding.inflate(inflater,container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // instancisomos el adapter y le pasamos el listado de datos con el metodo setdata.
        WordAdapter adapter =  new WordAdapter(setData());
        // le pasamos el adapter al  recycler view
        mBinding.recyclerView.setAdapter(adapter);
        // le indicamos al RV como mostrar los elementos, podria >GridLayout o StaggeredLayout.
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mBinding.fab2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void OnClick(View v){
                //añado una palabra al listado
                dataList.add("palabra. "+ dataList.size());
                //notificar al adaptador que ingresamos datos
             mBinding.recyclerView.getAdapter().notifyItemInserted(dataList.size());
             //scroll al final de la lista.
            mBinding.recyclerView.smoothScrollToPosition(dataList.size());


            }
        };
    }
        private List<String> setData () {
            for (int i = 0; i  < 100; i++) {
            dataList.add("palabra : " + i);
            }
            return dataList;
        }

}