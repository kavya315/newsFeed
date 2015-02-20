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
 * {@link CardDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CardDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */

public class CardDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static RecyclerView.Adapter cadapter;
    private RecyclerView.LayoutManager layoutManager;
    public static RecyclerView recyclerViewComment;
    private static ArrayList<CommentData> commentarray;
    private static ArrayList<CommentData> commentarray1;
    static View.OnClickListener myOnClickListener;
    static Button.OnClickListener buttonOnClickListener;
    private static ArrayList<Integer> removedItems;
    private static ArrayList<Integer> addedNewItems;
    private static Integer totalfeeds=0;
    private TextView tname;
    private TextView emailtweet;
    public static String nameProfile;
    public static String emailtweetProfile;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static CardDetailsFragment newInstance(String param1, String param2) {
        CardDetailsFragment fragment = new CardDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CardDetailsFragment() {
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
        View rootView= inflater.inflate(R.layout.fragment_card_details, container, false);
        String url = "http://192.168.1.203:3000/tweet_get";
        // getFeedDataJson(url, "fdfd");
        //buttonOnClickListener = new ButtonOnClickListener(this);


        //recycler view for the comment string:
        recyclerViewComment = (RecyclerView)rootView.findViewById(R.id.my_recycler_view_comments);
        tname=(TextView)rootView.findViewById(R.id.textViewName1);
        emailtweet=(TextView)rootView.findViewById(R.id.textViewEmail1);

        tname.setText(nameProfile);
        emailtweet.setText(emailtweetProfile);
        commentarray = new ArrayList<CommentData>();
        for (int i = 0; i < CommentContentData.nameArray.length; i++) {
            Log.d("sadsalistposition",Integer.toString(i));
            commentarray.add(new CommentData(
                    CommentContentData.nameArray[i],
                    CommentContentData.commentArray[i],
                    CommentContentData.drawableArray[i]
                    ));
            Log.d("ooojeikj",commentarray.toString());
        }
        commentarray1 = commentarray;

        // removedItems = new ArrayList<Integer>();



        return rootView;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        layoutManager = new LinearLayoutManager(getActivity());
        Log.d("inonviewcreated","Sdd");
        Log.d("SdeokActivity",layoutManager.toString());
        recyclerViewComment.setHasFixedSize(true);



        recyclerViewComment.setItemAnimator(new DefaultItemAnimator());
        recyclerViewComment.setLayoutManager(layoutManager);



        cadapter = new CommentAdapter(commentarray);
        recyclerViewComment.setAdapter(cadapter);

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

}
