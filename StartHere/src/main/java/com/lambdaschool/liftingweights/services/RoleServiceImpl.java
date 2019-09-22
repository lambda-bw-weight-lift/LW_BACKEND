package com.lambdaschool.liftingweights.services;

import com.lambdaschool.liftingweights.exceptions.ResourceNotFoundException;
import com.lambdaschool.liftingweights.models.Role;
import com.lambdaschool.liftingweights.models.User;
import com.lambdaschool.liftingweights.models.UserRoles;
import com.lambdaschool.liftingweights.repository.RoleRepository;
import com.lambdaschool.liftingweights.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService
{
    @Autowired
    RoleRepository rolerepos;

    @Autowired
    UserRepository userrepos;

    @Override
    public List<Role> findAll()
    {
        List<Role> list = new ArrayList<>();
        rolerepos.findAll()
                 .iterator()
                 .forEachRemaining(list::add);
        return list;
    }


    @Override
    public Role findRoleById(long id)
    {
        return rolerepos.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Role id " + id + " not found!"));
    }

    @Override
    public Role findByName(String name)
    {
        Role rr = rolerepos.findByNameIgnoreCase(name);

        if (rr != null)
        {
            return rr;
        } else
        {
            throw new ResourceNotFoundException(name);
        }
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        rolerepos.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Role id " + id + " not found!"));
        rolerepos.deleteById(id);
    }


    @Transactional
    @Override
    public Role save(Role role)
    {
        Role newRole = new Role();
        newRole.setName(role.getName());

        ArrayList<UserRoles> newUsers = new ArrayList<>();
        for (UserRoles ur : role.getUserroles())
        {
            long id = ur.getUser()
                        .getUserid();
            User user = userrepos.findById(id)
                                 .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
            newUsers.add(new UserRoles(ur.getUser(), newRole));
        }
        newRole.setUserroles(newUsers);

        return rolerepos.save(role);
    }
}
