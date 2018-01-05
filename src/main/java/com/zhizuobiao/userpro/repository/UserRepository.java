package com.zhizuobiao.userpro.repository;

import com.zhizuobiao.userpro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


}
