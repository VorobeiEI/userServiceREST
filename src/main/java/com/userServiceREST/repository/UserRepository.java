package com.userServiceREST.repository;

import com.userServiceREST.data.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUserName(String userName);
}
