package com.epam.service;

import com.epam.model.User;
import com.epam.repository.UserRepository;
import com.epam.service.Constants.Links;
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
        Document doc = Jsoup.connect(Links.LINK1).get();
        Elements node = doc.getElementsByClass("podmiot_desc");

        for (Element item : node) {
            String[] strArray = item.text().split(" ");
            User user = new User();
            String email = email = strArray[0] + "." + strArray[1] + "@kibr.pl";
            user.setName(strArray[0]);
            user.setSurname(strArray[1]);
            user.setEmail(email);
        }
    }

    private String domainGenerator() {
        String domain = null;
        return domain;
    }
}