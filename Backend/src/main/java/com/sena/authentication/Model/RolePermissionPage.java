package com.sena.authentication.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "role_permission_page")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolePermissionPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;

    @ManyToOne
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;
}
