package br.com.rmatos.mylib;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.com.rmatos.myframework.StringHelper;
import br.com.rmatos.mylogin.ILoginEventHandler;
import br.com.rmatos.mylogin.LoginActivity;
import br.com.rmatos.mylogin.LoginFragment;
import br.com.rmatos.mylogin.User;

public class MainActivity extends AppCompatActivity implements ILoginEventHandler {

    private TextView lblInfo;
    private final int LOGIN_RESULT = 200;

    private FragmentManager fragmentManager;
    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent it = new Intent(this, LoginActivity.class);
//        startActivityForResult(it, LOGIN_RESULT);

        this.fragmentManager = getSupportFragmentManager();
        this.loginFragment = (LoginFragment)fragmentManager.findFragmentById(R.id.login);


        String cpf = StringHelper.extractNumbers("793.343.123-07");

        lblInfo = (TextView)this.findViewById(R.id.lblInfo);
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

    @Override
    public void OnLogin(User user) {
        Log.i("User", user.Login);
    }
}
