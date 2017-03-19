package iss.medipal.ui.fragments;
import iss.medipal.R;
import iss.medipal.dao.HealthBioDao;
import iss.medipal.dao.impl.HealthBioDaoImpl;
import iss.medipal.model.HealthBio;
import iss.medipal.ui.activities.AddhealthBioActivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HealthBioFragment extends Fragment implements View.OnClickListener{

    private Button addHealthBio;
    private ImageView deleteHealthBio;
    HealthBioDao healthBioDao;
    ListView lv;
    FrameLayout innerLayout;
    List<String> itemname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static HealthBioFragment newInstance() {
        HealthBioFragment fragment = new HealthBioFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.activity_health_bio, container, false);
        lv = (ListView) fragmentView.findViewById(R.id.healthbioList);
        addHealthBio=(Button) fragmentView.findViewById(R.id.addHealthBio);
        addHealthBio.setOnClickListener(this);
        deleteHealthBio = (ImageView)fragmentView.findViewById(R.id.deletebutton);
        deleteHealthBio.setOnClickListener(this);
        return fragmentView;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        healthBioDao = HealthBioDaoImpl.newInstance(getActivity());

        List<HealthBio> healthBioList = healthBioDao.getAllHealthBio();

        if(itemname==null)
        {
            itemname=new ArrayList<>();
        }
        if (!healthBioList.isEmpty()) {
            for (HealthBio hb : healthBioList) {
                itemname.add(hb.getCondition());
            }
        }
        lv.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.healthbio_list_item, R.id.tvNote, itemname));

    }

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_bio);

        addHealthBio=(Button) findViewById(R.id.addHealthBio);
        addHealthBio.setOnClickListener(this);
    }*/

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.addHealthBio:
                Intent intent = new Intent(getActivity(),AddhealthBioActivity.class);
                startActivity(intent);
                break;

           // case R.id.deletebutton:
            //    deleteHealthBio

        }



    }
}
