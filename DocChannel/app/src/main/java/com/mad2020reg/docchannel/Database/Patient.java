package com.mad2020reg.docchannel.Database;

import android.provider.BaseColumns;

public final class Patient {

    private Patient(){}

    public static class PatientDetails implements BaseColumns{
        public static final String TABLE_NAME = "patients";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_AGE = "age";
        public static final String COLUMN_NAME_CONTACT = "contact";

    }
}
