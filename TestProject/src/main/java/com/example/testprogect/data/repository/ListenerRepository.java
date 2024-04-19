package com.example.testprogect.data.repository;

import com.example.testprogect.data.entity.ListenerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ListenerRepository extends JpaRepository<ListenerEntity, Long> {

}
