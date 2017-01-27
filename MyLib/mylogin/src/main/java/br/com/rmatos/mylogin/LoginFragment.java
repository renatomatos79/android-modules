package br.com.rmatos.mylogin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginFragment extends Fragment {
    private ILoginEventHandler loginEventHandler;

    private EditText txtLogin;
    private EditText txtSenha;
    private Button btnLogin;


    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_login, container, false);

        txtLogin = (EditText)view.findViewById(R.id.txtLogin);
        txtSenha = (EditText)view.findViewById(R.id.txtSenha);
        btnLogin = (Button)view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(txtLogin.getText().toString())){
                    Toast.makeText(getActivity(), "Informe um login", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(txtSenha.getText().toString())) {
                    Toast.makeText(getActivity(), "Informe uma senha", Toast.LENGTH_LONG).show();
                    return;
                }

                User user = new User(txtLogin.getText().toString());
                loginEventHandler.OnLogin(user);

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ILoginEventHandler) {
            loginEventHandler = (ILoginEventHandler) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ILoginEventHandler");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        loginEventHandler = null;
    }
}
