package com.lambdaschool.liftingweights.repository;

import com.lambdaschool.liftingweights.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
//    User findById(long userid);
}
