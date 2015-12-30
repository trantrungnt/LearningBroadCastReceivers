package academy.android.vietnam.trungnt.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private MyReceiver oMyReceiver = null;
    private BroadcastReceiver broad_receice = null;
    private TextView txtViewPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dang ky bo loc su kien rut sac va dang sac
        IntentFilter intent_filter = new IntentFilter();
        intent_filter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intent_filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");


        //oMyReceiver = new MyReceiver();
        //oMyReceiver.onReceive(getBaseContext(),getIntent());
        //Dang ky nhan thong tin tu he thong
        //registerReceiver(oMyReceiver, intent_filter);
        broad_receice = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                txtViewPower = (TextView) findViewById(R.id.txtViewPower);

                // nếu sự kiện nhận được là kết nối sạc
                if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
                    txtViewPower.setText("Đang sạc pin");
                    //dung Tóa de thong bao
                    /*Toast.makeText(MainActivity.this,
                                   "Đang sạc pin",
                                   Toast.LENGTH_SHORT).show();*/
                }
                // nếu sự kiện nhận đưọc là rút sạc
                if(intent.getAction().endsWith(Intent.ACTION_POWER_DISCONNECTED)){
                    txtViewPower.setText(" Đã rút sạc");
                    /*Toast.makeText(MainActivity.this,
                            "Rút sạc",
                            Toast.LENGTH_SHORT).show();*/
                }
            }
        };

        //Dang ky nhan thong tin tu he thong
        registerReceiver(broad_receice, intent_filter);
    }

    //Huy ky nhan thong tin tu he thong
    /*@Override
    public void onDestroy(){
        // hủy đăng ký
        if (oMyReceiver != null) {
            unregisterReceiver(oMyReceiver);
        }
        super.onDestroy();
    }*/

    @Override
    public void onDestroy(){
        if(broad_receice !=null){
            unregisterReceiver(broad_receice);
        }
        super.onDestroy();
    }
}
