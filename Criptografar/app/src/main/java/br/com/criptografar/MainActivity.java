package br.com.criptografar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText fraseOriginal, frasecriptografada, fraseDescriptograda, frasecriptografada2, valorChaveCrip, valorChaveDescrip;
    Button btCrip, btDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// Comando para deixa a tela em FullScreen.
        setContentView(R.layout.activity_main);

        inciaComponentes();// Chamando o função para iniciar os compinentes da tela.
    }

    public void criptografa(View view) { //Esse função server para cripitografar uma String, ele recebe por paremetro um "CLICK" com View.

        int cifra = 0;//Variavel do tipo INT para armazenar a chave da criptografia.

        String frase = fraseOriginal.getText().toString();//Convertendo e armazenando a frase em STRING.


        /*IF para penas para garantir que o valor da chave sera um inteiro para que não haja falha a aplicação.
        "SE" o valor for diferente de vazio, ele pega o valor do campo, coverte para String e depois para INT.
        "SE NÃO,  a variavel "CIFRA" recebe o valor "0". */
        if(!valorChaveCrip.getText().toString().isEmpty()) {
            cifra = Integer.parseInt(valorChaveCrip.getText().toString());
        }else{
            cifra = 0;
        }

        //Esse IF verifica se o usuário digitou uma frase e se o valor da chave e maior que "0", caso não informar um erro na tela.
        if((!frase.isEmpty()) || cifra > 0) {
            int i, n = frase.length();//recebe o tamanho da variavel "frase".
            String saux = "";// Variavel auxiliar.


            //Laço FOR, troca as pocições dos caracteres de acordo com o tamanha da frase eo valor da chave, com o auxilio metodo "charAt".
            for (i = 0; i < n; i++) {
                saux = saux + (char) (frase.charAt(i) + cifra);
            }
            frasecriptografada.setText(saux);// Seta a frase já criptografada na tela.
        }else {
            frasecriptografada.setText("Valores invalidos, tente novamente!");
        }
    }

    public void descriptografa(View view) {//Esse função server para descripitografar uma String, ele recebe por paremetro um "CLICK" com View.

        int cifra;//Variavel do tipo INT para armazenar a chave da criptografia.
        String fraseCrip = frasecriptografada2.getText().toString();//Convertendo e armazenando a frase em STRING.

        /*IF para penas para garantir que o valor da chave sera um inteiro para que não haja falha a aplicação.
        "SE" o valor for diferente de vazio, ele pega o valor do campo, coverte para String e depois para INT.
        "SE NÃO,  a variavel "CIFRA" recebe o valor "0". */
        if(!valorChaveDescrip.getText().toString().isEmpty()) {
            cifra = Integer.parseInt(valorChaveDescrip.getText().toString());
        }else {
            cifra = 0;
        }

        //Esse IF verifica se o usuário digitou uma frase e se o valor da chave e maior que "0", caso não informar um erro na tela.
        if((!fraseCrip.isEmpty()) || cifra > 0) {
            int i, n = fraseCrip.length();//recebe o tamanho da variavel "frase".
            String saux = "";// Variavel auxiliar.

            //Laço FOR, troca as pocições dos caracteres de acordo com o tamanha da frase eo valor da chave, com o auxilio metodo "charAt".
            for (i = 0; i < n; i++) {
                saux = saux + (char) (fraseCrip.charAt(i) - cifra);
            }
            fraseDescriptograda.setText(saux);// Seta a frase já descriptografada na tela.
        }else{
            fraseDescriptograda.setText("Valores invalidos, tente novamente!");
        }
    }

    public void inciaComponentes(){ // Função para iniciar os componentes da tela.
        fraseOriginal = findViewById(R.id.text_fraseOriginal);
        frasecriptografada = findViewById(R.id.text_fraseCript);
        frasecriptografada2 = findViewById(R.id.text_fraseCrip1);
        fraseDescriptograda = findViewById(R.id.text_fraseDescript);
        valorChaveCrip = findViewById(R.id.text_valorChave);
        valorChaveDescrip =findViewById(R.id.text_valorChave1);
        btCrip = findViewById(R.id.Bt_criptografar);
        btDescrip = findViewById(R.id.Bt_Descriptografar);
    }
}