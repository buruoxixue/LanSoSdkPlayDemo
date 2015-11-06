/*****************************************************************************
 * Email:support@lansongtech.com
 * MainActivity.java
 * 
 * 这个程序仅仅是演示版本，仅是功能上的呈现，不保证性能和适用性。如正好满足您的项目，我们深感荣幸。
 * 我们有更专业稳定强大的发行版本，期待和您进一步的合作。
 *  
 *Email: support@lansongtech.com 
 * 
 * 
 * 
 *****************************************************************************/
package com.example.lansosdkplaydemo;


import java.io.File;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {

	private String path="";
	 
	//such as:		path = "/storage/sdcard1/chongchukabuer.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

		 Thread.setDefaultUncaughtExceptionHandler(new snoCrashHandler());
        setContentView(R.layout.activity_main);
    
       // path = "/storage/sdcard1/chongchukabuer.mp4";
    	findViewById(R.id.id_main_allcodec_btn).setOnClickListener(this);
    	findViewById(R.id.id_main_software_btn).setOnClickListener(this);
    	findViewById(R.id.id_main_3ddemo_btn).setOnClickListener(this);
        
    }
    @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	switch (v.getId()) {
		case R.id.id_main_allcodec_btn:
				playFullCodecDemo();
				break;
		case R.id.id_main_software_btn:
				playSoftWareDemo();
				break;
		case R.id.id_main_3ddemo_btn:
				play3DDemo();
				break;

		default:
			break;
		}
    }
    
    private void playFullCodecDemo()
    {
    	if (path == "") {
			Toast.makeText(MainActivity.this, 
					"Please set a variable path at MainActivity.java(请设置播放源)", Toast.LENGTH_LONG).show();
			return ;
		}
		Uri uri1=Uri.fromFile(new File(path));
//		Uri uri1=Uri.parse("http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8");//<-----------or http/rtsp/rtmp  URL
		
        Intent intent = new Intent(MainActivity.this, VideoPlayerActivity.class);
        intent.putExtra(VideoPlayerActivity.PLAY_LOCATION, uri1);
        intent.putExtra(VideoPlayerActivity.PLAY_IS_SOFTWARE_CODEC, false);
        startActivity(intent);
    }
    private void playSoftWareDemo()
    {
    	if (path == "") {
			Toast.makeText(MainActivity.this, 
					"Please set a variable path at MainActivity.java(请设置播放源)", Toast.LENGTH_LONG).show();
			return ;
		}
		Uri uri1=Uri.fromFile(new File(path));
		
        Intent intent = new Intent(MainActivity.this, VideoPlayerActivity.class);
        intent.putExtra(VideoPlayerActivity.PLAY_LOCATION, uri1);
        intent.putExtra(VideoPlayerActivity.PLAY_IS_SOFTWARE_CODEC, true);  //<------------only here is different
        startActivity(intent);
    }
    private void play3DDemo()
    {
    	if (path == "") {
			Toast.makeText(MainActivity.this, 
					"Please set a variable path at MainActivity.java(请设置播放源)", Toast.LENGTH_LONG).show();
			return ;
		}
			Uri uri1=Uri.fromFile(new File(path));
	       Intent intent = new Intent(MainActivity.this, VideoPlay3DActivity.class);
		     intent.putExtra(VideoPlayerActivity.PLAY_LOCATION, uri1);
		     intent.putExtra(VideoPlayerActivity.PLAY_IS_SOFTWARE_CODEC, true);
		     startActivity(intent);
    }
}
