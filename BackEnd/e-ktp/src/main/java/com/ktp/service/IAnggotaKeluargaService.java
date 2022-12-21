package com.ktp.service;

import java.util.List;

import com.ktp.model.AnggotaKeluarga;
public interface IAnggotaKeluargaService {
	
	public AnggotaKeluarga insertAnggotaKeluarga(AnggotaKeluarga akeluarga);

	public List<AnggotaKeluarga> getAllAnggotaKeluarga();
	
	public AnggotaKeluarga deleteAnggotaKeluarga(int id);
	
	public AnggotaKeluarga updateAnggotaKeluarga(int id, AnggotaKeluarga aKeluarga);
	
	public AnggotaKeluarga getAnggotaKeluarga(int id);
	
	public List<AnggotaKeluarga> getAllAnggotaKeluargaID(String id_kk);
	
	public List<AnggotaKeluarga> deleteAllAnggotaKeluargaID(String id_kk);
}
