package com.lambdaschool.liftingweights;

import com.lambdaschool.liftingweights.models.*;
import com.lambdaschool.liftingweights.services.RoleService;
import com.lambdaschool.liftingweights.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;


    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "password", admins);
        u1.getUseremails()
          .add(new Useremail(u1, "admin@email.local"));
        u1.getUseremails()
          .add(new Useremail(u1, "admin@mymail.local"));

        userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", datas);
        u2.getUseremails()
          .add(new Useremail(u2, "cinnamon@mymail.local"));
        u2.getUseremails()
          .add(new Useremail(u2, "hops@mymail.local"));
        u2.getUseremails()
          .add(new Useremail(u2, "bunny@email.local"));
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("barnbarn", "ILuvM4th!", users);
        u3.getUseremails()
          .add(new Useremail(u3, "barnbarn@email.local"));
       u3.getUserworkouts()
               .add(new UserWorkout(u3,"Legs and Back", "01:20:30"));
        u3.getUserworkouts()
                .add(new UserWorkout(u3,"Weights", "01:20:30"));



        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Bob", "password", users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", users);
        userService.save(u5);
    }
}