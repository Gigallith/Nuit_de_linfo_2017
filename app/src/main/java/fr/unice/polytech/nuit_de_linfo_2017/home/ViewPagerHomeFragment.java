package fr.unice.polytech.nuit_de_linfo_2017.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.unice.polytech.nuit_de_linfo_2017.R;

/**
 * Created by Pierre on 07/12/2017.
 */

public class ViewPagerHomeFragment extends Fragment {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    public static ViewPagerHomeFragment newInstance() {
        ViewPagerHomeFragment fragment = new ViewPagerHomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.view_pager_layout, container, false);

        return rootView;

    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        mViewPager = (ViewPager) getView().findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int i, final float v, final int i2) {
            }

            @Override
            public void onPageSelected(final int i) {
                FragmentInterface fragment = (FragmentInterface) mSectionsPagerAdapter.instantiateItem(mViewPager, i);
                if (fragment != null) {
                    if (fragment instanceof ViewPagerHomeFragment) {
                        fragment.fragmentBecameVisible();
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(final int i) {
            }
        });
        TabLayout tabLayout = (TabLayout) getView().findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
}
