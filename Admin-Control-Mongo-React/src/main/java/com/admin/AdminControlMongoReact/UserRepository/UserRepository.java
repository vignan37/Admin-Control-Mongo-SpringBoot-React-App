package com.admin.AdminControlMongoReact.UserRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.admin.AdminControlMongoReact.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
