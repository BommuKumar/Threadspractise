package com.naresh.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.Database.Entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String>{

}
