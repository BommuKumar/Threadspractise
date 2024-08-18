package com.naresh.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.Database.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,String>
{

}
