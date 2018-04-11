package br.usjt.deswebmob.servicedeskcco.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static br.usjt.deswebmob.servicedeskcco.model.FilaDbContract.FilaBanco;

import static java.security.AccessController.getContext;

/**
 * Created by arqdsis on 11/04/2018.
 */

public class FilaDb {
    private FilaDbHelper dbHelper;

    public FilaDb(Context context) {
        dbHelper = new FilaDbHelper(context);
    }

    /**
     *
     * @param filas do mysql, vindas do listarFilas()
     *
     */
    public void inserirFila(ArrayList<Fila> filas) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (Fila f : filas) {
            values.put(FilaBanco.ID_FILA, f.getId());
            values.put(FilaBanco.NM_FILA, f.getNome());
            values.put(FilaBanco.FG_FILA, f.getFigura());

            db.insert(FilaBanco.TABLE_NAME, null, values);
        }

    }

    /**
     *
     * @return lista de Filas do mysql
     */
    public ArrayList<Fila> listarFilas() {
        ArrayList<Fila> filas = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] colunas = {FilaBanco.ID_FILA, FilaBanco.NM_FILA, FilaBanco.FG_FILA};

        String orderBy = FilaBanco.ID_FILA;

        Cursor c;

        c = db.query(FilaBanco.TABLE_NAME, colunas, null, null, null, null, orderBy);

        while (c.moveToNext()){
            Fila fila = new Fila();
            fila.setId(c.getInt(c.getColumnIndex(FilaBanco.ID_FILA)));
            fila.setNome(c.getString(c.getColumnIndex(FilaBanco.NM_FILA)));
            fila.setFigura(c.getString(c.getColumnIndex(FilaBanco.FG_FILA)));

            filas.add(fila);
        }

        c.close();
        db.close();
        return filas;
    }

}
