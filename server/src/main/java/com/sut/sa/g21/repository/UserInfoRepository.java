package com.sut.sa.g21.repository;
import com.sut.sa.g21.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
    public
    interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {
        UserInfoEntity findByUserId(Long userName);
        UserInfoEntity findByName(String userName);
}