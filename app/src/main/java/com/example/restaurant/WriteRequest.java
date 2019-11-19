package com.example.restaurant;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class WriteRequest extends StringRequest {
    final static private String URL = "https://seun116.cafe24.com/write.php";
    private Map<String, String> parameters;

    public WriteRequest(String Resname, String text, Response.Listener<String> listener) {
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("Resname", Resname);
        parameters.put("text", text);

    }

    @Override
    public Map<String, String> getParams()
    {
        return parameters;
    }
}
