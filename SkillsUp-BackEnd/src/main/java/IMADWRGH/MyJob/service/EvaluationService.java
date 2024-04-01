package IMADWRGH.MyJob.service;

import IMADWRGH.MyJob.Repository.EvaluationRepository;
import IMADWRGH.MyJob.entity.Evaluation;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public Evaluation create(Evaluation evaluation){
        return evaluationRepository.save(evaluation);
    }

    public Boolean delete(int id){
        evaluationRepository.deleteById(id);
        return Boolean.TRUE;
    }

    public Evaluation update(Evaluation evaluation){
        return evaluationRepository.save(evaluation);
    }

    public List<Evaluation> list(int limit){
        return evaluationRepository.findAll(PageRequest.of(0,limit)).toList();
    }
}
