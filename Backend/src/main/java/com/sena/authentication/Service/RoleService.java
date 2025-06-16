package com.sena.authentication.Service;

import com.sena.authentication.DTO.RoleDTO;
import com.sena.authentication.Model.Role;
import com.sena.authentication.Model.RolePermissionPage;
import com.sena.authentication.Repository.iRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final iRole iRole;

    public RoleService(iRole iRole) {
        this.iRole = iRole;
    }

    public List<Role> getRoles() {
        return iRole.findAll();
    }

    public String addRole(RoleDTO roleDTO) {
        Role role = Role
                .builder()
                .name(roleDTO.getName())
                .description(roleDTO.getDescription())
                .build();
        iRole.save(role);
        return "Role added successfully";
    }
}
