package com.androidhw.news.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.androidhw.news.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

	@InjectView(R.id.vp_guide)
	ViewPager vpGuide;
	@InjectView(R.id.bt_start_experience)
	Button btStartExperience;
	private int[] guidePics = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
	private static final String TAG = "GuideActivity";
	private List<ImageView> ivs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		ButterKnife.inject(this);
		initData();
		vpGuide.setAdapter(new PagerAdapter() {
			@Override
			public int getCount() {
				return ivs.size();
			}

			@Override
			public boolean isViewFromObject(View view, Object object) {
				return view == object;
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				ImageView imageView = ivs.get(position);
				container.addView(imageView);
				return imageView;
			}

			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				container.removeView((View) object);
			}
		});
		vpGuide.setOnPageChangeListener(this);

	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		ivs = new ArrayList<>();
		for (int i = 0; i < guidePics.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setBackgroundResource(guidePics[i]);
			ivs.add(imageView);

		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {
		Log.e(TAG, "onPageSelected:位置为 " + position);
		//判断滑动的是否是最后一页
		if (btStartExperience != null) {
			if (position == guidePics.length - 1) {
				//设置按钮可见
				Log.e(TAG, "onPageSelected: 2222222");
				btStartExperience.setVisibility(View.VISIBLE);
				Log.e(TAG, "onPageSelected: 3333333333");
			} else {
				//设置按钮不可见
				btStartExperience.setVisibility(View.GONE);
			}
		}

	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}
}
