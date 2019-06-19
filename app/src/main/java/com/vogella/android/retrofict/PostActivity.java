package com.vogella.android.retrofict;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vogella.android.retrofict.Model.GetDataService;
import com.vogella.android.retrofict.Model.RetroPhoto;
import com.vogella.android.retrofict.Network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    EditText title, body;
    Button btnSubmit;
    TextView response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        title = findViewById(R.id.txt_title);
        body = findViewById(R.id.txt_body);
        btnSubmit = findViewById(R.id.btn_submit);
        response = findViewById(R.id.response);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtTitle = title.getText().toString().trim();
                String txtBody = body.getText().toString().trim();
                
                if(!txtTitle.isEmpty() && !txtBody.isEmpty()){
                    sendPost(txtTitle, txtBody);
                }else {
                    Toast.makeText(PostActivity.this, "Please fill all details!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void sendPost(String txtTitle, String txtBody) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        service.savePost(txtTitle, txtBody, 1).enqueue(new Callback<RetroPhoto>() {
            @Override
            public void onResponse(Call<RetroPhoto> call, Response<RetroPhoto> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i("TAG", "post submitted to API." + response.body().getBody());
                }
            }

            @Override
            public void onFailure(Call<RetroPhoto> call, Throwable t) {
                Log.e("TAG", "Unable to submit post to API.");
            }
        });
    }

    public void showResponse(String responsedata) {
        if(response.getVisibility() == View.GONE) {
            response.setVisibility(View.VISIBLE);
        }
        response.setText(responsedata);
    }


}
