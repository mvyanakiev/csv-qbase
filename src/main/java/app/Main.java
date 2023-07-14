package app;

import models.CountryIso2;
import utils.Convertor;
import utils.FileWriter;
import utils.ReadInputData;
import utils.XmlGenerator;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String[]> readContent = ReadInputData.readContent();
        List<CountryIso2> countryList = Convertor.convertToIso2List(readContent);
        List<String> xmlCountries = countryList
            .stream()
            .map(x -> XmlGenerator.generate2columnXml(x, "country_codes"))
            .collect(Collectors.toList());

        FileWriter writer = new FileWriter("C:\\Temp\\", "liquibaseCountryCodesXml.xml");
        writer.appendToFile(xmlCountries);
        xmlCountries.forEach(System.out::print);
    }
}
