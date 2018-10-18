package com.sut.sa.g21.controller;
import java.util.Collection;
import java.util.Optional;

import com.sut.sa.g21.entity.Preorder;
import com.sut.sa.g21.entity.Product;
import com.sut.sa.g21.entity.Status;
import com.sut.sa.g21.entity.UserInfoEntity;
import com.sut.sa.g21.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sut.sa.g21.repository.PreorderRepository;
import com.sut.sa.g21.repository.StatusRepository;
import com.sut.sa.g21.repository.UserInfoRepository;
import java.util.Map;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PreorderSystemController{
    @Autowired private ProductRepository productRepository;
    @Autowired private StatusRepository statusRepository;
    @Autowired private UserInfoRepository userInfoRepository;
    @Autowired private PreorderRepository preorderRepository;
    // --------------- status ------------------

    @GetMapping("/Status")
    public Collection<Status> status(){
        return statusRepository.findAll();
    }
    
    @GetMapping("/Status/{statusId}")
    public Optional<Status> takeinStatusByid(@PathVariable Long statusId ){
        return statusRepository.findById(statusId);
    }

    // ---------------  Product ---------------

    @GetMapping("/Product")
    public Collection<Product> product(){
        return productRepository.findAll();
    }
    
    @GetMapping("/Product/{productID}")
    public Optional<Product> takeinProductByid(@PathVariable Long productID ){
        return productRepository.findById(productID);
    }

    // ---------------  User ---------------

    @GetMapping("/User")
    public Collection<UserInfoEntity> user(){
        return userInfoRepository.findAll();
    }
    
    @GetMapping("/User/{productID}")
    public Optional<UserInfoEntity> takeinUserByid(@PathVariable Long userId ){
        return userInfoRepository.findById(userId);
    }
    // ---------------  Preorder ---------------

    @GetMapping("/Preorder")
    public Collection<Preorder> preorder(){
        return preorderRepository.findAll();
    }
    
    @GetMapping("/Preorder/{userName}")
    public  Collection<Preorder> takeinPreorderByid(@PathVariable String userName){
        UserInfoEntity user = userInfoRepository.findByName(userName);
       Collection<Preorder> preorder = preorderRepository.findByUser(user);
        return preorder;
    }
    @PostMapping("/newPreorder/{userName}/{productId}/{statusName}")
    public Preorder newPreorder(@PathVariable String userName,@PathVariable Long productId,@PathVariable String statusName,@RequestBody() Map<String,Object> body){                     
        Preorder newPreorder = new Preorder();
        UserInfoEntity user = userInfoRepository.findByName(userName);
        Product product = productRepository.findById(productId).get();
        Status status = statusRepository.findByStatusName(statusName);
        newPreorder.setAmount(Long.valueOf(body.get("amount").toString()));
        newPreorder.setSumPrice(Double.valueOf(body.get("sumPrice").toString()));
        newPreorder.setStatus(status);
        newPreorder.setProduct(product);
        newPreorder.setUser(user);
        return preorderRepository.save(newPreorder);
    }

    // @PostMapping("/login")
    // @CrossOrigin(origins = "http://localhost:4200")
    // public void login(@RequestBody UserInfoEntity userInfoEntity) throws Exception {
    // UserInfoEntity user = userInfoRepository.findByName(userInfoEntity.getName());
    //     if (!loginAuth(userInfoEntity.getPassword().getBytes(),userInfoEntity.getPassword().getBytes()))
    //         throw new Exception();
    // }

    // public boolean loginAuth(byte[] userPassword,byte[] password){
    //     int result = 0;
    //     if (userPassword.length != password.length)
    //         return false;
    //     else{
    //         for (int i = 0; i < password.length; i++)
    //             result |= password[i] ^ userPassword[i];
    //     }
    //     return result == 0;
    // }

}
