package kankan.wheel.demo;

import java.util.ArrayList;

import kankan.wheel.demo.R;
import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelClickedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class CitiesActivity extends Activity {
	// Scrolling flag
	private boolean scrolling = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cities_layout);
		final WheelView country = (WheelView) findViewById(R.id.country);
		ArrayList list = new ArrayList();
		for (int i = 0; i < 100; i++) {
			list.add(i + "");
		}
		final String[] datas = new String[] { "星期一", "星期二", "星期三", "星期四", "星期五" };
		ArrayList list1 = new ArrayList();
		list1.add("星期一");
		list1.add("星期二");
		list1.add("星期三");
		list1.add("星期四");
		list1.add("星期五");

		country.setVisibleItems(3);
		country.setViewAdapter(new CountryAdapter(this, list1));
		/*
		 * final String cities[][] = new String[][] { new String[] {"New York",
		 * "Washington", "Chicago", "Atlanta", "Orlando"}, new String[]
		 * {"Ottawa", "Vancouver", "Toronto", "Windsor", "Montreal"}, new
		 * String[] {"Kiev", "Dnipro", "Lviv", "Kharkiv"}, new String[]
		 * {"Paris", "Bordeaux"}, };
		 */
		// final WheelView city = (WheelView) findViewById(R.id.city);
		// city.setVisibleItems(5);

		country.addChangingListener(new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if (!scrolling) {
				}
			}
		});

		country.addClickingListener(click);
		country.addScrollingListener(new OnWheelScrollListener() {
			public void onScrollingStarted(WheelView wheel) {
				scrolling = true;
			}

			public void onScrollingFinished(WheelView wheel) {
				scrolling = false;
				// updateCities(city, cities, country.getCurrentItem());
				Toast.makeText(getApplicationContext(),
						datas[country.getCurrentItem()], 1000).show();
			}
		});

		country.setCurrentItem(2);
	}

	/**
	 * Updates the city wheel
	 */
	/*
	 * private void updateCities(WheelView city, String cities[][], int index) {
	 * ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(this,
	 * cities[index]); adapter.setTextSize(18); city.setViewAdapter(adapter);
	 * city.setCurrentItem(cities[index].length / 2); }
	 */
	
	// 设置点击滑动效果
	OnWheelClickedListener click = new OnWheelClickedListener() {
		public void onItemClicked(WheelView wheel, int itemIndex) {
			wheel.setCurrentItem(itemIndex, true);
		}
	};

	/**
	 * Adapter for countries
	 */
	private class CountryAdapter extends AbstractWheelTextAdapter {
		// Countries names
		ArrayList list;

		protected CountryAdapter(Context context, ArrayList list) {
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
