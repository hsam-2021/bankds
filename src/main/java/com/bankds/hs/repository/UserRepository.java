package com.bankds.hs.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankds.hs.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	List<User> findAll();

	@Query("select id from User where username =:userName ")
	long findUserId(@Param("userName") String userName);
	
	@Query("select count(*) from User where username =:userName and id =:id")
	int countExistingUserNameForUpdate(@Param("userName") String userName,@Param("id") Long id);
	
	
	@Query("select count(*) from User where email =:email and id =:id")
	int countExistingUserEmailForUpdate(@Param("email") String email,@Param("id") Long id);
}
