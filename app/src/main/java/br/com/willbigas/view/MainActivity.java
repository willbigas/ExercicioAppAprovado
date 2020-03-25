package br.com.willbigas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.willbigas.R;
import br.com.willbigas.controller.AlunoController;
import br.com.willbigas.model.Aluno;

public class MainActivity extends AppCompatActivity {

    private AlunoController alunoController;
    private Aluno aluno;

    private EditText editNomeAluno;
    private EditText editTextNota1;
    private EditText editTextNota2;

    private TextView textViewNomeAluno;
    private TextView textViewMediaAluno;
    private TextView textViewSituacaoAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        alunoController = new AlunoController();

        editNomeAluno = findViewById(R.id.editNomeAluno);
        editTextNota1 = findViewById(R.id.editTextNota1);
        editTextNota2 = findViewById(R.id.editTextNota2);

        textViewNomeAluno = findViewById(R.id.textViewNomeAluno);
        textViewMediaAluno = findViewById(R.id.textViewMediaAluno);
        textViewSituacaoAluno = findViewById(R.id.textViewSituacaoAluno);
    }

    public void calcular(View view) {
        if (validarDadosDaView()) {
            receberDadosDaView();
            aluno = alunoController.calcular(aluno);
            exibirDadosNaView();
        }
    }

    public void limparDados(View view) {
        editNomeAluno.setText("");
        editTextNota1.setText("");
        editTextNota2.setText("");

        textViewNomeAluno.setText("");
        textViewMediaAluno.setText("");
        textViewSituacaoAluno.setText("");
    }

    public boolean validarDadosDaView() {
        boolean foiValidado = true;

        if (editNomeAluno.getText().toString() == null || editNomeAluno.getText().toString().equals("")) {
            editNomeAluno.setError(getString(R.string.required_nomeAluno));
            foiValidado = false;
        }

        if (editTextNota1.getText().toString() == null || editTextNota1.getText().toString().equals("")) {
            editTextNota1.setError(getString(R.string.required_nota1));
            foiValidado = false;
        }

        if (editTextNota2.getText().toString() == null || editTextNota2.getText().toString().equals("")) {
            editTextNota2.setError(getString(R.string.required_nota2));
            foiValidado = false;
        }
        return foiValidado;
    }


    private void receberDadosDaView() {
        aluno = new Aluno(editNomeAluno.getText().toString(), Double.valueOf(editTextNota1.getText().toString()), Double.valueOf(editTextNota2.getText().toString()));
    }

    private void exibirDadosNaView() {
        textViewNomeAluno.setText(aluno.getNome());
        textViewMediaAluno.setText(aluno.getMedia().toString());
        textViewSituacaoAluno.setText(aluno.getSituacao().getDescricao());
    }
}
