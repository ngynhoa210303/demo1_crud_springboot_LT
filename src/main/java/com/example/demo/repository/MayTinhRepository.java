package com.example.demo.repository;

import com.example.demo.entity.MayTinhs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


/**
 * @author thangdt
 */
public interface MayTinhRepository extends JpaRepository<MayTinhs, UUID> {

}
