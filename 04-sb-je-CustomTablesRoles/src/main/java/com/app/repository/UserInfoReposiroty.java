package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.UserInfo;

@Repository
public interface UserInfoReposiroty extends JpaRepository<UserInfo, Long> {

}
