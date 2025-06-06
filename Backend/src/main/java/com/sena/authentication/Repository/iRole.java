package com.sena.authentication.Repository;

import com.sena.authentication.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iRole extends JpaRepository<Role,Integer> {
}
