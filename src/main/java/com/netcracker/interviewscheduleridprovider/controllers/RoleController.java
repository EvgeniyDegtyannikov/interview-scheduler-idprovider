package com.netcracker.interviewscheduleridprovider.controllers;

import com.netcracker.interviewscheduleridprovider.services.RoleService;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "")
    public void createRole(@RequestBody RoleRepresentation roleRepresentation) {
        roleService.createRole(roleRepresentation);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
    }

    @PutMapping(value = "/{id}")
    public void editRole(@PathVariable String id, @RequestBody RoleRepresentation roleRepresentation) {
        roleService.editRole(id, roleRepresentation);
    }

    @GetMapping(value = "")
    public List<RoleRepresentation> loadRoles() {
        return roleService.loadRoles();
    }

    @GetMapping(value = "/{id}")
    public RoleRepresentation loadRole(@PathVariable String id) {
        return roleService.loadRole(id);
    }
}
