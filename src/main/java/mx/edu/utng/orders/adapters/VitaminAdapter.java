package mx.edu.utng.orders.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mx.edu.utng.orders.R;
import mx.edu.utng.orders.model.Vitamin;


public class VitaminAdapter extends RecyclerView.Adapter <VitaminAdapter.VitaminViewHolder>
        implements View.OnClickListener {

    List<Vitamin> vitamins;
    View.OnClickListener listener;
    //Constructor
    public VitaminAdapter(List<Vitamin> vitamins){
        this.vitamins=vitamins;
    }
//getter and setter de listener
    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public VitaminAdapter.VitaminViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       //se inflael cardview al reciclerview
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vitamin_layout,parent,false);
        VitaminViewHolder holder=new VitaminViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(VitaminAdapter.VitaminViewHolder holder, int position) {
        holder.tvVitaminName.setText(vitamins.get(position).getNameVitamin());
        holder.tvVitaminDose.setText(String.valueOf(vitamins.get(position).getDoseVitamin()));
        holder.tvVitaminPrice.setText(String.valueOf(vitamins.get(position).getPriceVitamin()));
        holder.tvVitaminType.setText(String.valueOf(vitamins.get(position).getTypeVitamin()));
        holder.iv_Vitamin.setImageResource(R.mipmap.ic_launcher);
        holder.setListener(this);

    }

    @Override
    public int getItemCount() {
        return vitamins.size();
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    public static class VitaminViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cvVitamin;
        TextView tvVitaminName;
        TextView tvVitaminPrice;
        TextView tvVitaminDose;
        TextView tvVitaminType;
        ImageView iv_Vitamin;
        ImageButton btEditVitamin;
        ImageButton btDeleteVitamin;
        View.OnClickListener listener;




        public VitaminViewHolder(View itemView) {
            super(itemView);
            cvVitamin=(CardView)itemView.findViewById(R.id.cv_vitamin);
            iv_Vitamin=(ImageView)itemView.findViewById(R.id.iv_vitamin);
            tvVitaminName=(TextView)itemView.findViewById(R.id.tv_vitamin_name);
            tvVitaminPrice=(TextView)itemView.findViewById(R.id.tv_vitamin_name);
            tvVitaminDose=(TextView)itemView.findViewById(R.id.tv_vitamin_dose);
            tvVitaminType=(TextView)itemView.findViewById(R.id.tv_vitamin_type);
            btEditVitamin=(ImageButton) itemView.findViewById(R.id.bt_edit_vitamin);
            btDeleteVitamin=(ImageButton) itemView.findViewById(R.id.bt_delete_vitamin);
            btEditVitamin.setOnClickListener(this);
            btDeleteVitamin.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
       if (listener!=null){
           listener.onClick(v);
       }
        }

        public void setListener(View.OnClickListener listener){
            this.listener=listener;

        }
    }

}
