package com.android.toolbar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.toolbar.R;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;


public class TabFragment1 extends Fragment implements BaseSliderView.OnSliderClickListener {


    @Bind(R.id.mSlider)
    SliderLayout mSlider;
    @Bind(R.id.mCustom_indicator)
    PagerIndicator mCustomIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_fragment1, container, false);
        ButterKnife.bind(this, view);
        initBanner();
        return view;
    }

    private void initBanner() {
        HashMap<String, Integer> file_maps = new HashMap<>();
        file_maps.put("Hannibal", R.mipmap.hannibal);
        file_maps.put("Big Bang Theory", R.mipmap.bigbang);
        file_maps.put("House of Cards", R.mipmap.house);
        file_maps.put("Game of Thrones", R.mipmap.game_of_thrones);
        for (String name:file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView.description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            mSlider.addSlider(textSliderView);

        }
        //设置滚动方式
        mSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        //设置indicator位置
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity(),slider.getBundle().getString("extra")+"===",Toast.LENGTH_LONG).show();
    }
}
