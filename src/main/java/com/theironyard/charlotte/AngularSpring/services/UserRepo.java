package com.theironyard.charlotte.AngularSpring.services;

import com.theironyard.charlotte.AngularSpring.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jake on 5/15/17.
 */

//<type of things you are storing, ID type>
public interface UserRepo extends CrudRepository<User, Integer> {

}
