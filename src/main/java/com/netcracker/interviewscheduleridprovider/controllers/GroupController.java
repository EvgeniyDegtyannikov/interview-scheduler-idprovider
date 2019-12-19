package com.netcracker.interviewscheduleridprovider.controllers;

import com.netcracker.interviewscheduleridprovider.services.GroupService;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping(value = "")
    public HttpStatus createGroup(@RequestBody GroupRepresentation groupRepresentation) {
        return groupService.createGroup(groupRepresentation);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGroup(@PathVariable String id) {
        groupService.deleteGroup(id);
    }

    @PutMapping(value = "/{id}")
    public void editGroup(@PathVariable String id, @RequestBody GroupRepresentation groupRepresentation) {
        groupService.editGroup(id, groupRepresentation);
    }

    @GetMapping(value = "")
    public List<GroupRepresentation> loadGroups() {
        return groupService.loadGroups();
    }

    @GetMapping(value = "/{id}")
    public GroupRepresentation loadGroup(@PathVariable String id) {
        return groupService.loadGroup(id);
    }
}
