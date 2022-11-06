package de.hbrs.HighPerformance.Controller;

import de.hbrs.HighPerformance.entities.SalesMan;
import de.hbrs.HighPerformance.service.ManagePersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salesman")
public class SalesmanController {

    @Autowired
    private ManagePersonal managePersonal;

    @GetMapping("")
    public List<SalesMan> getAllSalesmen(){
        return managePersonal.readAllSalesMen();
    }

    @GetMapping("{id}")
    public SalesMan getSalesmanById(@PathVariable Integer id){
        return managePersonal.readSalesMan(id);
    }

    @PostMapping("")
    public void createSalesman(@RequestBody SalesMan salesMan){
        managePersonal.createSalesMan(salesMan);
    }

    @PostMapping("all")
    public void createAllSalesmen(@RequestBody List<SalesMan> salesMen){
        managePersonal.createAllSalesMen(salesMen);
    }

    @PutMapping("")
    public SalesMan updateSalesman(@RequestBody SalesMan salesMan){
        return managePersonal.updateSalesMan(salesMan);
    }

    @DeleteMapping("{id}")
    public void deleteSalesman(@PathVariable int id){
        managePersonal.deleteSalesMan(id);
    }

    @DeleteMapping("")
    public void deleteSalesman(){
        managePersonal.deleteAllSalesMen();
    }
}
