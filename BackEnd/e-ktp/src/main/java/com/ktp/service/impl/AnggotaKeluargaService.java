package com.ktp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktp.model.AnggotaKeluarga;
import com.ktp.repository.IAnggotaKeluargaRepository;
import com.ktp.service.IAnggotaKeluargaService;
@Service
public class AnggotaKeluargaService implements IAnggotaKeluargaService {

	@Autowired
	IAnggotaKeluargaRepository akeluargaRepository;
	@Override
	public AnggotaKeluarga insertAnggotaKeluarga(AnggotaKeluarga akeluarga) {
		// TODO Auto-generated method stub
		
		return akeluargaRepository.insertAKeluarga(akeluarga);
	}
	@Override
	public List<AnggotaKeluarga> getAllAnggotaKeluarga() {
		// TODO Auto-generated method stub
		return akeluargaRepository.getAllAnggotaKeluarga();
	}
	@Override
	public AnggotaKeluarga deleteAnggotaKeluarga(int id) {
		// TODO Auto-generated method stub
		return akeluargaRepository.deleteAKeluarga(id);
	}
	@Override
	public AnggotaKeluarga updateAnggotaKeluarga(int id, AnggotaKeluarga aKeluarga) {
		// TODO Auto-generated method stub
		return akeluargaRepository.updateAkeluarga(id, aKeluarga);
	}
	@Override
	public AnggotaKeluarga getAnggotaKeluarga(int id) {
		// TODO Auto-generated method stub
		return akeluargaRepository.getAnggotaKeluarga(id);
	}
	@Override
	public List<AnggotaKeluarga> getAllAnggotaKeluargaID(String id_kk) {
		// TODO Auto-generated method stub
		return akeluargaRepository.getAllAnggotaKeluargaID(id_kk);
	}
	@Override
	public List<AnggotaKeluarga> deleteAllAnggotaKeluargaID(String id_kk) {
		// TODO Auto-generated method stub
		return akeluargaRepository.deleteAllAKeluargaID(id_kk);
	}

}
