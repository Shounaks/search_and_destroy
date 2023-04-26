package shounak.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shounak.entity.Policy;
import shounak.repository.PolicyRepository;
import shounak.validation.MainExecutor;
import shounak.validationframework.SNDResponse;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PolicyService {
    final MainExecutor executor;
    final PolicyRepository policyRepository;

    public List<Policy> checkValidatorFramework() {
        Policy newPolicy = Policy.builder().price(2500D).authorId(123L).title("Shounak").build();
        SNDResponse validationReport = executor.execute(newPolicy);
        //TODO: Currently we are sending back the policy directly, but we need to search the DB
        return validationReport.getPolicies();
    }

//    public List<Policy> getAllPolicy() {
//        return policyRepository.findAll();
//    }
//
//    public Policy getPolicyById(Long id) {
//        return policyRepository.findById(id)
//                .orElseThrow(() -> new SNDException("NO Element with this ID"));
//    }
//
//    public Policy addPolicy(Policy policy) {
//        return policyRepository.save(policy);
//    }
}
