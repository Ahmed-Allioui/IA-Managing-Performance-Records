package de.hbrs.HighPerformance.Controller;

import de.hbrs.HighPerformance.entities.EvaluationRecord;
import de.hbrs.HighPerformance.service.ManagePersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("record")
public class EvaluationRecordController {

    @Autowired
    private ManagePersonal managePersonal;

    @GetMapping("{sid}")
    public List<EvaluationRecord> readEvaluationRecords(@PathVariable  int sid) {
        return managePersonal.readEvaluationRecords(sid);
    }

    @PostMapping("{sid}")
    public long createPerformanceRecord(@RequestBody EvaluationRecord record, @PathVariable int sid){
        return managePersonal.addPerformanceRecord(record, sid);
    }

    @PutMapping("{sid}")
    public long updatePerformanceRecord(@RequestBody EvaluationRecord record, @PathVariable int sid){
        return managePersonal.updatePerformanceRecord(record, sid);
    }

    @DeleteMapping("{rid}/{sid}")
    public void deletePerformanceRecord(@PathVariable int rid, @PathVariable int sid) {
        managePersonal.deletePerformanceRecord(rid, sid);
    }
}
