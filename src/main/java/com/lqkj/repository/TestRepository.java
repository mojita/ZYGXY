package com.lqkj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lqkj.domain.Test;

/**
 * Created by lijunhong on 17/11/5.
 */
public interface TestRepository extends JpaRepository<Test,Integer> {

}
