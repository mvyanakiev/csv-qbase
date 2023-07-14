package utils;

import models.CountryIso2;

import java.util.Arrays;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import static java.util.stream.Collectors.toList;

public class Convertor {

    public static List<CountryIso2> convertToIso2List(List<String[]> inputList) {

        if (inputList == null) {
            throw new NullPointerException("List is null.");
        }

        return inputList
            .stream()
            .map(Convertor::convertToIso2)
            .sorted(Comparator.comparing(CountryIso2::getCountryName))
            .collect(toList());
    }

    private static CountryIso2 convertToIso2(String[] in) {

        if (in == null) {
            throw new NullPointerException("Line is null.");
        }

        if (in.length != 2) {
            throw new IllegalArgumentException("Expected 2 columns.");
        }

        Arrays.stream(in).forEach(Convertor::check);
        String countryName = capitalizeFirstLetter(in[0]);
        String countryCode = in[1].toUpperCase(Locale.ROOT);

        return new CountryIso2(countryName, countryCode);
    }

    private static void check(String str) {
        if (str == null || "".equals(str)) {
            throw new NullPointerException("Empty country name or country code.");
        }
    }

    private static String capitalizeFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
