package com.enigmacamp.minitarkam;

import com.enigmacamp.minitarkam.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManger();
    }
}
