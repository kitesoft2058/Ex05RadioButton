package com.kitesoft.ex05radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    RadioGroup rg;

    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
        rg= findViewById(R.id.rg);

        //RadioButton의 체크상태가 변경될 때 마다 반응하기
        //라디오버튼 사용은 Single choice이므로 개별 버튼에 리스너를 적용하여 잘 사용하지 않음 [물론, 원한다면 체크박스처럼 개별 라디오버튼에 리스터를 설정해도 됨]
        //RadioButton이 아니라 RadioGroup에게 OnCheckedChangeListener를 설정해야 함.
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                //체크된 RadioButton 찾아오기
                RadioButton rb= findViewById(checkedId);

                //체크된 라디오버튼의 글씨를 얻어와서 텍스트뷰에 보여주기
                tv.setText( rb.getText().toString() );

            }
        });

        //RatingBar 제어하기 - 레이팅점수 변경 리스너 사용
        ratingBar= findViewById(R.id.rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            //3번째 파라미터 : 사용자가 터치를 이용해서 점수를 변경했는지 여부
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean byUser) {
                tv.setText(rating+"점");
            }
        });

    }

    public void clickBtn(View view) {
        //체크되어 있는 RadioButton 찾아오기
        int id= rg.getCheckedRadioButtonId();
        RadioButton rb= findViewById(id);

        //체크된 라디오버튼의 글씨를 얻어와서 텍스트뷰에 보여주기
        tv.setText( rb.getText().toString() );
    }

}
