package net.forestlive.notificationsamplekotrin

import android.app.Application
import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.bt_add).setOnClickListener { SampleThread(this, Date().seconds).start() }
        findViewById<Button>(R.id.bt_remove).setOnClickListener { this.remove() }


    }

    fun remove(){
        var manager:NotificationManager =getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.cancelAll()
    }
}

class SampleThread(val context:Context, val count:Int) : Thread() {

    override fun run() {
        super.run()

        var manager:NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var builder: Notification.Builder? = Notification.Builder(context).setContentText("aaaa").setContentTitle("title").setSmallIcon(R.drawable.ic_launcher_background)


        var notification = builder!!.build()

        manager.notify(count, notification)
    }
}
