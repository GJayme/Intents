package br.edu.ifsp.ads.pdm.intents;

import static br.edu.ifsp.ads.pdm.intents.MainActivity.PARAMETRO;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.ads.pdm.intents.databinding.ActivityOutraBinding;


public class OutraActivity extends AppCompatActivity {
    private ActivityOutraBinding activityOutraBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOutraBinding = ActivityOutraBinding.inflate(getLayoutInflater());
        setContentView(activityOutraBinding.getRoot());

        getSupportActionBar().setTitle("Outra Activity");
        getSupportActionBar().setSubtitle("Recebe e retorna um valor");

        activityOutraBinding.recebidoTv.setText(getIntent().getStringExtra(PARAMETRO));

        activityOutraBinding.retornarBt.setOnClickListener(view -> {
            String result = activityOutraBinding.retornoEt.getText().toString();

            Intent retornoIntent = new Intent();
            retornoIntent.putExtra(PARAMETRO, result);
            setResult(RESULT_OK, retornoIntent);
            finish();
        });
    }
}
