package com.ktp.repository;

import java.util.List;

import com.ktp.model.KartuKeluarga;

public interface IKartuKeluargaRepository {

	public KartuKeluarga insertKK(KartuKeluarga kartuKeluarga);
	
	public List<KartuKeluarga> getAllKartuKeluarga();
	
	public KartuKeluarga deleteKK(int id);
	
	public KartuKeluarga updateKK(int id, KartuKeluarga kartuKeluarga);
	
	public KartuKeluarga getKartuKeluarga(int id);
}
