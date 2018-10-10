package com.example.arthurhertz.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActiviteSuivante extends Activity {

    /**
     * Called when the activity is first created.
     */
    Activity lecontext;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2layoout);
        lecontext = this;
        lecontext.setTitle("fenetre 2");
        final Personne florian = new Personne("Guichard","Florian");

        //récupération du text dans le champ de saisie
        Intent i = getIntent();
        Personne arthur = (Personne)i.getSerializableExtra("Personne");

        final EditText textLastName = (EditText) findViewById(R.id.editText);
        final EditText textFirstName = (EditText) findViewById(R.id.editText2);

        textLastName.setText(arthur.getLastName());
        textFirstName.setText(arthur.getFirstName());

        Button btaction = (Button) findViewById(R.id.button);
        //action sur le bouton click appelle de la nouvelle activité
        btaction.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) { //création de notre item
                Intent defineIntent = new Intent(lecontext, MainActivity.class);
                // objet qui vas nous permettre de passe des variables ici la variable passInfo
                defineIntent.putExtra("Personne2", florian);
                // on appelle notre activité
                setResult(MainActivity.RESULT_OK, defineIntent);
                finish();
            }
        });
    }
}
