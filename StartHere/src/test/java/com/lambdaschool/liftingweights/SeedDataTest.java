//package com.lambdaschool.liftingweights;
//
//import com.lambdaschool.liftingweights.models.*;
//import com.lambdaschool.liftingweights.repository.UserRepository;
//import com.lambdaschool.liftingweights.services.ExerciseService;
//import com.lambdaschool.liftingweights.services.RoleService;
//import com.lambdaschool.liftingweights.services.UserService;
//import com.lambdaschool.liftingweights.services.UserWorkoutService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//
//@Transactional
//@Component
//public class SeedDataTest implements CommandLineRunner
//{
//    @Autowired
//    RoleService roleService;
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    ExerciseService exerciseService;
//
//    @Autowired
//    UserWorkoutService workoutService;
//
//    @Autowired
//    UserRepository userrepos;
//
//
//    @Override
//    public void run(String[] args) throws Exception
//    {
//        Role r1 = new Role("admin");
//        Role r2 = new Role("user");
//        Role r3 = new Role("data");
//
//        roleService.save(r1);
//        roleService.save(r2);
//        roleService.save(r3);
//
//        // admin, data, user
//        ArrayList<UserRoles> admins = new ArrayList<>();
//        admins.add(new UserRoles(new User(), r1));
//        admins.add(new UserRoles(new User(), r2));
//        admins.add(new UserRoles(new User(), r3));
//        User u1 = new User("newAdmin", "password", admins);
//        u1.getUseremails()
//                .add(new Useremail(u1, "admin@email.local"));
//        u1.getUseremails()
//                .add(new Useremail(u1, "admin@mymail.local"));
//
//        userService.save(u1);
//
//        // data, user
//        ArrayList<UserRoles> datas = new ArrayList<>();
//        datas.add(new UserRoles(new User(), r3));
//        datas.add(new UserRoles(new User(), r2));
//        User u2 = new User("cinnamon", "1234567", datas);
//        u2.getUseremails()
//                .add(new Useremail(u2, "cinnamon@mymail.local"));
//        u2.getUseremails()
//                .add(new Useremail(u2, "hops@mymail.local"));
//        u2.getUseremails()
//                .add(new Useremail(u2, "bunny@email.local"));
//        userService.save(u2);
//
//        // user
//        ArrayList<UserRoles> users = new ArrayList<>();
//        users.add(new UserRoles(new User(), r2));
//        User u3 = new User("barnbarn", "ILuvM4th!", users);
//
//        u3.getUseremails()
//                .add(new Useremail(u3, "barnbarn@email.local"));
//        u3.getUserworkouts()
//                .add(new UserWorkout(u3,"Legs and Back", "01:20:30", "01/23/2019"));
//        UserWorkout w1 = new UserWorkout(u3,"Weights", "01:20:30","01/23/2019" );
////       w1.getExercises().add(new Exercise("Curls", "25lbs", "12", "25second", "arms"));
//        u3.getUserworkouts()
//                .add(w1);
////        List<UserWorkout> workouts = u3.getUserworkouts();
////        workouts.get(workouts.size()-1).getExercises().add(new Exercise("Curls", "25lbs", "12", "25second", "arms"));
//
//
//
//
//
//
//        userService.save(u3);
////        List <UserWorkout> workouts = workoutService.findAll();
////        UserWorkout w = workouts.get(workouts.size()-1);
////       workoutService.saveExerciseToWorkout(w.getWorkoutid(), new Exercise("Curls", "25lbs", "12", "25second", "arms"));
//
////        users = new ArrayList<>();
////        users.add(new UserRoles(new User(), r2));
////        User u4 = new User("Bob", "password", users);
////        userrepos.save(u4);
////
////        users = new ArrayList<>();
////        users.add(new UserRoles(new User(), r2));
////        User u5 = new User("Jane", "password", users);
////        userrepos.save(u5);
//
////        Exercise e1 = new Exercise("Bench Press", "165 Lbs", "3 x 10 Reps", "1 Minute Rest", "Chest Region");
////        Exercise e2 = new Exercise("Squat", "200 Lbs", "3 x 5 Reps", "1 Minute Rest", "Legs Region");
////        Exercise e3 = new Exercise("Abs", "Bodyweight", "3 x 10 Reps", "1 Minute Rest", "Core Region");
//
////        List<UserWorkout> workout1 = new ArrayList<>();
//
//
////        UserWorkout workout1 = new UserWorkout();
////
////        workoutService.saveWorkout(workout1);
////
////        workoutService.saveExerciseToWorkout(1, e1);
////        workoutService.saveExerciseToWorkout(1, e2);
////        workoutService.saveExerciseToWorkout(1, e3);
//
//
//    }
//}