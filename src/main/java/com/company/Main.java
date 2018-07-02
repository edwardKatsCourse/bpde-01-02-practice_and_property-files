package com.company;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
//        File file = new File("filename.txt");
//        String data = "This is my text";
//        String encoding = "UTF-8";
//

//        FileUtils.write(file, data, encoding);

//        System.out.println(FileUtils.readFileToString(file, encoding));

        //first name^last name^age
        File file = new File("users.txt");
        String encoding = "UTF-8";
        ObjectMapper objectMapper = new ObjectMapper();
        String json;

        //John Doe
        User john = new User("johnd", "123456");
        User jane = new User("janed", "123456");
        User peter = new User("peterd", "123456");
        User johnDale = new User("johnd", "123456");
        //firstname + one letter from last name:
        //John Dale -> johnd
        //John Doe -> johnd

        List<User> users = Arrays.asList(john, jane, peter, johnDale);
        json = objectMapper.writeValueAsString(users);
        System.out.println(objectMapper
                .writeValueAsString(json));

        FileUtils.write(file, json, encoding);
        //USERS ARE IN FILE

        //Set<LinkedHashMap>

        Set<User> userSet = objectMapper.readValue(json, new TypeReference<Set<User>>() {});
        userSet.forEach(x -> System.out.printf("USERNAME: %s | PASSWORD: %s\n",
                x.getUsername(),
                concealPassword(x.getPassword())));

    }

    public static String concealPassword(String password) {
//        char [] chars = password.toCharArray();
        StringBuilder builder = new StringBuilder();

//        for (int i = 0; i < password.length(); i++) {

//            builder.append("*");
//        }

        for (int i = 0; i < password.length()-2; i++) {

            builder.append("*");
        }
        builder.append(password.substring(password.length()-2, password.length()));

        return builder.toString();
    }
}
