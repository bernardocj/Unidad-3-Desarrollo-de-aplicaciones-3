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

import mx.edu.utng.orders.adapters.RepliesAdapter;
import mx.edu.utng.orders.model.Replies;
import mx.edu.utng.orders.sqlite.DBOperations;

public class RepliesActivity extends AppCompatActivity {
    private EditText etRepliesContent;
    private EditText etRepliesDate;
    private Button btSaveReplies;
private DBOperations operations;
    private Replies replie = new Replies();
    private RecyclerView rvReplies;
   private  List<Replies> replies=new ArrayList<>();
private RepliesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replies);
       //iniciacion de la isntancia
        operations=DBOperations.getDBOperations(getApplicationContext());
        replie.setReplyId("");


        initComponents();
    }
    private void initComponents(){
        rvReplies=(RecyclerView)findViewById(R.id.rv_replies_list);
        rvReplies.setHasFixedSize(true);
        LinearLayoutManager layoutManeger=new LinearLayoutManager(this);
        rvReplies.setLayoutManager(layoutManeger);
        //
       getReplies();
        adapter=new RepliesAdapter(replies);

        adapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt_delete_replies:
                        operations.deleteReplies(replies.get(rvReplies.getChildPosition((View)v.getParent().getParent())).getReplyId());
                        getReplies();
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.bt_edit_replies:

                        Toast.makeText(getApplicationContext(),"Editar",Toast.LENGTH_SHORT).show();
                        Cursor c = operations.getRepliesById(replies.get(
                                rvReplies.getChildPosition(
                                        (View)v.getParent().getParent())).getReplyId());
                            if (c!=null){
                                if (c.moveToFirst()){
                                    replie = new Replies(c.getString(1),c.getString(2),c.getString(3));
                                }
                                etRepliesContent.setText(replie.getReplyContent());
                                etRepliesDate.setText(replie.getReplyDate());

                            }else{
                                Toast.makeText(getApplicationContext(),"Registro no encontrado",Toast.LENGTH_SHORT).show();
                            }
                        break;
                }

            }
        });
        rvReplies.setAdapter(adapter);

        etRepliesContent=(EditText)findViewById(R.id.et_reply_content);
        etRepliesDate=(EditText)findViewById(R.id.et_reply_date);


        btSaveReplies=(Button)findViewById(R.id.bt_save_replies);

        btSaveReplies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!replie.getReplyId().equals("")){
                    replie.setReplyContent(etRepliesContent.getText().toString());
                    replie.setReplyDate(etRepliesDate.getText().toString());
                    operations.updateReplies(replie);

                }else {
                    replie = new Replies("", etRepliesContent.getText().toString(),etRepliesDate.getText().toString() );
                    operations.insertReplies(replie);
                }
                getReplies();
                clearData();
                adapter.notifyDataSetChanged();
            }
        });

    }
    private void getReplies(){
        Cursor c =operations.getReplies();
        replies.clear();
        if(c!=null){
            while (c.moveToNext()){
                replies.add(new Replies(c.getString(1),c.getString(2),c.getString(3)));
            }
        }

    }

    private void clearData(){
        etRepliesContent.setText("");
        etRepliesDate.setText("");
        replie=null;
        replie= new Replies();
        replie.setReplyId("");
    }
}
