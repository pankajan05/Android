package com.mad2020reg.docchannel.Database;

import android.provider.BaseColumns;

public final class Channeling {
    private Channeling () {}

    public static class ChannelingDetails implements BaseColumns{
        public static final String TABLE_NAME = "channeling";
        public static final String COLUMN_NAME_PATIENT_ID ="pid";
        public static final String COLUMN_NAME_DATE ="date";
        public static final String COLUMN_NAME_DOC_CAT ="category";
        public static final String COLUMN_NAME_DOCTOR ="doctor";
        public static final String COLUMN_NAME_TOTAL = "total";



    }
}
