package kankan.wheel.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TextActivity extends Activity {
	private Button mButton1;
	private TextView mTextView;
	private ListView mListView;
	private ArrayAdapter<String> mAdapter;
	private String[] strs = new String[12];
	private EditText mEditText;
	private EditText mEditText1;
	private final String TAG = getClass().getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.haha);
		mTextView = (TextView) findViewById(R.id.textview);
		mListView = (ListView) findViewById(R.id.listview);
		mEditText = (EditText) findViewById(R.id.edittext);
		mEditText1 = (EditText) findViewById(R.id.edittext1);
		mEditText1.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					Log.i(TAG, "editText1 is focus!");
				} else {
					Log.i(TAG, "editText1 is no focus!");
				}
			}
		});
		// ����editText��������¼�
		mEditText.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// ��ȡ����
				if (hasFocus) {
					Log.i(TAG, "editText is focus!");
				} else {
					mEditText1.setEnabled(false);
					mEditText1.setText("����д��");
					Log.i(TAG, "editText is no focus!");
				}
			}
		});
		
		mEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Log.i(TAG, "onTextChanged!" + ",,," + s.toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				Log.i(TAG, "beforeText is changed!" + ",,," + s.toString());
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				Log.i(TAG, "after text is changed!" + ",,," + s.toString());
			}
		});
		for (int i = 0; i < 12; i++) {
			strs[i] = "result" + i;
		}
		String s = null;
		s = "aaa\nbbb";
		s = s.replace(" \\n", "\n");
		mTextView.setText(s);
//		init();
		mButton1 = (Button) findViewById(R.id.button1);
		mButton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(TextActivity.this,
						DialogActivityDemo.class));
			}
		});
	}

	/**
	 * ����<br/>
	 */
	private void init() {
		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_2, strs);
		mListView.setAdapter(mAdapter);
		setListViewHeightBasedOnChildren(mListView);
	}

	public static void setListViewHeightBasedOnChildren(ListView listView) {
		// ��ȡListView��Ӧ��Adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}

		int totalHeight = 0;
		for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()�������������Ŀ
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0); // ��������View �Ŀ��
			totalHeight += listItem.getMeasuredHeight(); // ͳ������������ܸ߶�
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		// listView.getDividerHeight()��ȡ�����ָ���ռ�õĸ߶�
		// params.height���õ�����ListView������ʾ��Ҫ�ĸ߶�
		listView.setLayoutParams(params);
	}
}
