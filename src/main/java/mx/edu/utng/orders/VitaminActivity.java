package mx.edu.utng.orders;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.orders.adapters.VitaminAdapter;
import mx.edu.utng.orders.model.Vitamin;
import mx.edu.utng.orders.sqlite.DBOperations;

/**
 * Created by miPC on 22/02/2017.
 */
public class VitaminActivity extends AppCompatActivity {
    private EditText etNameVitamin;
    private EditText etPriceVitamin;
    private EditText etTypeVitamin;
    private EditText etDoseVitamin;
    private Button btSaveVitamin;
    private DBOperations operations;
    private Vitamin vitamin = new Vitamin();
    private RecyclerView rvVitamins;
    private List<Vitamin> vitamins=new ArrayList<Vitamin>();
    private VitaminAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin);
        //iniciacion de la isntancia
        operations=DBOperations.getDBOperations(getApplicationContext());
        vitamin.setIdVitamin("");


        initComponents();
    }
    private void initComponents(){
        rvVitamins=(RecyclerView)findViewById(R.id.rv_vitamin_list);
        rvVitamins.setHasFixedSize(true);
        LinearLayoutManager layoutManeger=new LinearLayoutManager(this);
        rvVitamins.setLayoutManager(layoutManeger);
        //
        getVitamins();
        adapter=new VitaminAdapter(vitamins);

        adapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt_delete_vitamin:
                        operations.deleteVitamin(vitamins.get(rvVitamins.getChildPosition((View)v.getParent().getParent())).getIdVitamin());
                        getVitamins();
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.bt_edit_vitamin:

                        Toast.makeText(getApplicationContext(),"Editar",Toast.LENGTH_SHORT).show();
                        Cursor c = operations.getProductById(vitamins.get(
                                rvVitamins.getChildPosition(
                                        (View)v.getParent().getParent())).getIdVitamin());
                        if (c!=null){
                            if (c.moveToFirst()){
                                vitamin = new Vitamin(c.getString(1),c.getString(2),c.getFloat(3),c.getFloat(4),c.getString(5));
                            }
                            etNameVitamin.setText(vitamin.getNameVitamin());
                            etDoseVitamin.setText(String.valueOf(vitamin.getDoseVitamin()));
                            etPriceVitamin.setText(String.valueOf(vitamin.getPriceVitamin()));
                            etTypeVitamin.setText(vitamin.getTypeVitamin());
                        }else{
                            Toast.makeText(getApplicationContext(),"Registro no encontrado",Toast.LENGTH_SHORT).show();
                        }
                        break;
                }

            }
        });
        rvVitamins.setAdapter(adapter);

        etNameVitamin=(EditText)findViewById(R.id.et_vitamin_name);
        etDoseVitamin=(EditText)findViewById(R.id.et_dose_vitamin);
        etPriceVitamin=(EditText)findViewById(R.id.et_vitamin_price);
        etTypeVitamin=(EditText)findViewById(R.id.et_vitamin_type);

        btSaveVitamin=(Button)findViewById(R.id.bt_save_vitamin);

        btSaveVitamin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!vitamin.getIdVitamin().equals("")){
                    vitamin.setNameVitamin(etNameVitamin.getText().toString());
                    vitamin.setDoseVitamin(Float.parseFloat(etDoseVitamin.getText().toString()));
                    vitamin.setPriceVitamin(Float.parseFloat(etPriceVitamin.getText().toString()));
                    vitamin.setTypeVitamin(etTypeVitamin.getText().toString());
                    operations.updateVitamin(vitamin);

                }else {
                    vitamin = new Vitamin("", etNameVitamin.getText().toString(), Float.parseFloat(etDoseVitamin.getText().toString()),
                            Float.parseFloat(etPriceVitamin.getText().toString())
                            , etTypeVitamin.getText().toString());
                    operations.insertVitamin(vitamin);
                }
                getVitamins();
                clearData();
                adapter.notifyDataSetChanged();
            }
        });

    }
    private void getVitamins(){
        Cursor c =operations.getVitamins();
        vitamins.clear();
        if(c!=null){
            while (c.moveToNext()){
                vitamins.add(new Vitamin(c.getString(1),c.getString(2),c.getFloat(3),c.getFloat(4),c.getString(5)));
            }
        }

    }

    private void clearData(){
        etNameVitamin.setText("");
        etPriceVitamin.setText("");
        etDoseVitamin.setText("");
        etTypeVitamin.setText("");
        vitamin=null;
        vitamin= new Vitamin();
        vitamin.setIdVitamin("");
    }
}