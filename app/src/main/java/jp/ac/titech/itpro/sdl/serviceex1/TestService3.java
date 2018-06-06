package jp.ac.titech.itpro.sdl.serviceex1;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class TestService3 extends IntentService {
    private final static String TAG = "TestService3";
    public final static String EXTRA_MYARG = "MYARG";
    private final static int MESSAGE_TAG = 1234;
    public final static String ACTION_ANSWER = "How are you?";
    public final static String EXTRA_ANSWER = "I'm very happy.";

    TestService3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
        Intent answerIntent = new Intent(); // 送信用インテントの作成
        answerIntent.setAction(ACTION_ANSWER); // アクションをセット
        answerIntent.putExtra("EXANS", EXTRA_ANSWER); // その他返値データをセット
        sendBroadcast(answerIntent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}
