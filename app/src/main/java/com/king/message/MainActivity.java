package com.king.message;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.king.message.fragement.MessageFragment;
import com.king.message.fragement.MineFragment;
import com.king.message.fragement.RelationFragment;
import com.king.message.fragement.ScienceFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;
    @Bind(R.id.message)
    RadioButton message;
    @Bind(R.id.science)
    RadioButton science;
    @Bind(R.id.relation)
    RadioButton relation;
    @Bind(R.id.mine)
    RadioButton mine;
    private ArrayList<Fragment> fragments;
    private MessageFragment messageFragment;
    private ScienceFragment scienceFragment;
    private RelationFragment relationFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        fragments = new ArrayList<>();
        messageFragment = new MessageFragment();
        scienceFragment = new ScienceFragment();
        relationFragment = new RelationFragment();
        mineFragment = new MineFragment();
        fragments.add(messageFragment);
        fragments.add(scienceFragment);
        fragments.add(relationFragment);
        fragments.add(mineFragment);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,fragments.get(0)).show(new MessageFragment()).commit();






    }


    @OnClick({R.id.message, R.id.science, R.id.relation, R.id.mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.message:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragments.get(0)).commit();
//                getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,fragments.get(0)).commit();
                break;
            case R.id.science:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragments.get(1)).commit();
//                getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,fragments.get(1)).commit();
                break;
            case R.id.relation:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragments.get(2)).commit();
//                getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,fragments.get(2)).commit();
                break;
            case R.id.mine:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragments.get(3)).commit();
//                getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,fragments.get(3)).commit();
                break;


        }
    }


}
