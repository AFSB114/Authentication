package com.sena.authentication.Service;

import com.sena.authentication.DTO.RecoveryRequestDTO;
import com.sena.authentication.Model.RecoveryRequest;
import com.sena.authentication.Repository.iRecoveryRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecoveryRequestService {

    private final iRecoveryRequest iRecoveryRequest;

    public RecoveryRequestService(iRecoveryRequest iRecoveryRequest) {
        this.iRecoveryRequest = iRecoveryRequest;
    }

    public List<RecoveryRequest> getRecoveryRequest(){
        return iRecoveryRequest.findAll();
    }

    public String addRecoveryRequest(RecoveryRequestDTO recoveryRequestDTO){
        RecoveryRequest recoveryRequest = RecoveryRequest
                .builder()
                .user(recoveryRequestDTO.getUser())
                .token(recoveryRequestDTO.getToken())
                .build();
        iRecoveryRequest.save(recoveryRequest);
        return "OK";
    }

//    public String updateRecoveryRequest(RecoveryRequestDTO recoveryRequestDTO, Integer id){
//        Optional<RecoveryRequest> recoveryRequest = iRecoveryRequest.findById(id);
//        if (recoveryRequest.isEmpty()) return "error";
//        RecoveryRequest recoveryRequest1 = recoveryRequest.get();
//        recoveryRequest1.setToken(recoveryRequestDTO.getToken());
//        iRecoveryRequest.save(recoveryRequest1);
//        return "OK";
//    }

    public String deleteRecoveryRequest(Integer id){
        iRecoveryRequest.deleteById(id);
        return "OK";
    }
}
