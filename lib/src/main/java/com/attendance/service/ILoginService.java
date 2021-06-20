package com.attendance.service;

import com.attendance.entities.UserEntity;

public interface ILoginService {
    public UserEntity validateuser(String email, String password);
}
