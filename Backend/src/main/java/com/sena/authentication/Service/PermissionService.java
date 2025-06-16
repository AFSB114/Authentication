package com.sena.authentication.Service;

import com.sena.authentication.DTO.PermissionDTO;
import com.sena.authentication.Model.Permission;
import com.sena.authentication.Repository.iPermission;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    private final iPermission iPermission;

    public PermissionService(iPermission iPermission) {
        this.iPermission = iPermission;
    }

    public List<Permission> getPermissions() {
        return iPermission.findAll();
    }

    public String addPermission(PermissionDTO permissionDTO) {
        Permission permission = Permission
                .builder()
                .name(permissionDTO.getName())
                .description(permissionDTO.getDescription())
                .build();
        iPermission.save(permission);
        return "OK";
    }

    public String editPermission(PermissionDTO permissionDTO, Integer id) {
        Optional<Permission> optionalPermission = iPermission.findById(id);
        if(optionalPermission.isEmpty()) return "error";

        Permission permission = optionalPermission.get();
        permission.setName(permissionDTO.getName());
        permission.setDescription(permissionDTO.getDescription());
        iPermission.save(permission);
        return "ok";
    }

    public String deletePermission(Integer id) {
        Optional<Permission> optionalPermission = iPermission.findById(id);
        if(optionalPermission.isEmpty()) return "error";
        iPermission.delete(optionalPermission.get());
        return "ok";
    }
}
