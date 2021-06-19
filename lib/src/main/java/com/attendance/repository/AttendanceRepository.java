package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendance.entities.AttendanceEntity;


@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity,Integer> {

}
