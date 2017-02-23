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
import mx.edu.utng.orders.model.Replies;


public class RepliesAdapter extends RecyclerView.Adapter <RepliesAdapter.RepliesViewHolder>
        implements View.OnClickListener {

    List<Replies> replies;
    View.OnClickListener listener;
    //Constructor
    public RepliesAdapter(List<Replies> replies){
        this.replies=replies;
    }
//getter and setter de listener
    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RepliesAdapter.RepliesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       //se inflael cardview al reciclerview
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_replies_layout,parent,false);
        RepliesViewHolder holder=new RepliesViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RepliesAdapter.RepliesViewHolder holder, int position) {
        holder.tvReplyContent.setText(replies.get(position).getReplyContent());
        holder.tvReplyDate.setText(replies.get(position).getReplyDate());
        holder.iv_replies.setImageResource(R.mipmap.ic_launcher);
        holder.setListener(this);

    }

    @Override
    public int getItemCount() {
        return replies.size();
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    public static class RepliesViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cvReplies;
        TextView tvReplyContent;
        TextView tvReplyDate;
        ImageView iv_replies;
        ImageButton btEditReplies;
        ImageButton btDeleteReplies;
        View.OnClickListener listener;




        public RepliesViewHolder(View itemView) {
            super(itemView);
            cvReplies=(CardView)itemView.findViewById(R.id.cv_replies);
            iv_replies=(ImageView)itemView.findViewById(R.id.iv_replies);
            tvReplyContent=(TextView)itemView.findViewById(R.id.tv_reply_content);
            tvReplyDate=(TextView)itemView.findViewById(R.id.tv_reply_date);
            btEditReplies=(ImageButton) itemView.findViewById(R.id.bt_edit_replies);
            btDeleteReplies=(ImageButton) itemView.findViewById(R.id.bt_delete_replies);
            btEditReplies.setOnClickListener(this);
            btDeleteReplies.setOnClickListener(this);


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
