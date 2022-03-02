package com.example.fivecalendar;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import java.util.Calendar;

public class SemanaActivity extends AppCompatActivity {

    private Calendar fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semana);

        fecha = Calendar.getInstance();
    }

    public void verDiaSemana(View view) {
        final Resources res = getResources();
        final String diaSemanaString = res.getResourceEntryName(view.getId());
        int diaSemana = -1;
        int diasDesdeDomingo = 0;
        boolean esDomingo = false;
        switch (diaSemanaString) {
            case "Lunes":
                diaSemana = Calendar.MONDAY;
                diasDesdeDomingo = -6;
                break;
            case "Martes":
                diaSemana = Calendar.TUESDAY;
                diasDesdeDomingo = -5;
                break;
            case "Miercoles":
                diaSemana = Calendar.WEDNESDAY;
                diasDesdeDomingo = -4;
                break;
            case "Jueves":
                diaSemana = Calendar.THURSDAY;
                diasDesdeDomingo = -3;
                break;
            case "Viernes":
                diaSemana = Calendar.FRIDAY;
                diasDesdeDomingo = -2;
                break;
            case "Sabado":
                diaSemana = Calendar.SATURDAY;
                diasDesdeDomingo = -1;
                break;
            case "Domingo":
                diaSemana = Calendar.SATURDAY;
                diasDesdeDomingo = 1;
                esDomingo = true;
                break;
            default:
                diasDesdeDomingo = -7;
                break;
        }

        if (fecha.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            fecha.set(Calendar.DAY_OF_WEEK, diaSemana);
            if (esDomingo) {
                fecha.add(Calendar.DAY_OF_YEAR, diasDesdeDomingo);
            }
        } else {
            fecha.add(Calendar.DAY_OF_YEAR, diasDesdeDomingo);
        }
        int[] afecha = {fecha.get(Calendar.DATE), fecha.get(Calendar.MONTH), fecha.get(Calendar.YEAR)};
        Intent intent = new Intent(SemanaActivity.this, DiaActivity.class);
        intent.putExtra("fecha", afecha);
        startActivity(intent);
    }
}
