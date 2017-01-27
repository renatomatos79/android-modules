package br.com.rmatos.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import br.com.rmatos.myframework.StringHelper;
import br.com.rmatos.mylogin.LoginActivity;
import br.com.rmatos.mylogin.User;

public class MainActivity extends AppCompatActivity {

    private final int LOGIN_RESULT = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it = new Intent(this, LoginActivity.class);
        startActivityForResult(it, LOGIN_RESULT);

        String cpf = StringHelper.extractNumbers("793.343.123-07");

        TextView lblInfo = (TextView)this.findViewById(R.id.lblInfo);
        lblInfo.setText(cpf);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOGIN_RESULT){
            if (resultCode == RESULT_OK){
                User login = (User)data.getSerializableExtra("user");
                Log.i("Login", login.Login);
            }
        }
    }
}
