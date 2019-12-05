package com.example.fracciones2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.github.kexanie.library.MathView;

public class MainActivity extends AppCompatActivity {
    MathView pregunta,solucion;
    Button btnVerdad, btnFalso, btnSiguiente;
    TextView titulo,titulo2;
    int a,b,c,d;
    String operacionCorrecta;
    Boolean respuestaCorrecta=false;
    String tex = " $$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFalso=(Button)findViewById(R.id.botonFalso);
        btnVerdad=(Button)findViewById(R.id.botonVerdad);
        btnSiguiente=(Button)findViewById(R.id.buttonSiguiente);
        pregunta=(MathView)findViewById(R.id.formula_one);
        solucion = (MathView) findViewById(R.id.formula_two);
        titulo=(TextView)findViewById(R.id.operacionTitulo);
        titulo2=(TextView)findViewById(R.id.titulo2);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulo2.setVisibility(View.INVISIBLE);
                inicio();
                seleccionaOperacion();
            }
        });

        btnVerdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulo2.setVisibility(View.VISIBLE);
             if(respuestaCorrecta){

                 titulo2.setText(R.string.correcto);
                 solucion.setVisibility(View.INVISIBLE);
             }else {

                 titulo2.setText(R.string.error);
                 solucion.setVisibility(View.VISIBLE);
                 solucion.setText(operacionCorrecta);

             }
                btnFalso.setVisibility(View.INVISIBLE);
                btnVerdad.setVisibility(View.INVISIBLE);
             respuestaCorrecta=false;
            }
        });

        btnFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        inicio();
    }

    public void inicio(){
        titulo2.setText("");
        solucion.setText("");

       //btnSiguiente.setVisibility(View.INVISIBLE);
       seleccionaOperacion();
    }

    public void seleccionaOperacion(){
        int i= (int) (Math.random()*3);
        switch (i){

            case 0:
                generaNumeros();
                fraccionSobreFraccion();
            break;

            case 1:
                generaNumeros();
                enteroSobreFraccion();
            break;

            case 2:
                generaNumeros();
                fraccionSobreEntero();
            break;
        }
        titulo2.setVisibility(View.INVISIBLE);
        solucion.setVisibility(View.INVISIBLE);
        btnFalso.setVisibility(View.VISIBLE);
        btnVerdad.setVisibility(View.VISIBLE);

    }

    public void fraccionSobreFraccion(){
        titulo.setText(R.string.tituloFracSobreFrac);
        String operacion="";
        int i=(int)(Math.random()*4+1);

        switch (i){
            case 1:
            operacion="$$\\LARGE{\\frac{\\frac{"+a+"}{"+b+"}}{\\frac{"+c+"}{"+d+"}}=\\frac{"+a+"*"+d+"}{"+b+"*"+c+"}}$$";
            respuestaCorrecta=true;
            break;

            case 2:
            operacion="$$\\LARGE{\\frac{\\frac{"+a+"}{"+b+"}}{\\frac{"+c+"}{"+d+"}}=\\frac{"+a+"*"+c+"}{"+b+"*"+d+"}}$$";
            respuestaCorrecta=false;
            break;

            case 3:
            operacion="$$\\LARGE{\\frac{\\frac{"+a+"}{"+b+"}}{\\frac{"+c+"}{"+d+"}}=\\frac{"+a+"*"+b+"}{"+d+"*"+c+"}}$$";
            respuestaCorrecta=false;
            break;

            case 4:
            operacion="$$\\LARGE{\\frac{\\frac{"+a+"}{"+b+"}}{\\frac{"+c+"}{"+d+"}}=\\frac{"+a*d+"}{"+b*c+"}}$$";
            respuestaCorrecta=true;
            break;

            case 5:
            operacion="$$\\LARGE{\\frac{\\frac{"+a+"}{"+b+"}}{\\frac{"+c+"}{"+d+"}}=\\frac{"+b+"*"+d+"}{"+a+"*"+c+"}}$$";
            respuestaCorrecta=false;
            break;
        }
        operacionCorrecta="$$\\LARGE{\\frac{\\frac{\\color{red}{"+a+"}}{\\color{green}{"+b+"}}}{\\frac{\\color{green}{"+c+"}}{\\color{red}{"+d+"}}}=\\frac{\\color{red}{"+a+"}*\\color{red}{"+d+"}}{\\color{green}{"+b+"}*\\color{green}{"+c+"}}}=\\frac{"+a*d+"}{"+b*c+"}$$";
        pregunta.setText(operacion);

    }

    public void enteroSobreFraccion() {
        titulo.setText(R.string.tituloEnteroSobreFrac);
        String operacion = "";
        int i = (int) (Math.random() * 4 + 1);

        switch (i) {

            case 1:
                operacion = "$$\\LARGE{\\frac{" + a + "}{\\frac{" + b + "}{" + c + "}}=\\frac{" + a + "*" + c + "}{" + b + "}}$$";
                respuestaCorrecta = true;
                break;

            case 2:
                operacion = "$$\\LARGE{\\frac{" + a + "}{\\frac{" + b + "}{" + c + "}}=\\frac{" + c + "}{" + a + "*" + b + "}}$$";
                respuestaCorrecta = false;
                break;

            case 3:
                operacion = "$$\\LARGE{\\frac{" + a + "}{\\frac{" + b + "}{" + c + "}}=\\frac{" + a + "}{" + b + "*" + c + "}}$$";
                respuestaCorrecta = false;
                break;

            case 4:
                operacion = "$$\\LARGE{\\frac{" + a + "}{\\frac{" + b + "}{" + c + "}}=\\frac{" + b + "}{" + a + "*" + c + "}}$$";
                respuestaCorrecta = false;
                break;

            case 5:
                operacion = "$$\\LARGE{\\frac{" + a + "}{\\frac{" + b + "}{" + c + "}}=\\frac{" + a * +c + "}{" + b + "}}$$";
                respuestaCorrecta = true;
                break;
        }
            operacionCorrecta = "$$\\LARGE{\\frac{\\color{red}{" + a + "}}{\\frac{" + b + "}{\\color{red}{" + c + "}}}=\\frac{\\color{red}{" + a + "}*\\color{red}{" + c + "}}{" + b + "}}=\\frac{"+a*c+"}{"+b+"}$$";
            pregunta.setText(operacion);

    }
    public void fraccionSobreEntero(){
        titulo.setText(R.string.tituloFracSobreEntero);
        String operacion = "";
        int i = (int) (Math.random() * 4 + 1);

        switch (i) {

            case 1:
                operacion="$$\\LARGE{\\frac{\\frac{"+a+"}{"+b+"}}{"+c+"}}=\\frac{"+a+"}{"+b+"*"+c+"}$$";
                respuestaCorrecta = true;
                break;

            case 2:
                operacion = "$$\\LARGE{\\frac{\\frac{"+a+"}{"+b+"}}{"+c+"}}=\\frac{"+b+"}{"+a+"*"+c+"}$$";
                respuestaCorrecta = false;
                break;

            case 3:
                operacion = "$$\\LARGE{\\frac{\\frac{"+a+"}{"+b+"}}{"+c+"}}=\\frac{"+a+"*"+c+"}{"+b+"}$$";
                respuestaCorrecta = false;
                break;

            case 4:
                operacion = "$$\\LARGE{\\frac{\\frac{"+a+"}{"+b+"}}{"+c+"}}=\\frac{"+c+"*"+b+"}{"+a+"}$$";
                respuestaCorrecta = false;
                break;

            case 5:
                operacion ="$$\\LARGE{\\frac{\\frac{"+a+"}{"+b+"}}{"+c+"}}=\\frac{"+a+"}{"+b*c+"}$$";
                respuestaCorrecta = true;
                break;
        }
        operacionCorrecta = "$$\\LARGE{\\frac{\\frac{"+a+"}{\\color{red}{"+b+"}}}{\\color{green}{"+c+"}}}=\\frac{"+a+"}{\\color{red}{"+b+"}*\\color{green}{"+c+"}}$$";
        pregunta.setText(operacion);
    }

    public void generaNumeros(){
        a=b=c=d=0;
        while (a==b || a==c || a==d || b==c || b==d || c==d){
        a=(int)(Math.random()*9+1);
        b=(int)(Math.random()*9+1);
        c=(int)(Math.random()*9+1);
        d=(int)(Math.random()*9+1);}

    }
}
