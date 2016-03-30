package truecolor.master;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import truecolor.webdataloader.HttpRequest;
import truecolor.webdataloader.WebDataLoader;
import truecolor.webdataloader.WebListener;
import truecolor.webdataloader.util.PreferenceUtils;


public class MainActivity extends Activity {

    private Button mLoadDataBtn;
    private Button mLoadDataBtn2;
    private Button mLoadDataBtn3;
    private TextView mResultTv;
    private TextView mResultTv2;
    private TextView mResultTv3;

    private String url = "http://cartoon.1kxun.mobi/api/familyApps/apps";
    private String url2 = "http://cartoon.1kxun.mobi/api/familyApps/suggestions";
    private String url3 = "http://cartoon.1kxun.mobi/api/pushMessages/index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadDataBtn = (Button) findViewById(R.id.btn_load_data);
        mLoadDataBtn2 = (Button) findViewById(R.id.btn_load_data2);
        mLoadDataBtn3 = (Button) findViewById(R.id.btn_load_data3);

        mResultTv = (TextView) findViewById(R.id.tv_data_result1);
        mResultTv2 = (TextView) findViewById(R.id.tv_data_result2);
        mResultTv3 = (TextView) findViewById(R.id.tv_data_result3);

        mLoadDataBtn.setOnClickListener(mLoadDataBtnOnClickListener);
        mLoadDataBtn2.setOnClickListener(mLoadDataBtnOnClickListener2);
        mLoadDataBtn3.setOnClickListener(mLoadDataBtnOnClickListener3);
        PreferenceUtils.setApplication(getApplication());

    }

    WebListener mWebListener = new WebListener() {
        @Override
        public void onDataLoadFinished(int service, Bundle params, Object result) {
            Log.e("WebDataLoader", "----" + result.toString());
            if (service == 1){
                mResultTv.setText(result.toString());
            }else if (service == 2){
                mResultTv2.setText(result.toString());
            }else {
                mResultTv3.setText(result.toString());
            }

        }
    };

    private void requestWebData(){
        HttpRequest httpRequest = HttpRequest.createDefaultRequestWithSign(url);
        WebDataLoader.loadWebData(httpRequest, ApiFamilyAppsResult.class, mWebListener, 1, null);
    }

    private void requestWebData2(){
        HttpRequest httpRequest = HttpRequest.createDefaultRequestWithSign(url2);
        WebDataLoader.loadWebData(httpRequest, ApiFamilyAppsResult.class, mWebListener, 2, null);
    }

    private void requestWebData3(){
        HttpRequest httpRequest = HttpRequest.createDefaultRequestWithSign(url3);
        WebDataLoader.loadWebData(httpRequest, ApiFamilyAppsResult.class, mWebListener, 3, null);
    }

    private View.OnClickListener mLoadDataBtnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            requestWebData();
        }
    };

    private View.OnClickListener mLoadDataBtnOnClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            requestWebData2();
        }
    };

    private View.OnClickListener mLoadDataBtnOnClickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            requestWebData3();
        }
    };

}
