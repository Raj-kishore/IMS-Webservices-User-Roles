package com.naffal.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.naffal.ims.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // Or, itemDao

}
