package br.edu.ifma.dai.maurolcsilva.projetocalculadoracontratacoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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
    private CheckBox chk01,chk02,chk03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Recuperar do XML e vincular ao Java
        txtNomeContratado = findViewById(R.id.txtNomeContratado);
        txtSalario = findViewById(R.id.txtSalarioContratado);
        spnMeses = findViewById(R.id.spnMesdeEntrada);
        chk01 = findViewById(R.id.chkOpcao01);
        chk02 = findViewById(R.id.chkOpcao02);
        chk03 = findViewById(R.id.chkOpcao03);
        //Criação dos dados da caixa de selecao
        String meses[] = {"Janeiro","Fevereiro","Março"};
        //Craição do ArrayAdapter
        ArrayAdapter<String> meuadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,meses);
        //Associar o Adapter ao Spinner
        spnMeses.setAdapter(meuadapter);
        rdgExAluno = findViewById(R.id.rdgExAluno);
    }

    public void calcularSalario(View v){
        int opcao;
        String msg="",mes="",nomeContratado="",resultadoselecao="";

        nomeContratado = txtNomeContratado.getText().toString();
        //Recupera o que foi selecionado no Spinner
        mes = spnMeses.getSelectedItem().toString();
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
        if (chk01.isChecked()){
            resultadoselecao = chk01.getText().toString();
        }
        if (chk02.isChecked()){
            resultadoselecao = resultadoselecao + " " + chk02.getText().toString();
        }
        if (chk03.isChecked()){
            resultadoselecao = resultadoselecao + " " + chk03.getText().toString();
        }
        msg = msg + " " + mes + " " + resultadoselecao;
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }
}
