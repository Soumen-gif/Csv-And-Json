package service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import model.CSVUser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class OpenCSVReadAndParseToBean {
    private static final String SAMPLE_CSV_FILE_PATH = "E:\\DummyProject\\src\\main\\java\\com\\bridgelabz\\csvproject\\sample.csv";

    public static void main(String[] args) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH))
        ) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("name: " + csvUser.getName());
                System.out.println("Email: " + csvUser.getEmail());
                System.out.println("PhoneNo: " + csvUser.getPhoneNo());
                System.out.println("Country: " + csvUser.getCountry());
                //Reads all csv contents into memory
                List<CSVUser> csvUsers = csvToBean.parse();
                for (CSVUser csvUser1 : csvUsers) {
                    System.out.println("Name: " + csvUser1.getName());
                    System.out.println("Email: " + csvUser1.getEmail());
                    System.out.println("PhoneNo: " + csvUser1.getPhoneNo());
                    System.out.println("Country: " + csvUser1.getCountry());
                }
            }
        }

    }
}
