package com.example.arkitvora.materialui;

/**
 * Created by kavyajain on 20/02/15.
 */
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder1> {
    private ArrayList<CommentData> commentDataset;

    public static class MyViewHolder1 extends RecyclerView.ViewHolder {

        TextView textViewName1com;
        TextView textViewEmail1com;

        ImageView imageViewIcon1com;


        public MyViewHolder1(View itemView) {
            super(itemView);
            this.textViewName1com = (TextView) itemView.findViewById(R.id.textViewNamecom);
          //((TextView) itemView.findViewById(R.id.textViewNamecom)).setText("this is what i am setting");
            this.textViewEmail1com = (TextView) itemView.findViewById(R.id.textViewEmailcom);
            this.imageViewIcon1com = (ImageView) itemView.findViewById(R.id.imageViewcom);
        }
    }

    public CommentAdapter(ArrayList<CommentData> comments) {
        this.commentDataset = comments;
    }

    @Override
    public MyViewHolder1 onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.commentbox, parent, false);

        view.setOnClickListener(CardsActivity.myOnClickListener);
        Log.d("viewholder","sdsd");
        MyViewHolder1 myViewHolder1 = new MyViewHolder1(view);
        return myViewHolder1;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder1 holder, final int listPosition) {

        TextView textViewName1 = holder.textViewName1com;
        TextView textViewEmail1 = holder.textViewEmail1com;
        ImageView imageView1 = holder.imageViewIcon1com;
        // final TextView textViewLikeCount;
        //textViewLikeCount = holder.textViewLikeCount;
        //Button likeButton = holder.likeButton;
        Log.d("bindviewholder",commentDataset.get(listPosition).toString());
        textViewName1.setText(commentDataset.get(listPosition).getName().toString());
        Log.d("Sdsdsdsauiuyuiww", commentDataset.get(listPosition).getName());
        textViewEmail1.setText(commentDataset.get(listPosition).getText());
        Log.d("Sdsdsdsauiuyuiww", commentDataset.get(listPosition).getText());
        imageView1.setImageResource(commentDataset.get(listPosition).getimage());

                //Log.d("Sdsdsdsauiuyuiww",commentDataset.get(listPosition).getimage());
        // Log.d(getPackageName(), textViewLikeCount != null ? "lvCountries is not null!" : "lvCountries is null!");
        // textViewLikeCount.setText(Integer.toString(peopleDataSet.get(listPosition).getLikeCount()));
    /*    likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MainActivity obj = new MainActivity();

               // Log.d("selected", Integer.toString(5));
                View viewofparent = (View) view.getParent().getParent().getParent();
                Log.d("object", viewofparent.toString());
               // obj.incrementLikeCount(viewofparent);
               // Log.d("runuithreadoutside", Integer.toString(peopleDataSet.get(listPosition).getLikeCount()));

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      //  obj.adapter = new MyAdapter(peopleDataSet);

                       // Log.d("runuithread", Integer.toString(peopleDataSet.get(listPosition).getLikeCount()));

                        textViewLikeCount.setText(Integer.toString(peopleDataSet.get(listPosition).getLikeCount()));
                    }
                });
               // textViewLikeCount.setText(Integer.toString(peopleDataSet.get(listPosition).getLikeCount()));
              //  Log.d("final", textViewLikeCount.getText().toString());


            }
        }); */
        //    Log.e("TAg", textViewLikeCount.getText().toString());

    }

    public static void runOnUiThread(Runnable runnable) {
        final Handler UIHandler = new Handler(Looper.getMainLooper());
        UIHandler.post(runnable);
    }

    @Override
    public int getItemCount() {
        return commentDataset.size();
    }
}