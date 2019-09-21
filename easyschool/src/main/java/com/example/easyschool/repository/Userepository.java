package com.example.easyschool.repository;

import com.example.easyschool.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * FileName: Userepository
 * Author:   刘帅
 * Date:     2019-9-21 8:56
 */
@Repository
public interface Userepository extends CrudRepository<User,String>,JpaSpecificationExecutor {
}
