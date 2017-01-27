package br.com.rmatos.mylogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText txtLogin;
    private EditText txtSenha;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLogin = (EditText)this.findViewById(R.id.txtLogin);
        txtSenha = (EditText)this.findViewById(R.id.txtSenha);
        btnLogin = (Button)this.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(txtLogin.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Informe um login", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(txtSenha.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Informe uma senha", Toast.LENGTH_LONG).show();
                    return;
                }

                User user = new User(txtLogin.getText().toString());

                Intent it = new Intent();
                it.putExtra("user", user);
                setResult(RESULT_OK, it);
                finish();

            }
        });
    }
}
