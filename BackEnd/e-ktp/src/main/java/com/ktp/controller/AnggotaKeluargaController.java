package com.ktp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktp.model.AnggotaKeluarga;
import com.ktp.service.IAnggotaKeluargaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/anggotaKeluarga")
public class AnggotaKeluargaController {
	
	@Autowired
	IAnggotaKeluargaService akeluargaService;
	
	 @PostMapping("/insert")
	    public AnggotaKeluarga insertAnggotaKeluarga(@RequestBody AnggotaKeluarga akeluarga) {
	        return akeluargaService.insertAnggotaKeluarga(akeluarga);
	    } 
	 
	 @GetMapping("/getAll")
	 public List<AnggotaKeluarga> getAllAnggotaKeluarga(){
		 return akeluargaService.getAllAnggotaKeluarga();
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public AnggotaKeluarga deleteAnggotaKeluarga(@PathVariable int id) {
		 return akeluargaService.deleteAnggotaKeluarga(id);
	 }
	 
	 @PutMapping("/update/{id}")
	 public AnggotaKeluarga updateAnggotaKeluarga(@PathVariable int id, @RequestBody AnggotaKeluarga aKeluarga) {
		 return akeluargaService.updateAnggotaKeluarga(id, aKeluarga);
	 }
	 
	 @GetMapping("/getAKedit/{id}")
	 public AnggotaKeluarga getAnggotaKeluarga(@PathVariable int id) {
		 return akeluargaService.getAnggotaKeluarga(id);
	 }
	 
	 @GetMapping("/getAK/{id_kk}")
	 public List<AnggotaKeluarga> getAllAnggotaKeluargaID(@PathVariable String id_kk){
		 return akeluargaService.getAllAnggotaKeluargaID(id_kk);
	 }
	 
	 @DeleteMapping("/deleteAllAnggotaK/{id_kk}")
	 public List<AnggotaKeluarga> deleteAllAnggotaKeluargaID(@PathVariable String id_kk){
		 return akeluargaService.deleteAllAnggotaKeluargaID(id_kk);
	 }
	 
}
