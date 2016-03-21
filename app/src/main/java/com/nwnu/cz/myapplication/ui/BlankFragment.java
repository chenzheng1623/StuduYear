package com.nwnu.cz.myapplication.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nwnu.cz.myapplication.R;
import com.nwnu.cz.myapplication.modle.Gradge;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "chas";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private TextView viewById;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
         viewById = (TextView) inflate.findViewById(R.id.gradge);

        return inflate;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        OkHttpClient client = new OkHttpClient();

        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("stid",  getActivity().getSharedPreferences("cookie", getActivity().MODE_PRIVATE).getString("id", null));

        Log.i(TAG, "onCreate: " +  getActivity().getSharedPreferences("cookie", getActivity().MODE_PRIVATE).getString("id", null));
        Log.i(TAG, "onCreate: " +  getActivity().getSharedPreferences("cookie", getActivity().MODE_PRIVATE).getString("cookie", null));

        Request build = new Request.Builder()
                .url("http://210.26.111.34/result/stqryResult/view.do")
                .post(builder.build())
                .header("Cookie",  getActivity().getSharedPreferences("cookie", getActivity().MODE_PRIVATE).getString("cookie", null))
                .build();

        Headers headers = build.headers();
        Log.i(TAG, "onFailure: " + headers.toString());

        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }
            @Override
            public void onResponse(Response response) throws IOException {

                String result = response.body().string();
                Log.i(TAG, "onResponse: " + result);
                try {
                    JSONObject object = new JSONObject(result);
                    JSONArray rows = object.getJSONArray("rows");
                    Gson gson = new Gson();
                    List<Gradge> lists = gson.fromJson(rows.toString(), new TypeToken<List<Gradge>>() {
                    }.getType());
                    for (final Gradge g : lists) {
                        Log.i(TAG, "onResponse: " + g.toString());
                        viewById.post(new Runnable() {
                            @Override
                            public void run() {
                                viewById.append(g.toString());
                            }
                        });
                    }
                } catch (JSONException e) {
                    Log.i(TAG, "onResponse: " + e.toString());
                }
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

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
        void onFragmentInteraction(Uri uri);
    }
}
