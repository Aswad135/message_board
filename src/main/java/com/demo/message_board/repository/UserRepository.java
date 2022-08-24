package com.demo.message_board.repository;

import com.demo.message_board.entities.Message;
import com.demo.message_board.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
