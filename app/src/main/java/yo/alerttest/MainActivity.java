package yo.alerttest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//          switch 選擇所選到的項目 (MenuItem item) item的 getItemId 去選擇menu
        switch (item.getItemId()) {
            case R.id.about:
//              建立跳出訊息(Alert)的物件
                Alert alert = new Alert();
//                FragmentManger 來管理DialogFragment
                FragmentManager fm = getFragmentManager();

//                show DialogFragment  透過 (Manager, "KEY")，透過KEY可以操作Fragment
                alert.show(fm, "alert");
                break;
            case R.id.action_settings:
                return true;


        }
        return true;
    }

//    內部類別 extends DialogFragment implements DialogInterface.OnClickListener
//    extends DialogFragment  必須使用 Static
    public static class Alert extends DialogFragment implements DialogInterface.OnClickListener {

//      @Override  onCreateDialog(Bundle savedInstanceState)  & onClick(DialogInterface dialog, int which)


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                    .setMessage("姓名:AAABBBBCCCC" + "\n" + "version:1.0000000")
//                    this 為這個類別的 DialogInterface.OnClickListener
                    .setPositiveButton(R.string.sure, this)
                    .setTitle("作者資訊")
                    .create();


            return alertDialog;
        }

        //      設定按鍵
        @Override
        public void onClick(DialogInterface dialog, int which) {

            if (which == DialogInterface.BUTTON_POSITIVE) {
                dialog.cancel();
            }


        }


    }


}
