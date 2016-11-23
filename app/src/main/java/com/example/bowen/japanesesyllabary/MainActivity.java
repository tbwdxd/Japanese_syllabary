package com.example.bowen.japanesesyllabary;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class list {
    CharSequence[] index;
    CharSequence[] pronunciation;
    int[] totaltime;
    int[] correctime;
    int total;
    int correct;
}
class sing{
    int totaltime;
    int correctime;
}
/*public class EditNameDialog extends DialogFragment {

    private EditText editText;

    public EditNameDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_name, container);
        editText = (EditText) view.findViewById(R.id.txt_yourName);

        // Request focus and show soft keyboard automatically
        editText.requestFocus();
        getDialog().getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        return view;
    }
}*/

public class MainActivity extends AppCompatActivity {

    public list load = new list();
    public int current = 0;
    public int count = 3;
    private boolean is_hinted =false;
    private boolean is_checked = false;
    private ColorStateList oldColors;
    List waitingqueue = new ArrayList<>();
    CharSequence Answer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //first time initialization
        waitingqueue.add(0);//1 element with 0 means new record
        initialization_list();
        computecorre();
        nextletter();
        TextView ED = (TextView)findViewById(R.id.textView6);
        oldColors =  ED.getTextColors();
        ED.setTextColor(Color.parseColor("#4CAF50"));
        ED.setText("Input Your Answer");
        String locationProvider = LocationManager.NETWORK_PROVIDER;
        // Or use LocationManager.GPS_PROVIDER
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().setLocation(lastKnownLocation).build();
        mAdView.loadAd(adRequest);


        //print text
        final Button buttonCF = (Button) findViewById(R.id.buttonCF);
        final Button buttonRS = (Button) findViewById(R.id.buttonRS);
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button5 = (Button) findViewById(R.id.button5);
        final Button button6 = (Button) findViewById(R.id.button6);
        final Button button7 = (Button) findViewById(R.id.button7);
        final Button button8 = (Button) findViewById(R.id.button8);
        final Button button9 = (Button) findViewById(R.id.button9);
        final Button button10 = (Button) findViewById(R.id.button10);
        final Button button11 = (Button) findViewById(R.id.button11);
        final Button button12 = (Button) findViewById(R.id.button12);
        final Button button13 = (Button) findViewById(R.id.button13);
        final Button button14 = (Button) findViewById(R.id.button14);
        final Button button15 = (Button) findViewById(R.id.button15);
        final Button button16 = (Button) findViewById(R.id.button16);
        final Button button17 = (Button) findViewById(R.id.button17);
        final Button button18 = (Button) findViewById(R.id.button18);
        final Button button19 = (Button) findViewById(R.id.button19);
        final Button button20 = (Button) findViewById(R.id.button20);
        final Button button21 = (Button) findViewById(R.id.button21);


        //final EditText edittext = (EditText) findViewById(R.id.editText);
        //button function
        buttonCF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                observation();
            }
        });
        buttonRS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer = "";
                TextView ED = (TextView)findViewById(R.id.textView6);
                ED.setTextColor(oldColors);
                ED.setText(Answer);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("a");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("i");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("u");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("e");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("o");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("y");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("h");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("k");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("s");
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("t");
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("c");
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("m");
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("n");
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("r");
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("w");
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("g");
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("z");
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("j");
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("d");
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("b");
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonaction("p");
            }
        });

        //press enter
        /*edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    observation();
                }
                return false;
            }
        });*/
        //catch back focus
    }
    private void buttonaction(String buttontext){
        if(Answer.length()==3 && !is_checked) {
            Toast.makeText(getApplicationContext(),
                    "too long",Toast.LENGTH_SHORT).show();
            return;
        }
        String temp = "";
        if(!is_checked)
            temp = Answer.toString() + buttontext;
        else {
            temp = buttontext;
            is_checked = false;
        }
        Answer = temp;
        TextView ED = (TextView)findViewById(R.id.textView6);
        ED.setTextColor(oldColors);
        ED.setText(Answer);
    }
    public void observation(){
        TextView ED = (TextView)findViewById(R.id.textView6);
        String ss = (String)load.pronunciation[current];
        if(Answer.equals(ss)) {

            if(is_hinted==true)
                is_hinted=false;
            else {
                load.correctime[current]++;
                load.correct++;
                load.totaltime[current]++;
                load.total++;
            }
            count =3;
            nextletter();
            //clear edit
            Answer = "";
            ED.setText("Input Your Answer");

        }
        else{
            String temp ="Wrong Answer, You have "+(count-1)+" time(s) to get the correct one.";
            Toast.makeText(getApplicationContext(),
                   temp,Toast.LENGTH_SHORT).show();
            is_checked = true;
            count --;
            if (count <=0){
                CharSequence x = load.pronunciation[current];

                ED.setTextColor(Color.parseColor("#4CAF50"));
                ED.setText(x);
                Answer=x;
                load.totaltime[current]++;
                load.total++;
                count = 3;
                is_hinted =true;
            }
        }
        computecorre();
    }
    public void initialization_list(){
       /*CharSequence[] x ={
                    "あ", "い", "う", "え", "お",
                    "ア", "イ", "ウ", "エ", "オ",
                    "か", "き", "く", "け", "こ",
                    "カ", "キ", "ク", "ケ", "コ",
                    "さ", "し", "す", "せ", "そ",
                    "サ", "シ", "ス", "セ", "ソ",
                    "た", "ち", "つ", "て", "と",
                    "タ", "チ", "ツ", "テ", "ト",
                    "な", "に", "ぬ", "ね", "の",
                    "ナ", "ニ", "ヌ", "ネ", "ノ",
                    "は", "ひ", "ふ", "へ", "ほ",
                    "ハ", "ヒ", "フ", "ヘ", "ホ",
                    "ま", "み", "む", "め", "も",
                    "マ", "ミ", "ム", "メ", "モ",
                    "や", "ゆ", "よ",
                    "ヤ", "ユ", "ヨ",
                    "ら", "り", "る", "れ", "ろ",
                    "ラ", "リ", "ル", "レ", "ロ",
                    "わ",
                    "ワ",
                    "ん",
                    "ン",
                    "が", "ぎ", "ぐ", "げ", "ご",
                    "ガ", "ギ", "グ", "ゲ", "ゴ",
                    "ざ", "じ", "ず", "ぜ", "ぞ",
                    "ザ", "ジ", "ズ", "ゼ", "ゾ",
                    "だ", "ぢ", "づ", "で", "ど",
                    "ダ", "ヂ", "ヅ", "デ", "ド",
                    "ば", "び", "ぶ", "べ", "ぼ",
                    "バ", "ビ", "ブ", "ベ", "ボ",
                    "ぱ", "ぴ", "ぷ", "ぺ", "ぽ",
                    "パ", "ピ", "プ", "ペ", "ポ",
                    "きゃ", "きゅ", "きょ",
                    "キャ", "キュ", "キョ",
                    "しゃ", "しゅ", "しょ",
                    "シャ", "シュ", "ショ",
                    "ちゃ", "ちゅ", "ちょ",
                    "チャ", "チュ", "チョ",
                    "にゃ", "にゅ", "にょ",
                    "ニャ", "ニュ", "ニョ",
                    "ひゃ", "ひゅ", "ひょ",
                    "ヒャ", "ヒュ", "ヒョ",
                    "みゃ", "みゅ", "みょ",
                    "ミャ", "ミュ", "ミョ",
                    "りゃ", "りゅ", "りょ",
                    "リャ", "リュ", "リョ",
                    "ぎゃ", "ぎゅ", "ぎょ",
                    "ギャ", "ギュ", "ギョ",
                    "じゃ", "じゅ", "じょ",
                    "ジャ", "ジュ", "ジョ",
                    "ぢゃ", "ぢゅ", "ぢょ",
                    "ヂャ", "ヂュ", "ヂョ",
                    "びゃ", "びゅ", "びょ",
                    "ビャ", "ビュ", "ビョ",
                    "ぴゃ", "ぴゅ", "ぴょ",
                    "ピャ", "ピュ", "ピュ"
        };*/
        CharSequence[] x ={
                "あ", "い", "う", "え", "お",
                "ア", "イ", "ウ", "エ", "オ",
                "か", "き", "く", "け", "こ"};
       load.index = x;
        CharSequence[] y = {
                "a", "i", "u", "e", "o",
                "a", "i", "u", "e", "o",
                "ka", "ki", "ku", "ke", "ko"};
       /*CharSequence[] y = {
                "a", "i", "u", "e", "o",
                "a", "i", "u", "e", "o",
                "ka", "ki", "ku", "ke", "ko",
                "ka", "ki", "ku", "ke", "ko",
                "sa", "shi", "su", "se", "so",
                "sa", "shi", "su", "se", "so",
                "ta", "chi", "tsu", "te", "to",
                "ta", "chi", "tsu", "te", "to",
                "na", "ni", "nu", "ne", "no",
                "na", "ni", "nu", "ne", "no",
                "ha", "hi", "hu", "he", "ho",
                "ha", "hi", "hu", "he", "ho",
                "ma", "mi", "mu", "me", "mo",
                "ma", "mi", "mu", "me", "mo",
                "ya", "yu", "yo",
                "ya", "yu", "yo",
                "ra", "ri", "ru", "re", "ro",
                "ra", "ri", "ru", "re", "ro",
                "wa",
                "wa",
                "nn",
                "nn",
                "ga", "gi", "gu", "ge", "go",
                "ga", "gi", "gu", "ge", "go",
                "za", "ji", "zu", "ze", "zo",
                "za", "ji", "zu", "ze", "zo",
                "da", "di", "du", "de", "do",
                "da", "di", "du", "de", "do",
                "ba", "bi", "bu", "be", "bo",
                "ba", "bi", "bu", "be", "bo",
                "pa", "pi", "pu", "pe", "po",
                "pa", "pi", "pu", "pe", "po",
                "kya", "kyu", "kyo",
                "kya", "kyu", "kyo",
                "sha", "shu", "sho",
                "sha", "shu", "sho",
                "cha", "chu", "cho",
                "cha", "chu", "cho",
                "nya", "nyu", "nyo",
                "nya", "nyu", "nyo",
                "hya", "hyu", "hyo",
                "hya", "hyu", "hyo",
                "mya", "myu", "myo",
                "mya", "myu", "myo",
                "rya", "ryu", "ryo",
                "rya", "ryu", "ryo",
                "gya", "gyu", "gyo",
                "gya", "gyu", "gyo",
                "ja", "ju", "jo",
                "ja", "ju", "jo",
                "dya", "dyu", "dyo",
                "dya", "dyu", "dyo",
                "bya", "byu", "byo",
                "bya", "byu", "byo",
                "pya", "pyu", "pyo",
                "pya", "pyu", "pyo"
        };*/
        //keymap = "a","i","u","e","o","k","s","h","t","c","n","m","y","r","w","g","z","j","d","b","p";
        load.pronunciation = y;
        load.correctime = new int[x.length];
        load.totaltime = new int[x.length];
        for (int i = 0; i < x.length; i++){
            load.correctime[i] = 0;
            load.totaltime[i] = 0;
        }
        load.correct = load.total = 0;
    }


    public void computecorre(){
        double correct_rate;
        if (load.total >0)
            correct_rate = (double)load.correct / load.total;
        else
            correct_rate = 1;
        correct_rate *= 100;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        //correctness Display
        TextView correctness = (TextView)findViewById(R.id.textView2);
        correctness.setText(String.valueOf(df.format(correct_rate)));
    }

    public void nextletter(){
        if (waitingqueue.size() == 1){//only 1 left in queue
            if((Integer)waitingqueue.get(0) > 14)//reach to the last char
                waitingqueue.set(0,1);//loop over
            int times = (int)waitingqueue.get(0);
            int next = 0;
            List temp = new ArrayList<>();
            for (int i =0;i<4;i++)
                temp.add(0,i+times);
            Collections.shuffle(temp);
            waitingqueue.addAll(0,temp);
            temp = new ArrayList<>();
            for (int i =0;i<4;i++) {
                temp.add(0, i + times);
                next = i + times;
            }
            Collections.shuffle(temp);
            waitingqueue.addAll(0,temp);
            waitingqueue.set(waitingqueue.size()-1,next+1);
            current = (int)waitingqueue.get(0);
            waitingqueue.remove(0);
            //waitingqueue.remove(0);
        }
        else{
            current = (int)waitingqueue.get(0);
            waitingqueue.remove(0);

        }
        //helper for debug tracking the queue
        TextView AA = (TextView)findViewById(R.id.textView5);
        String bb="";
        for (int i=0; i<waitingqueue.size(); i++) {
            String aa = ""+waitingqueue.get(i);
            bb += aa;
        }
        AA.setText(bb+"//"+load.total+"//"+load.correct);

        //Render Text
        TextView currentC = (TextView)findViewById(R.id.textView4);
        CharSequence x = load.index[current];
        currentC.setText(x);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
