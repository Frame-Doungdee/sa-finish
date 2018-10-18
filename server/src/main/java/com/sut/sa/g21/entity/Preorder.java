package com.sut.sa.g21.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity
@Getter @Setter
@Table(name = "Preorder")
public class Preorder{
    @Id
    @SequenceGenerator(name="preorder_seq",sequenceName="preorder_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="preorder_seq")
    private @NonNull long preId;
    private long amount;
    private double sumPrice;
    @ManyToOne()   
    @JoinColumn(name= "statusId")     
    private Status status;
    
    
    
    @ManyToOne() 
    @JoinColumn(name= "userId")     
    private UserInfoEntity user;

    
    @ManyToOne() 
    @JoinColumn(name= "productId")     
    private Product product;


    public Preorder(){}
    public Preorder(long preId){
        this.preId = preId;
    }
    /*
    public Preorder(long userId,long productId,long productNum,double sumPrice,long statusId){
        User user = new User(userId);
        Product product = new Product(productId);
        Status status = new Status(statusId);
        this.user = user;
        this.product = product;
        this.productNum = productNum;
        this.sumPrice = sumPrice;
        this.status = status;
    }
    */
}