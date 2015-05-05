package kankan.wheel.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * <pre>
 * OnNewIntent≤‚ ‘¥˙¬Î
 * </pre>
 * 
 * @author JamesTao
 *
 */
public class TestActivity2 extends Activity {
	private Button button;
	private static final String TAG = TestActivity2.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test2);
		button = (Button) findViewById(R.id.button2);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				System.out.println("testActivity2 is called!");
				Intent intent = new Intent();
				intent.setClass(TestActivity2.this, TestActivity3.class);
				startActivity(intent);
			}
		});
		Log.i(TAG, "onCreate is called!");
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Log.i(TAG, "onNewIntent is called!");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart is called!");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart is called!");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause is called!");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume is called!");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy is called!");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop is called!");
	}
}
