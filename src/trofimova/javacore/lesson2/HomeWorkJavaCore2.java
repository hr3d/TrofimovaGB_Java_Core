public class HomeWorkJavaCore2 {
    public static void main (String[] args){

        String [][] arr1 = new String [4][4];            //создание массива с корректными размерами и значениями
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                arr1[i][j] = "123";
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

        try {
            stringToInt(arr1);
        } catch (MyArraySizeException | MyArrayDataException a) {
            System.out.println(a.getMessage());
        }
        System.out.println();

        String [][] arr2 = new String [3][3];           //создание массива с некорректными размерами
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                arr2[i][j] = "456";
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }

        try {
            stringToInt(arr2);
        } catch (MyArraySizeException | MyArrayDataException a) {
            System.out.println(a.getMessage());
        }
        System.out.println();

        String [][] arr3 = new String [4][4];          //создание массива с некорректным значениями
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3.length; j++) {
                arr3[i][j] = "789";
                if (i == 2 && j == 2) arr3[i][j] = "abc";
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }

        try {
            stringToInt(arr3);
        } catch (MyArraySizeException | MyArrayDataException a) {
        System.out.println(a.getMessage());
        }

    }

    public static void stringToInt (String[][] arrString) throws MyArraySizeException, MyArrayDataException {
        isRightSizeArray (arrString);
        int [][] arrInt = new int[4][4];
        int sumIntArray = 0;
        for (int i = 0; i < arrString.length; i++) {
            for (int j = 0; j < arrString.length; j++) {
                try {
                    arrInt[i][j] = Integer.parseInt(arrString[i][j]);
                } catch (NumberFormatException a){
                    throw new MyArrayDataException("Строковый элемент массива " + arrString[i][j] +" с координатами [" + i + "][" + j + "] не может быть приведен к числовому типу int");
                }
                sumIntArray += arrInt[i][j];
            }

        }
        System.out.println("Сумма элементов массива равна " + sumIntArray);
    }

    public static void isRightSizeArray (String[][] arrStringCheck) throws MyArraySizeException {
        if (arrStringCheck.length != 4 || arrStringCheck[0].length != 4) throw new MyArraySizeException("Размер массива не соответствует формату [4][4]");
    }

}
