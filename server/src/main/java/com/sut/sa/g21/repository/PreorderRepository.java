package com.sut.sa.g21.repository;

import com.sut.sa.g21.entity.Preorder;
import com.sut.sa.g21.entity.UserInfoEntity;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
    public
    interface PreorderRepository extends JpaRepository<Preorder, Long> {
        Collection<Preorder> findByUser(UserInfoEntity userId);
        
}