package com.androidhw.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;

import com.androidhw.news.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SpalshActivity extends AppCompatActivity {

	@InjectView(R.id.fl_splash)
	FrameLayout flSplash;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spalsh);
		ButterKnife.inject(this);
		//动画的集合
		initView();

	}

	private void initView() {
		//旋转动画
		RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(1000);//动画执行的时间
		ra.setFillAfter(true);//动画执行结束后的状态
		//缩放动画
		ScaleAnimation sa = new ScaleAnimation(0, 1, 0,1,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(1000);
		sa.setFillAfter(true);
		//渐变动画
		AlphaAnimation aa = new AlphaAnimation(0, 1);//从完全不可见变成可见
		aa.setDuration(1000);
		aa.setFillAfter(true);
		//动画集合
		AnimationSet set = new AnimationSet(false);//初始化动画集合
		set.addAnimation(ra);
		set.addAnimation(sa);
		set.addAnimation(aa);
		//监听动画的执行
		flSplash.startAnimation(set);
		set.setAnimationListener(new Animation.AnimationListener() {
			/**
			 * 动画开启
			 * @param animation
			 */
			@Override
			public void onAnimationStart(Animation animation) {

			}

			/**
			 * 动画结束
			 * @param animation
			 */
			@Override
			public void onAnimationEnd(Animation animation) {
				//判断是否进入够引导界面

					//跳转到引导界面
				Intent intent = new Intent(SpalshActivity.this, GuideActivity.class);
				startActivity(intent);
				//结束当前界面
				finish();

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});


	}

}
