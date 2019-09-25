package com.lambdaschool.liftingweights.controllers;

import com.lambdaschool.liftingweights.models.Role;
import com.lambdaschool.liftingweights.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);
    @Autowired
    RoleService roleService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/roles",
                produces = {"application/json"})
    public ResponseEntity<?> listRoles(HttpServletRequest request)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Role> allRoles = roleService.findAll();
        return new ResponseEntity<>(allRoles, HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/role/{roleId}",
                produces = {"application/json"})
    public ResponseEntity<?> getRoleById(HttpServletRequest request,
                                         @PathVariable
                                                 Long roleId)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Role r = roleService.findRoleById(roleId);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/role/name/{roleName}",
                produces = {"application/json"})
    public ResponseEntity<?> getRoleByName(HttpServletRequest request,
                                           @PathVariable
                                                   String roleName)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        Role r = roleService.findByName(roleName);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }


    @PostMapping(value = "/role")
    public ResponseEntity<?> addNewRole(HttpServletRequest request, @Valid
    @RequestBody
            Role newRole) throws URISyntaxException
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newRole = roleService.save(newRole);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRoleURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                    .path("/{roleid}")
                                                    .buildAndExpand(newRole.getRoleid())
                                                    .toUri();
        responseHeaders.setLocation(newRoleURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<?> deleteRoleById(HttpServletRequest request,
                                            @PathVariable
                                                    long id)
    {
        logger.trace(request.getMethod()
                            .toUpperCase() + " " + request.getRequestURI() + " accessed");

        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
