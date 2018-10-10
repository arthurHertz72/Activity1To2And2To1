package com.example.arthurhertz.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    Activity lecontext;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lecontext = this;
        lecontext.setTitle("fenetre 1");
        final Personne arthur = new Personne("Hertz", "Arthur");
        //récupération du text dans le champ de saisie
        Button btaction = (Button) findViewById(R.id.button);
        //action sur le bouton click appelle de la nouvelle activité
        btaction.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) { //création de notre item
                Intent defineIntent = new Intent(lecontext, ActiviteSuivante.class);
                // objet qui vas nous permettre de passe des variables ici la variable passInfo
                //Bundle objetbunble = new Bundle();
                //objetbunble.putString("passInfo", textchampsaisie.getText().toString()); // on passe notre objet a notre activities
                defineIntent.putExtra("Personne", arthur);
                // on appelle notre activité
                lecontext.startActivityForResult(defineIntent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final EditText textLastName = (EditText) findViewById(R.id.editText);
        final EditText textFirstName = (EditText) findViewById(R.id.editText2);
        // Si le résultat provient d’une demande de la fenêtre1
        if (resultCode == RESULT_OK) { //récupérer les informations
            //et les afficher dans TextView
            //récupération du text dans le champ de saisie
            if(data.hasExtra("Personne2")){
                Personne florian = (Personne)data.getSerializableExtra("Personne2");
                //set object in texte
                textLastName.setText(florian.getLastName());
                textFirstName.setText(florian.getFirstName());
            }
        }
    }
}