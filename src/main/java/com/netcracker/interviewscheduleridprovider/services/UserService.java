package com.netcracker.interviewscheduleridprovider.services;

public interface UserService {
    int createUser(String username, String password);
    int deleteUser(String id);
    void editUser(String id);
}
