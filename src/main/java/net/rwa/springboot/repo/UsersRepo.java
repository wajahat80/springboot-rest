package net.rwa.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.rwa.springboot.model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {

}
