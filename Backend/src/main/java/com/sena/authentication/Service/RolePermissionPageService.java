package com.sena.authentication.Service;

import com.sena.authentication.DTO.RolePermissionPageDTO;
import com.sena.authentication.Model.RolePermissionPage;
import com.sena.authentication.Repository.iRolePermissionPage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolePermissionPageService {

    private final iRolePermissionPage iRolePermissionPage;

    public RolePermissionPageService(iRolePermissionPage iRolePermissionPage) {
        this.iRolePermissionPage = iRolePermissionPage;
    }

    public List<RolePermissionPage> getRolePermissionPages() {
        return iRolePermissionPage.findAll();
    }

    public String addRolePermissionPage(RolePermissionPageDTO rolePermissionPageDTO) {
        RolePermissionPage rolePermissionPage = RolePermissionPage
                .builder()
                .role(rolePermissionPageDTO.getRole())
                .permission(rolePermissionPageDTO.getPermission())
                .page(rolePermissionPageDTO.getPage())
                .build();
        iRolePermissionPage.save(rolePermissionPage);
        return "OK";
    }

    public String updateRolePermissionPage(RolePermissionPageDTO rolePermissionPageDTO, Integer id) {
        Optional<RolePermissionPage> optionalRolePermissionPage = iRolePermissionPage.findById(id);
        if(optionalRolePermissionPage.isEmpty()) return "error";
        RolePermissionPage rolePermissionPage = optionalRolePermissionPage.get();
        rolePermissionPage.setRole(rolePermissionPageDTO.getRole());
        rolePermissionPage.setPermission(rolePermissionPageDTO.getPermission());
        rolePermissionPage.setPage(rolePermissionPageDTO.getPage());
        iRolePermissionPage.save(rolePermissionPage);
        return "OK";
    }

    public String deleteRolePermissionPage(Integer id) {
        iRolePermissionPage.deleteById(id);
        return "OK";
    }
}
