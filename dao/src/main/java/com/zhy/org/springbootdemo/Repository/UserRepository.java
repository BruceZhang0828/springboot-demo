package com.zhy.org.springbootdemo.Repository;


import com.zhy.org.springbootdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {

    private final ConcurrentMap<Integer,User> concurrentMap
            = new ConcurrentHashMap<>();

    private final static AtomicInteger ATOMIC_INTEGER  = new AtomicInteger();

    /**
     *
     * @param user
     * @return
     */
    public boolean save(User user){

        int id = ATOMIC_INTEGER.incrementAndGet();

        user.setId(id);

        return concurrentMap.put(id,user)==null;

    }

    /**
     * 返回所有
     * @return
     */
    public Collection<User> findAll(){
        return concurrentMap.values();
    }

}
