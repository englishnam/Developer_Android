package com.example.kuanglin.change.hellodemo.Custom.Public;

import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by kuanglin on 16/6/27.
 */
public class SocketThread extends Thread {
    TextView txt01;
    Socket sck01;

    public void run() {
        while (true) try {
            Thread.sleep(3000);
//                System.out.println("这是线程中的输出");
            LogUtils.d("Thread", "这是线程中的输出");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createThread(String Host,int port){
        if (sck01 ==null){
            try {
                sck01 =new Socket(Host,port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
