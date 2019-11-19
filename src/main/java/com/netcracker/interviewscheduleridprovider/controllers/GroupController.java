package com.netcracker.interviewscheduleridprovider.controllers;

import com.netcracker.interviewscheduleridprovider.services.GroupService;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping(value = "")
    public void createGroup(@RequestBody GroupRepresentation groupRepresentation) {
        groupService.createGroup(groupRepresentation);
    }

    @DeleteMapping(value = "/{name}")
    public void deleteGroup(@PathVariable String name) {
        groupService.deleteGroup(name);
    }

    @PutMapping(value = "/{name}")
    public void editGroup(@PathVariable String name, @RequestBody GroupRepresentation groupRepresentation) {
        groupService.editGroup(name, groupRepresentation);
    }
}
