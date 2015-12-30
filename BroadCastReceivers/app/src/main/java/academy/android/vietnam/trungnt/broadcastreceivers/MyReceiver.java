package academy.android.vietnam.trungnt.broadcastreceivers;

/**
 * Created by TrungNT on 12/29/2015.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;


public class MyReceiver extends BroadcastReceiver{
    private TextView txtViewPower;

    @Override
    public void onReceive(Context context, Intent intent) {
        MainActivity oMainActivity = new MainActivity();
        txtViewPower = (TextView) oMainActivity.findViewById(R.id.txtViewPower);

        // nếu sự kiện nhận được là kết nối sạc
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            txtViewPower.setText(" Đang sạc pin");
        }
        // nếu sự kiện nhận đưọc là rút sạc
        if(intent.getAction().endsWith(Intent.ACTION_POWER_DISCONNECTED)){
            txtViewPower.setText(" Đã rút sạc");
        }
    }


}