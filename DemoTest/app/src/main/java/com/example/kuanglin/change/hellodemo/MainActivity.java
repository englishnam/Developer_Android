package com.example.kuanglin.change.hellodemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kuanglin.change.hellodemo.Custom.Public.SocketThread;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    ArrayList<Object> list =new ArrayList<>();
    SocketThread tempSocket=new  SocketThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mainList = (ListView) findViewById(R.id.mainListView);
        TextView txt1 =(TextView)findViewById(R.id.Txt1);

        for (int i =0;i<10;i++){
            list.add("aafsd");
        }
        mainList.setAdapter(new MainAdapter());
        System.out.println("Hello");
//        SocketThread tempSocket =new  SocketThread();
//        tempSocket.createThread("192.168.10.16",30006);
        tempSocket.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class MainAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View convertView, ViewGroup viewGroup) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getApplicationContext(), R.layout.mainitem, null);
                holder.main_textView = (TextView) convertView.findViewById(R.id.main_textView);
                holder.main_imageView = (ImageView) convertView.findViewById(R.id.main_imageView);
                holder.main_button =(Button) convertView.findViewById(R.id.main_button);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.main_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("第"+i+"个点击事件");
                }
            });
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("item "+i+"的点击事件");
                }
            });
            System.out.println("adapter页面List的长度：" + list.size());
            return convertView;
        }

        class ViewHolder {
            TextView main_textView;
            ImageView main_imageView;
            Button main_button;
        }
    }
}
