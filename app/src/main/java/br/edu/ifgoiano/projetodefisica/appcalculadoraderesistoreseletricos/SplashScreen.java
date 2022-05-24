package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private RelativeLayout _backgroundSplashScreen;
    private ImageView _imgCalculadora;
    private TextView _txtTituloLinha1;
    private TextView _txtTituloLinha2;
    private TextView _txtTituloLinha3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        _backgroundSplashScreen = findViewById(R.id.backgroundSplahScreen);
        _imgCalculadora = findViewById(R.id.imgCalculadora);
        _txtTituloLinha1 = findViewById(R.id.txtTituloLinha1);
        _txtTituloLinha2 = findViewById(R.id.txtTituloLinha2);
        _txtTituloLinha3 = findViewById(R.id.txtTituloLinha3);

        criaEfeitoDeTransicao();
    }

    private void criaEfeitoDeTransicao() {
        alteraVisibilidadeDoTitulo();
        alteraVisibilidadeDaImagem();
        alteraVisibilidadeDoBackground();
    }

    private void alteraVisibilidadeDoTitulo() {
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                _txtTituloLinha1.animate()
                        .translationY(_txtTituloLinha1.getHeight())
                        .alpha(0.0f)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                _txtTituloLinha1.setVisibility(View.GONE);
                            }
                        });

                _txtTituloLinha2.animate()
                        .translationY(_txtTituloLinha1.getHeight())
                        .alpha(0.0f)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                _txtTituloLinha1.setVisibility(View.GONE);
                            }
                        });

                _txtTituloLinha3.animate()
                        .translationY(_txtTituloLinha1.getHeight())
                        .alpha(0.0f)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                _txtTituloLinha1.setVisibility(View.GONE);
                            }
                        });
            }
        }, 1500);
    }

    private void alteraVisibilidadeDaImagem() {
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {

                _imgCalculadora.animate()
                        .translationY(_imgCalculadora.getHeight())
                        .alpha(0.0f)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                _imgCalculadora.setVisibility(View.GONE);
                            }
                        });
            }
        }, 2000);
    }

    private void alteraVisibilidadeDoBackground() {
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {

                _backgroundSplashScreen.animate()
                        .translationY(_backgroundSplashScreen.getHeight())
                        .alpha(0.0f)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                _backgroundSplashScreen.setVisibility(View.GONE);
                            }
                        });

                abreTelaPrincipal();
            }
        }, 2150);
    }

    private void abreTelaPrincipal() {
        Intent principal = new Intent(this, MainActivity.class);

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(principal);
                finish();
            }
        }, 500);
    }
}