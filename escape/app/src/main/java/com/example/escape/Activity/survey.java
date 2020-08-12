package com.example.escape.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.escape.R;

import java.lang.reflect.Array;
import java.util.Arrays;

public class survey extends AppCompatActivity {
    TextView questionTextView;
    Button answer1Button;
    Button answer2Button;
    Button answer3Button;
    Button answer4Button;
    Button answer5Button;
    Button button_back;

    int[] count = {0,0,0,0,0};

    String[] question = {
            "1) 책상에 앉아 있는데 등 뒤에서 시선이 느껴진다. 뒤를 돌아봤을 때 당신 눈 앞에 보이는 것은 무엇인가?",
            "2) 깜박 잠에 든 당신이 꾼 꿈은?",
            "3) 피곤한 하루를 마치고 당신이 튼 노래는?",
            "4) 쉬는 날 나는?",
            "5) 당신은 테이블 위 치킨을 올려 두고 외출했습니다. 집으로 돌아와서 누군가 당신이 올려놓은 음식을 먹어 치운 것을 발견했습니다. 다음 예상되는 시나리오는?",
            "6) 당신은 미술관에서 연인과 만나기로 약속했다. 기다리던 중 당신에게 그림 하나가 눈에 띄었다. 누구의 작품이었을까?",
            "7) 가장 먼저 손이 가는 음식은?",
            "8) 전쟁 중에 숲에서 길을 잃어 동료와 떨어졌습니다. 당신이 물건 하나만 가지고 있을 수 있다면 어떤 것을 가질 것인가요?",
            "9) 당신이 있는 건물에서 화재 경보기가 울렸다. 이후 본인의 행동은?"
    };

    String[][] answer = {
            {"내가 하는 일을 구경하고 있던 가족", "벽에 걸어 둔 강아지 사진", "인형", "아무것도 없음", "창문에 비친 무지개 " },
            {"가족과 여행 가는 꿈", "개그맨과 노는 꿈 ", "귀신에 쫓기는 꿈", "범인을 잡는 꿈", "하늘을 나는 꿈"},
            {"놓칠 수 없는 최신 가요", "무드 있는 팝송", "흥이 오르는 EDM", "나만의 최애 가수 노래", "부드러운 재즈"},
            {"자기개발을 위한 노력", "밖에서 친구랑 놀기 ", "혼자라도 밖에서 놀기 ", "혼자 집에서 놀기", "반려동물, 가족과 함께 시간 보내기"},
            {"집에 애인이 와있다고 연락을 받았던 것 같다", "경찰을 부르고 그 자리를 관찰한다", "방에서 인기척이 들린다", "내가 먹었던 사실을 떠올린다",  "짐을 챙겨 정들었던 안식처를 떠난다"},
            {"고흐 – 별이 빛나는 밤에 ", "피카소 – 우는 여인 ", "에드바르 뭉크 – 뭉크의 절규 ", "앤디 워홀 – 마릴린 먼로 ", "몬드리안"},
            {"싱그러운 과일", "시원한 아이스 커피", "매콤한 곱창전골", "통통한 연어회", "달콤한 생크림 케이크"},
            {"동료의 위치로 가는 나침반", "숲에서 나갈 수 있는 암호로 된 지도", "숲에서 상대 기지로 가는 지도", "숲에 숨겨져 있는 보물지도", "적에게 내 모습을 감춰줄 투명망토"},
            {"사람들에게 알리고 적극 대피시킨다", "불이 난 곳을 찾아 신고한다", "창문 밖으로 뛰어내린다", "누군가의 장난이라 생각하고 무시한다",  "사람들과 다같이 불을 끈다"}
    };

    int questionnum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        questionTextView = findViewById(R.id.textview_quiz);
        answer1Button = findViewById(R.id.button_answer1);
        answer2Button = findViewById(R.id.button_answer2);
        answer3Button = findViewById(R.id.button_answer3);
        answer4Button = findViewById(R.id.button_answer4);
        answer5Button = findViewById(R.id.button_answer5);
        button_back = findViewById(R.id.button_back);

        questionTextView.setText(question[questionnum]);
        answer1Button.setText(answer[questionnum][0]);
        answer2Button.setText(answer[questionnum][1]);
        answer3Button.setText(answer[questionnum][2]);
        answer4Button.setText(answer[questionnum][3]);
        answer5Button.setText(answer[questionnum][4]);

        final Intent myIntent = new Intent(this, surveyresult.class);

        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionnum++;
                count[0]++;
                if(questionnum == 9){
                    myIntent.putExtra("genreresult",getresult());
                    startActivity(myIntent);
                }
                showproblem();
            }
        });

        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionnum++;
                count[1]++;
                if(questionnum == 9){
                    myIntent.putExtra("genreresult",getresult());
                    startActivity(myIntent);
                }
                showproblem();
            }
        });

        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionnum++;
                count[2]++;
                if(questionnum == 9){
                    myIntent.putExtra("genreresult",getresult());
                    startActivity(myIntent);
                }
                showproblem();
            }
        });

        answer4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionnum++;
                count[3]++;
                if(questionnum == 9){
                    myIntent.putExtra("genreresult",getresult());
                    startActivity(myIntent);
                }
                showproblem();
            }
        });

        answer5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionnum++;
                count[4]++;
                if(questionnum == 9){
                    myIntent.putExtra("genreresult",getresult());
                    startActivity(myIntent);
                }
                showproblem();
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent surveyintent = new Intent(survey.this, MainActivity.class);
                startActivity(surveyintent);
            }
        });
    }

    void  showproblem(){
        questionTextView.setText(question[questionnum]);
        answer1Button.setText(answer[questionnum][0]);
        answer2Button.setText(answer[questionnum][1]);
        answer3Button.setText(answer[questionnum][2]);
        answer4Button.setText(answer[questionnum][3]);
        answer5Button.setText(answer[questionnum][4]);
    }

    String getresult(){
        int max = count[0];
        for(int i=0; i<4; i++){
            if(max<count[i+1]){
                max = count[i+1];
            }
        }
        if(count[0] == max){
            return "드라마";
        }
        else if(count[1] == max){
            return "코미디";
        }
        else if(count[2] == max){
            return "공포/스릴러";
        }
        else if(count[3] == max){
            return "추리";
        }
        else {
            return "판타지";
        }
    }
}