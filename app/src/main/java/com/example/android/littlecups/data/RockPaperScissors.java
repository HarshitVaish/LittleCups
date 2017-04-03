package com.example.android.littlecups.data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android.littlecups.R;

public class RockPaperScissors extends AppCompatActivity {
    Button b_Rock, b_Paper, b_Scissors;
ImageView iv_Cpu,iv_Player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        iv_Cpu=(ImageView)findViewById(R.id.iv_cpu);
        iv_Player=(ImageView)findViewById(R.id.iv_player);

        b_Rock=(Button)findViewById(R.id.b_rock);
        b_Paper=(Button)findViewById(R.id.b_paper);
        b_Scissors=(Button)findViewById(R.id.b_sccissor);

    }
}
