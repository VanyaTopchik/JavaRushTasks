package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\Иван\\Desktop\\lol.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\Иван\\Desktop\\lol.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

            User user1 = new User();
            user1.setFirstName("Vasa1");
            user1.setLastName("Peta1");
            user1.setBirthDate(new Date(1508944516163L));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            User user3 = new User();
            user3.setFirstName("Solo");
            user3.setLastName("Han");
            user3.setBirthDate(new Date(1508944516169L));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.users.add(user3);
            javaRush.save(outputStream);
            outputStream.flush();
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if(javaRush.equals(loadedObject)){
                System.out.println("true");
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            if(users!=null){
                fileWriter.write("Yes"+"\n");
            }
            else fileWriter.write("No"+"\n");

            for(User s : users) {
                fileWriter.write(s.getFirstName()+"\n");
                fileWriter.write(s.getLastName()+"\n");
                fileWriter.write("" + s.getBirthDate().getTime()+"\n");
                switch (s.getCountry()){
                    case OTHER: fileWriter.write("Other"+"\n"); break;
                    case RUSSIA: fileWriter.write("Russia"+"\n"); break;
                    case UKRAINE: fileWriter.write("Ukraine"+"\n"); break;
                }
                if(s.isMale()){
                    fileWriter.write("Male"+"\n");
                }
                else fileWriter.write("Female"+"\n");
            }
            fileWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
            if(fileReader.readLine().equals("Yes")) {
                while (fileReader.ready()) {
                    User user = new User();
                    user.setFirstName(fileReader.readLine());
                    user.setLastName(fileReader.readLine());
                    Date date = new Date();
                    date.setTime(Long.parseLong(fileReader.readLine()));
                    user.setBirthDate(date);
                    switch (fileReader.readLine()) {
                        case "Other":
                            user.setCountry(User.Country.OTHER);
                            break;
                        case "Russia":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        case "Ukraine":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                    }
                    if (fileReader.readLine().equals("Male")) {
                        user.setMale(true);
                    } else user.setMale(false);
                    this.users.add(user);
                }
            }
            for(User s : users){
                System.out.println(s.getFirstName());
                System.out.println(s.getLastName());
                System.out.println(s.getBirthDate());
                System.out.println(s.getCountry());
                System.out.println(s.isMale());
            }
            fileReader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
