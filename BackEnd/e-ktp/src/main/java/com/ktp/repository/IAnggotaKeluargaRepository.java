package com.ktp.repository;


import java.util.List;

import com.ktp.model.AnggotaKeluarga;

public interface IAnggotaKeluargaRepository {

	public AnggotaKeluarga insertAKeluarga(AnggotaKeluarga akeluarga);
	
	public List<AnggotaKeluarga> getAllAnggotaKeluarga();
	
	public AnggotaKeluarga deleteAKeluarga(int id);
	
	public AnggotaKeluarga updateAkeluarga(int id, AnggotaKeluarga akeluarga);

	public AnggotaKeluarga getAnggotaKeluarga(int id);
	
	public List<AnggotaKeluarga> getAllAnggotaKeluargaID(String id_kk);
	
	public List<AnggotaKeluarga> deleteAllAKeluargaID(String id_kk);
}
