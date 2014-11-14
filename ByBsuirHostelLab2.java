/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.hostel.lab_2;

/**
 *
 * @author Степан
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class ByBsuirHostelLab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        File file = new File("D:\\tmp2.txt");
        ArrayList<Recept> book = new ArrayList<Recept>();
        if (file.exists()) {
            try {
                ObjectInputStream oisFile = new ObjectInputStream(new FileInputStream(file));
                book = (ArrayList<Recept>) oisFile.readObject();
                oisFile.close();
                //while(oisFile.)
                //System.out.println( (Recept)oisFile.readObject());


            } catch (ClassNotFoundException ex) {
                System.out.println("Не удалось считать данные");
                System.exit(1);
            } catch (FileNotFoundException ex) {
                System.out.println("Не найден файл...");
                System.exit(1);
            } catch (IOException ex) {
                System.out.println("Ошибка открытия файла...");
                System.exit(1);
            }
        }
        try {
            do {
                int numb = -1;
                System.out.println("Нажмите:\n 1.Добавить рецепт\n 2.Удалить рецепт\n 3.Изменить рецепт\n 4.Просмотреть информацию \n 5.Отсортировать рецепты по названию\n 6.Сохранить в файл\n 7.Выход");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                numb = Integer.parseInt(br.readLine());
                switch (numb) {
                    case 1: {
                        System.out.print("Название рецепта:    ");
                        String receptName = br.readLine();
                        System.out.print("Список ингредиентов:    ");
                        Iterator<String> it = addSpis();
                        System.out.print("Способ приготовления:    ");
                        String sposPrig = br.readLine();
                        System.out.print("Время приготовления[мин.]:    ");//сделать с часами
                        int time = Integer.parseInt(br.readLine());
                        book.add(new Recept(receptName, it, sposPrig, time));
                    }
                    break;
                    case 2: {
                        if(book.isEmpty())
                        {
                            System.out.println("Нечего удалять!");
                            break;
                        }
                        System.out.println("Введите номер записи: ");
                        int n = 0;
                        for (Recept r : book) {
                            System.out.println(++n + ".  " + r.getName());
                        }
                        numb = Integer.parseInt(br.readLine());
                        book.remove(numb - 1);
                    }
                    break;
                    case 3: {
                        System.out.println("Введите номер рецепта: ");
                        int n = 0;
                        for (Recept r : book) {
                            System.out.println(++n + ". " + r.getName());
                        }
                        numb = Integer.parseInt(br.readLine());
                        System.out.println("Что будем изменять?:\n 1.Название рецепта\n 2.Список ингредиентов\n 3.Способ приготовления");
                        n = Integer.parseInt(br.readLine());
                        switch (n) {
                            case 1: {
                                System.out.print("Введите новое название:    ");
                                String Name = br.readLine();
                                book.get(numb - 1).setName(Name);
                            }
                            break;
                            case 2: {
                                System.out.print("Список ингредиентов:    ");
                                Iterator<String> it = addSpis();
                                book.get(numb - 1).setSpisIngred(it);
                            }
                            break;
                            case 3: {
                                System.out.print("Способ приготовления:    ");
                                String sposob = br.readLine();
                                book.get(numb - 1).setSposobGotovki(sposob);
                            }
                            break;
                            case 4: {
                                System.out.print("Время приготовления[мин.]:    ");
                                int Time = Integer.parseInt(br.readLine());
                                book.get(numb - 1).setVremjaGotovki(Time);
                            }
                        }
                    }
                    break;
                    case 4: {
                        int n = 0;
                        for (Recept r : book) {
                            System.out.print(++n + ". ");
                            r.show();
                        }
                    }
                    break;
                    case 5: {
                        Collections.sort(book);
                    }
                    break;
                    case 6: {
                        if(book.isEmpty())
                        {
                           System.out.print("Список пустой\n");
                           break;
                        }
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(book);
                        oos.close();
                    }
                    break;
                    case 7: {
                        System.exit(0);
                    }
                    break;
                    default:
                        System.out.println("Введите от 1 до 6!!!");
                }
            } while (true);
        } catch (IOException ex) {
            System.out.println("Ошибка открытия...");
        }
    }

    static public Iterator<String> addSpis() {
        ArrayList<String> spis = new ArrayList<String>();
        System.out.println("Для выхода введите  '$'");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = new String();
            str = scan.next();
            if (str.equals("$")) {
                break;
            }
            spis.add(str);
        }
        Iterator<String> iter;
        iter = spis.iterator();
        return iter;
    }
}