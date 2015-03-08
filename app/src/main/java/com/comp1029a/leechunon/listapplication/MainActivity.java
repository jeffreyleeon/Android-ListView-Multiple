package com.comp1029a.leechunon.listapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    String[] nameList, lastNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        nameList = getResources().getStringArray(R.array.Name);
        lastNameList = getResources().getStringArray(R.array.LastName);

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        int count = nameList.length;
        for(int i = 0; i < count; i++) {
            map = new HashMap<String, String>();
            map.put("name", nameList[i]);
            map.put("lastName", lastNameList[i]);
            list.add(map);
        }
        listView.setAdapter(new SimpleAdapter(this, list, R.layout.name_list, new String[] { "name", "lastName" }, new int[] { R.id.nameTV, R.id.lastNameTV }));

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
}
