package HrMS;

import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class HrService {
    private final HrRepository repo;

    public HrService(HrRepository repo) {
        this.repo = repo;
    }
    public  void insertHrModal (HrModel hrModel){
        repo.save(hrModel);
    }
    public void updateHrModal(HrModel hrModel){
        repo.save(hrModel);

    }
    public  void deleteHrModal(Long id){
        repo.deleteById(id);
    }
    public HrModel getHrModalById(Long id){
        return repo.findById(id).orElse(null);
    }
    public List<HrModel> getAllHrModal(Long keyword){
        if (keyword != null)
            return repo.search(keyword);
        return repo.findAll();
    }

}
