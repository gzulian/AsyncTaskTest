package com.example.root.asynctask;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.root.asynctask.DAO.MascotaDAO;
import com.example.root.asynctask.adapter.MascotaAdapter;

import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment {


    public MascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_mascotas,container,false);
        RecyclerView recycler = view.findViewById(R.id.recycler_mascota);
        try{
        // Inflate the layout for this fragment
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        MascotaDAO  dao = new MascotaDAO(getActivity());

        recycler.setLayoutManager(lm);
        recycler.setAdapter(new MascotaAdapter(dao.findAll(),R.layout.item_mascota,getActivity()));


        }catch (Exception ex){
            ex.printStackTrace();
        }
        return view;
    }

}
