package com.epam.repository;

import com.epam.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by HP on 2016-02-14.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>
{
    public User findByName(String name);
}
