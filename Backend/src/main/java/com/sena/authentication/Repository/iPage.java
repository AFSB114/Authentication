package com.sena.authentication.Repository;

import com.sena.authentication.Model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iPage extends JpaRepository<Page, Integer> {
}
