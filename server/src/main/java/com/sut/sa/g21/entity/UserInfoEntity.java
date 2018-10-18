package com.sut.sa.g21.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity
@Getter @Setter
@Table(name="User")
public class UserInfoEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long userId;
    private @NonNull String password;
    private @NonNull String name;
    private String userAddress;
    private @NonNull String userEmail;
    private @NonNull String userTel;


    @ManyToOne()   
    @JoinColumn(name= "provinceId")     
    private Province province;

    public UserInfoEntity(){}
    public UserInfoEntity(String name){
        this.name = name;
        
    }
    public UserInfoEntity(Long id){
        this.userId = id;
    }
    public UserInfoEntity(String userName,String userAddress,String userEmail,String userTel,long provinceId){
        Province province = new Province(provinceId);
        this.name = userName;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userTel = userTel;
        this.province = province;
    }
}