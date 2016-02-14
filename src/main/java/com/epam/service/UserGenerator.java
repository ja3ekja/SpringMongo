package com.epam.service;

import com.epam.model.User;
import com.epam.repository.UserRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by HP on 2016-02-14.
 */
@Component
public class UserGenerator {

    @Autowired
    UserRepository userRepository;

    public void generate300Users() throws IOException {
        Document doc = Jsoup.connect(Constants.LINK1).get();
        Elements node = doc.getElementsByClass("podmiot_desc");

        for (Element item : node) {
            String[] strArray = item.text().split(" ");
            String email = strArray[0];
            User user = new User();
            user.setName(strArray[0]);
            user.setSurname(strArray[1]);
            name = strArray[0];
            surname = strArray[1];
            System.out.println("Name: " + name + " , and surname: " + surname);
        }

    }
}