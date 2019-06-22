package com.ing.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.bank.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
<<<<<<< HEAD
=======

	public List<User> findByStatusAndRole(String status, String Role);

	public User findByUserId(Long userId);
>>>>>>> de16fd191f44660469f99536045ce97c7bd33989

	User findByLoginNameAndPassword(String loginName, String password);

}
