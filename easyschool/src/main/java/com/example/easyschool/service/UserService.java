package com.example.easyschool.service;

import com.example.easyschool.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * FileName: UserService
 * Author:   刘帅
 * Date:     2019-9-21 9:01
 */
public interface UserService {
    Page<User> findPage(User user, Pageable pageable);
}
