package shounak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shounak.entity.Policy;
import shounak.service.PolicyService;

import java.util.List;

@RestController
@RequestMapping("/policy/v1/")
@RequiredArgsConstructor
public class PolicyController {
    final PolicyService policyService;

    @GetMapping("/checkValidators")
    public ResponseEntity<List<Policy>> checkValidator(){
        return ResponseEntity.ok(policyService.checkValidatorFramework());
    }
//    public ResponseEntity<Policy> getPolicyById(Long id){
//        return ResponseEntity.ok(policyService.getPolicyById(id));
//    }
//    public ResponseEntity<Policy> addPolicy(Policy policy){
//        return ResponseEntity.ok(policyService.addPolicy(policy));
//    }
}
