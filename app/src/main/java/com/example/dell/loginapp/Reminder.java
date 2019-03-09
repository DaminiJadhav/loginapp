
package com.example.dell.loginapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.TimeZone;

public class Reminder extends AppCompatActivity {
private AlarmManager alarmManager;
private PendingIntent alarmIntent;
String context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        addReminderInCalender();

//                alarmManager=(AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        Calendar calendar = Calendar.getInstance();
//        Intent intent = new Intent(Intent.ACTION_EDIT);
//        intent.setType("vnd.android.cursor.item/event");
//        intent.putExtra("beginTime", calendar.getTimeInMillis());
//        intent.putExtra("allDay", false);
//        intent.putExtra("rrule", "FREQ=DAILY");
//        intent.putExtra("endTime", calendar.getTimeInMillis() + 60 * 60 * 1000);
//        intent.putExtra("title", "A test event from android app");
//        startActivity(intent);
////
//        alarmManager=context.getSystemSer
    }

    private void  addReminderInCalender()
    {
       Calendar calendar = Calendar.getInstance();
        Uri event_uri=Uri.parse(getCalenderUriBase(true) + "reminders");
        ContentResolver cr=getContentResolver();
        TimeZone timeZone=TimeZone.getDefault();
        ContentValues values=new ContentValues();
        values.put(CalendarContract.Reminders.EVENT_ID,Short.parseShort(event_uri.getLastPathSegment()));
//        values.put(CalendarContract.Reminders.EVENT_ID,Long.parseLong(event_uri.getLastPathSegment()));
        values.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);
        values.put(CalendarContract.Reminders.MINUTES,10);
        cr.insert(event_uri,values);
    }

    private String getCalenderUriBase(boolean eventUri){
        Uri calenderUri=null;
        try
        {
            if (Build.VERSION.SDK_INT<=7){
                calenderUri=(eventUri) ? Uri.parse("content://calender/"):Uri.parse("content://calender/calenders");

            }else {
                calenderUri=(eventUri) ? Uri.parse("content://com.android.calendar/"):Uri.parse("content://com.android.calendar/calendars");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return calenderUri.toString();
    }
}
