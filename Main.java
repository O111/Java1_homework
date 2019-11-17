/*  Домашнее задание №6

1.	Создать 2 текстовых файла, примерно по 50-100
символов в каждом(особого значения не имеет);

2.	Написать программу, «склеивающую» эти файлы, то есть вначале идет текст
из первого файла, потом текст из второго.

3.	* Написать программу, которая проверяет присутствует ли указанное
пользователем слово (или словосочетание, или предложение) в файле.
(Работаем только с латиницей)

4.  ** Написать метод, проверяющий, есть ли указанное слово в файлах папки

* */

package homework.lesson_6;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String s1 = "On the turning away\nFrom the pale and downtrodden,\n" +
                "And the words they say\nWhich we won't understand:\n\n";
        String s2 = "Don't accept that what's happening\nIs just a case of others' suffering\n" +
                "Or you'll find that you're joining in\nThe turning away.\n";
        try {
            FileOutputStream fileout1 = new FileOutputStream("file_01.txt");  // задание 1
            fileout1.write(s1.getBytes());
            fileout1 = new FileOutputStream("file_02.txt");
            fileout1.write(s2.getBytes());
            fileout1.close();

            FileOutputStream fileout3 = new FileOutputStream("file_03.txt", true);   // задание 2
            FileInputStream filein = new FileInputStream("file_01.txt");  // сделано очень прямолинейно; полагаю, что можно улучшить
            int i;
            while ((i = filein.read()) != -1)
                fileout3.write((char) i);
            filein = new FileInputStream("file_02.txt");
            while ((i = filein.read()) != -1)
                fileout3.write((char) i);
            fileout3.close();

            Scanner scanner = new Scanner(System.in);    //  проверка задания 3
            String path;
            do {
                System.out.println("Укажите местоположение текстового файла (введите путь): ");
                path = scanner.nextLine();
            } while (!path.endsWith(".txt"));
            File file = new File(path);
            if (!file.exists()) {       // Можно оформить через FileNotFoundException
                System.out.println("По указанному пути файла нет. Ошибка!");
            } else {
                System.out.println("Введите слово, словосочетание или предложение (латиницей), которое Вы хотите найти: ");
                String sequence = scanner.nextLine();
                System.out.println(isCharSequence(file, sequence));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isCharSequence(File file, String sequence) {    // задание 3 (не учитывает полностью знаки препинания и сдвоенные пробелы)
        try {                                                  // а также не отличает, например, Cat от Catalog - необходимо учитывать
            StringBuilder sb = new StringBuilder();            // ограничивающие слова пробелы, знаки препинания, знаки переноса строки
            FileInputStream filein = new FileInputStream(file);
            int j;
            while ((j = filein.read()) != -1)
                sb.append((char) j);
            sequence = sequence.toLowerCase();
            StringBuilder sb1 = new StringBuilder((sb.toString()).toLowerCase());
            for (int i = 0; i < sb1.length(); i++) {
                if (sb1.charAt(i) == sequence.charAt(0)) {
                    if (i + sequence.length() <= sb1.length() && sb1.substring(i, i + sequence.length()).equals(sequence))
                        return true;
                }
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isWordInDir(String path, String word) {    // задание 4 (базируется на задании 3, поэтому сохраняет его недостатки)
        File dir = new File(path);
        if (!dir.isDirectory()) {
            System.out.println("По указанному пути директории нет. Ошибка!");
            return false;
        }
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() && (files[i].getName()).endsWith(".txt") && isCharSequence(files[i], word)) {
                return true;  // условия можно развернуть, чтобы было не просто False, а + сообщение: Нет файлоб, нет текстовых файлов, слово не найдено
            }                 // но не хотел загромождать код
        }
        return false;
        }
    }
