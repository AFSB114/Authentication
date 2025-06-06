package com.sena.authentication.Repository;

import com.sena.authentication.Model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iPermission extends JpaRepository<Permission, Integer> {
}
