package br.usjt.deswebmob.servicedeskcco.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static br.usjt.deswebmob.servicedeskcco.model.FilaDbContract.FilaBanco;
import static java.lang.Math.sqrt;
/**
 * Created by arqdsis on 11/04/2018.
 */


public class FilaDbHelper extends SQLiteOpenHelper {


    public static final String SQL_CREATE_FILA =
            "CREATE TABLE " + FilaBanco.TABLE_NAME + " ( " +
                    FilaBanco._ID + " INTEGER PRIMARY KEY, " +
                    FilaBanco.ID_FILA + " INTEGER, " +
                    FilaBanco.NM_FILA + " TEXT, " +
                    FilaBanco.FG_FILA + " TEXT," +
                    FilaBanco.IMG_FIGURA + " BLOB )";

    public static final String SQL_DROP_FILA =
            "DOP TABLE IF EXISTS " + FilaBanco.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Fila.db";

    public FilaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_FILA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_FILA);
        sqLiteDatabase.execSQL(SQL_CREATE_FILA);
    }
}
