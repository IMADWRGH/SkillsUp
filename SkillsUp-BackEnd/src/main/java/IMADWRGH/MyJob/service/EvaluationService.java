package IMADWRGH.MyJob.service;

import IMADWRGH.MyJob.Repository.EvaluationRepository;
import IMADWRGH.MyJob.entity.Evaluation;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public Evaluation create(Evaluation evaluation){
        return evaluationRepository.save(evaluation);
    }
}
