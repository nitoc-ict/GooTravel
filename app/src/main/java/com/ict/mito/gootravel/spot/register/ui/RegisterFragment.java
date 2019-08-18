package com.ict.mito.gootravel.spot.register.ui;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.*;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.SignInButton;
import com.ict.mito.gootravel.R;

import java.io.IOException;
import java.util.Calendar;

public class RegisterFragment extends Fragment {

    private RegisterViewModel mViewModel;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        // TODO: Use the ViewModel
    }

    public static Context contextOfApplication;
    public static Context getContextOfApplication()
    {
        return contextOfApplication;
    }


    private EditText Name;
    private Button S_button;
    private EditText Memo;
    private static final int READ_REQUEST_CODE = 42;
    private ImageView imageView;
    private Button ImageButton;
    private Button TimeButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        S_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name_text = Name.getText().toString();
                String Memo_text = Memo.getText().toString();

                if(!Name_text.equals("")) {
                    Toast.makeText(view.getContext(), "入力に成功しました", Toast.LENGTH_SHORT).show();
                    Name.setText("");
                    Memo.setText("");
                    Log.d("name", Name_text);
                    Log.d("memo", Memo_text);
                }

                else {
                    Toast.makeText(view.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");

                startActivityForResult(intent, READ_REQUEST_CODE);
            }
        });

        TimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog dialog = new TimePickerDialog(
                        getContext(),
                        new TimePickerDialog.OnTimeSetListener(){
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            }
                        },
                        hour,minute,true);
                dialog.show();

            }
        });



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData){
        contextOfApplication = getApplicationContext();
        Context applicationContext = RegisterFragment.getContextOfApplication();

        if(requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Uri uri = null;
            if(resultData != null){
                uri = resultData.getData();
                try{
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(applicationContext.getContentResolver(), uri);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }


}
