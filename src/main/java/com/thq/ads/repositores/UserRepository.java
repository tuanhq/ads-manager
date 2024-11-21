package com.thq.ads.repositores;


import org.springframework.data.jpa.repository.JpaRepository;

import com.thq.ads.dto.User;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByName(String name);
}
