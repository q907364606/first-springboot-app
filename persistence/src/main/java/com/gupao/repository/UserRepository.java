package com.gupao.repository;

import com.gupao.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 用户的仓储
 */
@Repository
public class UserRepository {

    private final ConcurrentHashMap<Long,User> repositpory = new ConcurrentHashMap<Long,User>();

    private final AtomicLong idGenerator = new AtomicLong();

    public Boolean save(User user){
        //id 从1开始
        long id = idGenerator.incrementAndGet();
        user.setId(id);
        return repositpory.put(id,user) == null;

    }


    public Collection<User> findAll(){
        return repositpory.values();
    }


}
