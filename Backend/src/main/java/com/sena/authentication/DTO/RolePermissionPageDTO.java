package com.sena.authentication.DTO;

import com.sena.authentication.Model.Page;
import com.sena.authentication.Model.Permission;
import com.sena.authentication.Model.Role;
import com.sena.authentication.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionPageDTO {
    Role role;
    Permission permission;
    Page page;
}
