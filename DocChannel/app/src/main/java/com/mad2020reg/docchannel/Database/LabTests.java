package com.mad2020reg.docchannel.Database;

import android.provider.BaseColumns;

public final class LabTests {
    private LabTests(){}

    public static final class TestDetails implements BaseColumns {
        public static final String TABLE_NAME = "tests";
        public static final String COLUMN_NAME_PID="pid";
        public static final String COLUMN_NAME_DATE="date";
        public static final String COLUMN_NAME_TEST="test";
        public static final String COLUMN_NAME_PRICE="price";

    }
}
