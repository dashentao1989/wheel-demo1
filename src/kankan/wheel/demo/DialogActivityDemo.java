package kankan.wheel.demo;

import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * 
 * @author JamesTao
 * @date 2015 4-9
 * @since V 1.0
 *
 */
public class DialogActivityDemo extends Activity {
	// Scrolling flag
	private boolean scrolling = false;
	private WheelView mWheelView1;
	private WheelView mWheelView2;
	private Button mButton1;
	private Button mButton2;

	/**
	 * @param savedInstanceState
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 这个参数只有sdk的版本大于11才会有效，否则会报错
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			setFinishOnTouchOutside(true);
		}
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog);
		mWheelView1 = (WheelView) findViewById(R.id.date1);
		mWheelView2 = (WheelView) findViewById(R.id.date2);
		mButton1 = (Button) findViewById(R.id.button1);
		mButton1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		final List<String> list = new ArrayList<String>();
		list.add("星期一");
		list.add("星期二");
		list.add("星期三");
		list.add("星期四");
		list.add("星期五");
		mWheelView1.setVisibleItems(5);
		mWheelView1.setViewAdapter(new CountryAdapter(this, list));
		mWheelView1.setCyclic(true);
		mWheelView2.setVisibleItems(5);
		mWheelView2.setViewAdapter(new CountryAdapter(this, list));
		mWheelView2.setCyclic(true);
		mWheelView1.setCurrentItem(2);
		mWheelView2.setCurrentItem(2);

		mWheelView1.addScrollingListener(new OnWheelScrollListener() {
			public void onScrollingStarted(WheelView wheel) {
				scrolling = true;
			}

			public void onScrollingFinished(WheelView wheel) {
				scrolling = false;
				// updateCities(city, cities, country.getCurrentItem());
				Toast.makeText(getApplicationContext(),
						list.get(wheel.getCurrentItem()) + "/1", 1000).show();
			}
		});

		mWheelView2.addScrollingListener(new OnWheelScrollListener() {
			public void onScrollingStarted(WheelView wheel) {
				scrolling = true;
			}

			public void onScrollingFinished(WheelView wheel) {
				scrolling = false;
				// updateCities(city, cities, country.getCurrentItem());
				Toast.makeText(getApplicationContext(),
						list.get(wheel.getCurrentItem()) + "/2", 1000).show();
			}
		});
	}

	/**
	 * Adapter for countries
	 */
	private class CountryAdapter extends AbstractWheelTextAdapter {
		// Countries names
		List list;

		protected CountryAdapter(Context context, List list) {
			super(context, R.layout.tempitem, NO_RESOURCE);
			this.list = list;
			setItemTextResource(R.id.tempValue);
		}

		// Countries flags
		private int flags = R.drawable.tem_unit_dialog;

		@Override
		public View getItem(int index, View cachedView, ViewGroup parent) {
			View view = super.getItem(index, cachedView, parent);
			// ImageView img = (ImageView) view.findViewById(R.id.tempImag);
			// img.setImageResource(flags);
			return view;
		}

		@Override
		public int getItemsCount() {
			return list.size();
		}

		@Override
		protected CharSequence getItemText(int index) {
			return list.get(index) + "";
		}
	}

}
