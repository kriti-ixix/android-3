package com.kriti.android3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class DisplayStudents extends AppCompatActivity {

    ArrayList<StudentsInfo> studentsList = new ArrayList<StudentsInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_students);

        String url = "http://192.168.29.2/android3/gettingvalues.php";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try
                {
                    JSONObject json = new JSONObject(String.valueOf(response));
                    String result = json.getString("result");

                    if (result.equals("OK"))
                    {
                        JSONArray rollNoArray = json.getJSONArray("rollno");
                        JSONArray nameArray = json.getJSONArray("name");
                        JSONArray coursesArray = json.getJSONArray("courses");
                        JSONArray feesArray = json.getJSONArray("fees");

                        for (int i = 0; i<rollNoArray.length(); i++)
                        {
                            StudentsInfo info = new StudentsInfo();

                            info.setsRollNo(rollNoArray.getInt(i));
                            info.setsName(nameArray.getString(i));
                            info.setsCourse(coursesArray.getString(i));
                            info.setsFees(feesArray.getInt(i));

                            studentsList.add(info);
                        }

                        Toast.makeText(DisplayStudents.this, "Got values", Toast.LENGTH_SHORT).show();
                        Log.d("Size of list", String.valueOf(studentsList.size()));

                    }
                    else
                    {
                        Toast.makeText(DisplayStudents.this, "Got nothing", Toast.LENGTH_SHORT).show();
                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DisplayStudents.this, "Error connecting", Toast.LENGTH_SHORT).show();
                Log.d("Error", error.toString());
            }
        });

        queue.add(request);

    }
}