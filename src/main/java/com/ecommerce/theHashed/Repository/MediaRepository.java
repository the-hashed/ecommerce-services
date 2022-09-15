package com.ecommerce.theHashed.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ecommerce.theHashed.model.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, String> {

}
