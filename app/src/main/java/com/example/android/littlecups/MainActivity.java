package com.example.android.littlecups;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView left, middle, right;
    List<Integer> cards;
    Button buttonNewGame;
    int streak = 0;
    TextView streakTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = (ImageView) findViewById(R.id.left);
        right = (ImageView) findViewById(R.id.right);
        middle = (ImageView) findViewById(R.id.middle);
        buttonNewGame = (Button) findViewById(R.id.new_game_button);
        streakTextView=(TextView)findViewById(R.id.streak_text_view);
        cards = new ArrayList<>();
        cards.add(107);// Ace of Spades
        cards.add(207);//7 of Hearts
        cards.add(407);//7 of Diamonds

        shuffleCards();

        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shuffleCards();
                left.setImageResource(R.drawable.back_card);
                middle.setImageResource(R.drawable.back_card);
                right.setImageResource(R.drawable.back_card);
                Animation anim_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left);
                Animation anim_middle = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.middle);
                Animation anim_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right);

                left.startAnimation(anim_left);
                middle.startAnimation(anim_middle);
                right.startAnimation(anim_right);
            }
        });


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cards.get(0) == 107) {
                    left.setImageResource(R.drawable.ace_spades);
                    makeToast();
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.heart_of_7);
                    resetStreak();
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.diamonds_of_7);
                    resetStreak();
                }
                // middle card
                if (cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.ace_spades);
                    resetStreak();
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.heart_of_7);
                    resetStreak();
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.diamonds_of_7);
                    resetStreak();
                }

                //Right Cards
                if (cards.get(2) == 107) {
                    right.setImageResource(R.drawable.ace_spades);
                    resetStreak();
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.heart_of_7);
                   resetStreak();
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.diamonds_of_7);
                resetStreak();
                }
            }
        });
        middle.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                // middle card

                if (cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.ace_spades);
                    makeToast();
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.heart_of_7);
                    resetStreak();
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.diamonds_of_7);
                    resetStreak();
                }
                if (cards.get(0) == 107) {
                    left.setImageResource(R.drawable.ace_spades);
                    resetStreak();
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.heart_of_7);
                    resetStreak();
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.diamonds_of_7);
                    resetStreak();
                }
                if (cards.get(2) == 107) {
                    right.setImageResource(R.drawable.ace_spades);
                    resetStreak();
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.heart_of_7);
                    resetStreak();
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.diamonds_of_7);
                    resetStreak();
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                //right card
                if (cards.get(2) == 107) {
                    right.setImageResource(R.drawable.ace_spades);
                    makeToast();
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.heart_of_7);
                    resetStreak();
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.diamonds_of_7);
                    resetStreak();
                }
                if (cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.ace_spades);
                    resetStreak();
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.heart_of_7);
                    resetStreak();
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.diamonds_of_7);
                    resetStreak();
                }
                if (cards.get(0) == 107) {
                    left.setImageResource(R.drawable.ace_spades);
                    resetStreak();
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.heart_of_7);
                    resetStreak();
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.diamonds_of_7);
                    resetStreak();
                }


            }
        });
    }

    public void makeToast() {
        Toast.makeText(MainActivity.this, "Guessed", Toast.LENGTH_SHORT).show();
        streak++;
        streakTextView.setText(""+streak);
    }

    public void resetStreak() {
        streak = 0;
        streakTextView.setText(""+streak);
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }
}
