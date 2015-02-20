package com.example.arkitvora.materialui;

/**
 * Created by arkitvora on 04/02/15.
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

/*created using Android Studio (Beta) 0.8.14
www.101apps.co.za*/

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {




    private ArrayList<PersonData> peopleDataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewEmail;
        TextView textViewLikeCount;
        ImageView imageViewIcon;
        Button likeButton;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewEmail = (TextView) itemView.findViewById(R.id.textViewEmail);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public MyAdapter(ArrayList<PersonData> people) {
        this.peopleDataSet = people;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_layout, parent, false);

        view.setOnClickListener(CardsActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewEmail = holder.textViewEmail;
        ImageView imageView = holder.imageViewIcon;
      // final TextView textViewLikeCount;
        //textViewLikeCount = holder.textViewLikeCount;
        //Button likeButton = holder.likeButton;

        textViewName.setText(peopleDataSet.get(listPosition).getName());
        Log.d("yuwgehjb",peopleDataSet.get(listPosition).getName());
        textViewEmail.setText(peopleDataSet.get(listPosition).getEmail());
        imageView.setImageResource(peopleDataSet.get(listPosition).getImage());
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

    public static void runOnUiThread(Runnable runnable){
        final Handler UIHandler = new Handler(Looper.getMainLooper());
        UIHandler .post(runnable);
    }

    @Override
    public int getItemCount() {
        return peopleDataSet.size();
    }
}

