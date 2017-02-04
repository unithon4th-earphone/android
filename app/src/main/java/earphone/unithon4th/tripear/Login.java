package earphone.unithon4th.tripear;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Login extends AppCompatActivity {


    Button local_login, naver_login, signin;
    EditText input_Email, input_Password;
    RadioButton keep_loginBtn;
    TextView findPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        local_login = (Button)findViewById(R.id.login_btn);
        naver_login = (Button)findViewById(R.id.naver_login_btn);
        signin = (Button)findViewById(R.id.sign_btn);

        input_Email = (EditText)findViewById(R.id.input_email);
        input_Password = (EditText)findViewById(R.id.input_password);

        keep_loginBtn = (RadioButton)findViewById(R.id.keep_login_btn);
        findPassword = (TextView)findViewById(R.id.find_password);


    }
}
