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

import com.ktp.model.KartuKeluarga;
import com.ktp.service.IKartuKeluargaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/kartuKeluarga")
public class KartuKeluargaController {

	@Autowired
	IKartuKeluargaService kartuKeluargaService;
	
	 @PostMapping("/insert")
	    public KartuKeluarga insertKartuKeluarga(@RequestBody KartuKeluarga kartuKeluarga) {
	        return kartuKeluargaService.insertKartuKeluarga(kartuKeluarga);
	    }
	 @GetMapping("/getAll")
	 public List<KartuKeluarga> getAllKartuKeluarga(){
		 return kartuKeluargaService.getAllKartuKeluarga();
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public KartuKeluarga deleteKartuKeluarga(@PathVariable int id) {
		 return kartuKeluargaService.deleteKartuKeluarga(id);
	 }
	 
	 @PutMapping("/update/{id}")
	 public KartuKeluarga updateKartuKeluarga(@PathVariable int id, @RequestBody KartuKeluarga kartuKeluarga) {
		 return kartuKeluargaService.updateKartuKeluarga(id, kartuKeluarga);
	 }
	 
	 @GetMapping("/getKK/{id}")
	 public KartuKeluarga getKartuKeluarga(@PathVariable int id) {
		 return kartuKeluargaService.getKartuKeluarga(id);
	 }
}
