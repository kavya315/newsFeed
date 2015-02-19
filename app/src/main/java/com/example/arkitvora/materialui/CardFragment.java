package com.example.arkitvora.materialui;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static RecyclerView recyclerView;
    private static ArrayList<PersonData> people;
    private static ArrayList<PersonData> person;
    static View.OnClickListener myOnClickListener;
    static Button.OnClickListener buttonOnClickListener;
    private static ArrayList<Integer> removedItems;
    private static ArrayList<Integer> addedNewItems;
    private static Integer totalfeeds=0;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardFragment newInstance(String param1, String param2) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_cards, container,
                false);
        myOnClickListener = new MyOnClickListener(getActivity());
        String url = "http://192.168.1.203:3000/tweet_get";
        // getFeedDataJson(url, "fdfd");
        //buttonOnClickListener = new ButtonOnClickListener(this);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.my_recycler_view);


        people = new ArrayList<PersonData>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            people.add(new PersonData(
                    MyData.nameArray[i],
                    MyData.emailArray[i],
                    MyData.drawableArray[i],
                    MyData.id_[i],
                    MyData.tickcount[i]
            ));
        }
        person = people;

       // removedItems = new ArrayList<Integer>();



        return rootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setHasFixedSize(true);



        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);



        adapter = new MyAdapter(people);
        recyclerView.setAdapter(adapter);

        super.onViewCreated(view, savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event






    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            removeItem(v);
        }

        private void removeItem(View v) {
            Log.d("outerObject", v.toString());
            int selectedItemPosition = recyclerView.getChildPosition(v);
            Log.d("selectedItemPosition", Integer.toString(selectedItemPosition));
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName
                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewName);
            String selectedName = (String) textViewName.getText();
            Log.d("selectedItemText", selectedName);
            int selectedItemId = -1;
            for (int i = 0; i < MyData.nameArray.length; i++) {
                if (selectedName.equals(MyData.nameArray[i])) {
                    selectedItemId = MyData.id_[i];
                }
            }
            removedItems.add(selectedItemId);
            people.remove(selectedItemPosition);
            adapter.notifyItemRemoved(selectedItemPosition);

        }
    }


}
