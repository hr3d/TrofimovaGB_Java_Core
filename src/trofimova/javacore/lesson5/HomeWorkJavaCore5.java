package trofimova.javacore.lesson5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HomeWorkJavaCore5 {
    public static void main(String[] args) throws IOException {

        int numberCols = 5;
        int numberRowsData = 3;

        Random random = new Random();

        String[] headerArr = new String[numberCols];
        headerArr[0] = "Катя";
        headerArr[1] = "Петя";
        headerArr[2] = "Маша";
        headerArr[3] = "Ваня";
        headerArr[4] = "Вика";
        System.out.println(Arrays.toString(headerArr));

        int[][] dataArr = new int[numberRowsData][numberCols];
        for (int i = 0; i < dataArr.length; i++){
            for (int j = 0; j < numberCols; j++){
                dataArr[i][j] = random.nextInt(5) + 1;
                System.out.print(dataArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        writeStream(headerArr, dataArr);

        AppData appData = readToObject();

        printAppData (appData);
    }

    public static void writeStream(String[] headerArr, int[][] dataArr) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/trofimova/javacore/lesson5/test.csv")){
            String header = "";
            for (String a: headerArr){
                header += a + ";";
            }
            header += System.getProperty("line.separator");
            for(byte b: header.getBytes(StandardCharsets.UTF_8)){
                fileOutputStream.write(b);
            }
            for(int i = 0; i < dataArr.length; i++) {
                String data = "";
                for (int j = 0; j < dataArr[0].length; j++) {
                    data += dataArr[i][j] + ";";
                }
                data += System.getProperty("line.separator");
                fileOutputStream.write(data.getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    public static AppData readToObject() throws IOException{
        AppData appData = new AppData();
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/trofimova/javacore/lesson5/test.csv"))) {
            String line = bufferedReader.readLine();
            appData.setHeader(line.split(";"));
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        }

        int[][] resultData = new int[records.size()][records.get(0).size()];

        for(int i=0;i<records.size();i++){
            for(int j=0;j<records.get(i).size();j++){
                resultData[i][j] = Integer.valueOf(records.get(i).get(j));
            }
        }
        appData.setData(resultData);
        return appData;
    }

    public static void printAppData (AppData appData){

        System.out.println(Arrays.toString(appData.getHeader()));
        int[][] dataArr = appData.getData();
        for (int i = 0; i <  dataArr.length; i++){
            for (int j = 0; j < dataArr[0].length; j++){
                System.out.print(dataArr[i][j] + " ");
            }
            System.out.println();
        }
    }

}