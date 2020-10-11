package com.test.psk.demo.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
    jpa 공부를 위한 interface
*/
public interface PostRepository extends JpaRepository<Posts,Long> {
}
