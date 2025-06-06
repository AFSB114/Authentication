package com.sena.authentication.Repository;

import com.sena.authentication.Model.RecoveryRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iRecoveryRequest extends JpaRepository<RecoveryRequest, Integer> {
}
