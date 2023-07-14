package utils;

import models.CountryIso2;

import static config.Constants.COLUMN_CLOSING_TAG;
import static config.Constants.COLUMN_NAME;
import static config.Constants.COUNTRY_NAME_COLUMN;
import static config.Constants.INSERT_CLOSING_TAG;
import static config.Constants.ISO2_CODE_COLUMN;
import static config.Constants.TABLE_NAME_PREFIX;
import static config.Constants.TABLE_NAME_SUFFIX;
import static config.Constants.VALUE;

public class XmlGenerator {

    public static String generate2columnXml(CountryIso2 countryIso2, String tableName) {
        StringBuilder sb = new StringBuilder();

        String tableInsetTabs = addInsetTabs(2);
        String columnInsetTabs = addInsetTabs(3);

        sb.append(tableInsetTabs)
            .append(TABLE_NAME_PREFIX).append(tableName)
            .append(TABLE_NAME_SUFFIX);
        sb.append(System.lineSeparator());

        sb.append(columnInsetTabs)
            .append(COLUMN_NAME)
            .append(COUNTRY_NAME_COLUMN)
            .append(VALUE).append(countryIso2.getCountryName())
            .append(COLUMN_CLOSING_TAG);
        sb.append(System.lineSeparator());

        sb.append(columnInsetTabs)
            .append(COLUMN_NAME)
            .append(ISO2_CODE_COLUMN)
            .append(VALUE).append(countryIso2.getIso2code())
            .append(COLUMN_CLOSING_TAG);
        sb.append(System.lineSeparator());

        sb.append(tableInsetTabs)
            .append(INSERT_CLOSING_TAG);
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    private static String addInsetTabs(int spaces) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < spaces; i++) {
            sb.append("\t");
        }

        return sb.toString();
    }
}
