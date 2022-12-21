package com.ktp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktp.model.KartuKeluarga;
import com.ktp.repository.IKartuKeluargaRepository;
import com.ktp.service.IKartuKeluargaService;

@Service
public class KartuKeluargaService implements IKartuKeluargaService{

	@Autowired
	IKartuKeluargaRepository kartuKeluargaRepository;
	
	@Override
	public KartuKeluarga insertKartuKeluarga(KartuKeluarga kartuKeluarga) {
		// TODO Auto-generated method stub
		return kartuKeluargaRepository.insertKK(kartuKeluarga);
	}

	@Override
	public List<KartuKeluarga> getAllKartuKeluarga() {
		// TODO Auto-generated method stub
		return kartuKeluargaRepository.getAllKartuKeluarga();
	}

	@Override
	public KartuKeluarga deleteKartuKeluarga(int id) {
		// TODO Auto-generated method stub
		return kartuKeluargaRepository.deleteKK(id);
	}

	@Override
	public KartuKeluarga updateKartuKeluarga(int id, KartuKeluarga kartuKeluarga) {
		// TODO Auto-generated method stub
		return kartuKeluargaRepository.updateKK(id, kartuKeluarga);
	}

	@Override
	public KartuKeluarga getKartuKeluarga(int id) {
		// TODO Auto-generated method stub
		
		return kartuKeluargaRepository.getKartuKeluarga(id);
	}

}
