package com.netcracker.interviewscheduleridprovider.controllers;

import com.netcracker.interviewscheduleridprovider.services.RoleService;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "")
    public void createRole(@RequestBody RoleRepresentation roleRepresentation) {
        roleService.createRole(roleRepresentation);
    }

    @DeleteMapping(value = "/{name}")
    public void deleteRole(@PathVariable String name) {
        roleService.deleteRole(name);
    }

    @PutMapping(value = "/{name}")
    public void editRole(@PathVariable String name, @RequestBody RoleRepresentation roleRepresentation) {
        roleService.editRole(name, roleRepresentation);
    }
}
