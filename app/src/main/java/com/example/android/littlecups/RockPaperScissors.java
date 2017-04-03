package com.example.android.littlecups;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class RockPaperScissors extends AppCompatActivity {
    Button b_Rock, b_Paper, b_Scissors;
    ImageView iv_Cpu, iv_Player;
    String myChoice, cpuChoice, result;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityrockpaperscissors);

        iv_Cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_Player = (ImageView) findViewById(R.id.iv_player);

        b_Rock = (Button) findViewById(R.id.b_rock);
        b_Paper = (Button) findViewById(R.id.b_paper);
        b_Scissors = (Button) findViewById(R.id.b_sccissor);
        r = new Random();

        b_Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChoice = "rock";
                calculate();
                iv_Player.setImageResource(R.drawable.rockhand);
            }
        });
        b_Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChoice = "paper";
                calculate();
                iv_Player.setImageResource(R.drawable.paperhand);

            }
        });
        b_Scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChoice = "scissors";
                calculate();
                iv_Player.setImageResource(R.drawable.scissorshand);

            }
        });
    }

    public void calculate() {
        int cpu = r.nextInt(3);
        if (cpu == 0) {
            cpuChoice = "rock";
            iv_Cpu.setImageResource(R.drawable.rockhand);
        } else if (cpu == 1) {
            cpuChoice = "paper";
            iv_Cpu.setImageResource(R.drawable.paperhand);
        } else if (cpu == 2) {
            cpuChoice = "scissors";
            iv_Cpu.setImageResource(R.drawable.scissorshand);
        }
        if (myChoice.equalsIgnoreCase("rock") && cpuChoice.equalsIgnoreCase("paper")) {
            result = "you loose";
        }
        if (myChoice.equalsIgnoreCase("rock") && cpuChoice.equalsIgnoreCase("scissors")) {
            result = "you win";
        }
        if (myChoice.equalsIgnoreCase("rock") && cpuChoice.equalsIgnoreCase("rock")) {
            result = "match draw";
        } else if (myChoice.equalsIgnoreCase("paper") && cpuChoice.equalsIgnoreCase("scissors")) {
            result = "you loose";
        } else if (myChoice.equalsIgnoreCase("paper") && cpuChoice.equalsIgnoreCase("rock")) {
            result = "you win";
        } else if (myChoice.equalsIgnoreCase("paper") && cpuChoice.equalsIgnoreCase("paper")) {
            result = "match draw";
        } else if (myChoice.equalsIgnoreCase("scissors") && cpuChoice.equalsIgnoreCase("rock")) {
            result = "you loose";
        } else if (myChoice.equalsIgnoreCase("scissors") && cpuChoice.equalsIgnoreCase("paper")) {
            result = "you win";
        } else if (myChoice.equalsIgnoreCase("scissors") && cpuChoice.equalsIgnoreCase("scissors")) {
            result = "match draw";
        }
        Toast.makeText(RockPaperScissors.this, result, Toast.LENGTH_SHORT).show();
    }
}

