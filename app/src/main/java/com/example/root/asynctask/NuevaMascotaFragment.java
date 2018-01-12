package com.example.root.asynctask;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.root.asynctask.DAO.MascotaDAO;
import com.example.root.asynctask.model.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class NuevaMascotaFragment extends Fragment {

    private EditText txtNombre,txtRaza,txtPeso;
    private Spinner  txtGenero;
    private Button bt;



    public NuevaMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nueva_mascota, container, false);

        txtNombre = view.findViewById(R.id.txtNuevoNombre);
        txtRaza= view.findViewById(R.id.txtNuevoRaza);
        txtPeso= view.findViewById(R.id.txtNuevoPeso);
        txtGenero  = view.findViewById(R.id.txtNuevoGenero);
        bt = view.findViewById(R.id.guardar);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarMascota();
            }
        });



        // Inflate the layout for this fragment
        return view;
    }
    public void guardarMascota(){
        MascotaDAO dao = new MascotaDAO(getActivity());
        Mascota m = new Mascota();
        m.setNombre(txtNombre.getText().toString());
        m.setRaza(txtRaza.getText().toString());
        m.setGenero(txtGenero.getSelectedItem().toString());
        m.setPeso(Float.parseFloat(txtPeso.getText().toString()));
        dao.save(m);
        Log.e("INFO","TAM"+dao.findAll().size());
    }


}
