package com.example.bruno.exemplorealm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.bruno.exemplorealm.models.Guitar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmChangeListener;

/**
 * Created by bruno.oliveira on 6/10/16.
 */
public class NewGuitarActivity extends AppCompatActivity {

    @BindView(R.id.edittext_name)
    EditText mEditTextName;
    @BindView(R.id.edittext_color)
    EditText mEditTextColor;

    private Realm mRealm = Realm.getDefaultInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_guitar);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button_save)
    public void onClickSave(View v) {

        mRealm.beginTransaction();

        Guitar guitar = mRealm.createObject(Guitar.class);
        guitar.setName(mEditTextName.getText().toString());
        guitar.setColor(mEditTextColor.getText().toString());

        mRealm.commitTransaction();
        mRealm.addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm element) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }
}
