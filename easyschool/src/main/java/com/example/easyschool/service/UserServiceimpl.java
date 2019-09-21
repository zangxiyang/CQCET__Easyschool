package com.example.easyschool.service;

import com.example.easyschool.model.User;
import com.example.easyschool.repository.Userepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * FileName: UserServiceimpl
 * Author:   刘帅
 * Date:     2019-9-21 9:02
 */
@Service
public class UserServiceimpl implements UserService{

    @Autowired
    private Userepository userepository;

    @Override
    public Page<User> findPage(User user, Pageable pageable) {
        Specification<User> specification=getinfo(user);
        return userepository.findAll(specification,pageable);
    }



    public static Specification<User> getinfo(final User user){
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate=criteriaBuilder.equal(root.get("delFlag"),"0");
                if (null!=predicate){
                    criteriaQuery.where(predicate);
                }
                return null;
            }
        };
    }
}
