package br.usjt.deswebmob.servicedeskcco.model;

import android.provider.BaseColumns;

/**
 * Created by arqdsis on 11/04/2018.
 */

public final class FilaDbContract {
    public FilaDbContract(){
    }

    public static abstract class FilaBanco implements BaseColumns {
        public static final String TABLE_NAME="fila";
        public static final String ID_FILA = "id_fila";
        public static final String NM_FILA = "nm_fila";
        public static final String FG_FILA = "fg_fila";
        public static final String IMG_FIGURA = "img_figura";
    }
}
