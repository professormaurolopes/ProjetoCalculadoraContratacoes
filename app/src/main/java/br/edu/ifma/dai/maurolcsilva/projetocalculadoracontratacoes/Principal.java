package br.edu.ifma.dai.maurolcsilva.projetocalculadoracontratacoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private EditText txtNomeContratado;
    private EditText txtSalario;
    private Spinner spnMeses;
    private RadioGroup rdgExAluno;
    private Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Recuperar do XML e vincular ao Java
        txtNomeContratado = findViewById(R.id.txtNomeContratado);
        txtSalario = findViewById(R.id.txtSalarioContratado);
        spnMeses = findViewById(R.id.spnMesdeEntrada);
        rdgExAluno = findViewById(R.id.rdgExAluno);
    }

    public void calcularSalario(View v){
        int opcao;
        String msg="";

        opcao = rdgExAluno.getCheckedRadioButtonId();
        switch (opcao){
            case R.id.rdSim:
                //Apertou no SIM
                msg = "Ex-Aluno";
                break;
            case R.id.rdNao:
                //Apertou no Não
                msg = "Não é Ex-Aluno";
                break;
        }
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }
}
