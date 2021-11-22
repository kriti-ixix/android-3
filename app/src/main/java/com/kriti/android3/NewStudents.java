package com.kriti.android3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NewStudents extends AppCompatActivity {

    String studentName, studentCourse, studentFees;
    EditText nameEditText, courseEditText, feeEditText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_students);

        nameEditText = findViewById(R.id.newStudentName);
        courseEditText = findViewById(R.id.newStudentCourse);
        feeEditText = findViewById(R.id.newStudentFees);
        button = findViewById(R.id.newStudentButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentName = nameEditText.getText().toString();
                studentCourse = courseEditText.getText().toString();
                studentFees = feeEditText.getText().toString();
                insertStudents(studentName, studentCourse, studentFees);
            }
        });

    }

    void insertStudents(String sName, String sCourse, String sFees)
    {
        String url = "http://192.168.29.2/android3/inserting.php";
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
                        Toast.makeText(NewStudents.this, "Values inserted", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(NewStudents.this, "Error", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(NewStudents.this, "Error connecting", Toast.LENGTH_SHORT).show();
                Log.i("Error", error.toString());
            }
        })
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("name", sName);
                map.put("course", sCourse);
                map.put("fees", sFees);
                return map;
            }
        };

        queue.add(request);

    }

}