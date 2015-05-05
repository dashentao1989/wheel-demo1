package kankan.wheel.demo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;

/**
 * <pre>
 *  Ù–‘∂Øª≠demo
 * </pre>
 * 
 * @author JamesTao
 *
 */

public class ValueAnomatorDemo extends Activity {
	private Button mButton;
	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animator_demo1);
		mButton = (Button) findViewById(R.id.button1);
		mTextView = (TextView) findViewById(R.id.textview1);
		mButton.setOnClickListener(new OnClickListener() {

			@Override
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			public void onClick(View v) {
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
					AnimatorSet mAnimationSet = new AnimatorSet();
					ObjectAnimator mObjectAnimator1 = ObjectAnimator.ofFloat(
							mTextView, "alpha", 0f, 1f, 1f, 0f, 1f);
					ObjectAnimator mObjectAnimator2 = ObjectAnimator.ofFloat(
							mTextView, "rotation", 0f, 720f);
					mAnimationSet.play(mObjectAnimator1).with(mObjectAnimator2);
					mAnimationSet.setDuration(3000);
					mAnimationSet.start();
				}
			}
		});
	}
}
