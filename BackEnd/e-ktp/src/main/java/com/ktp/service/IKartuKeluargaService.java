package com.ktp.service;

import java.util.List;

import com.ktp.model.KartuKeluarga;

public interface IKartuKeluargaService {

	public KartuKeluarga insertKartuKeluarga(KartuKeluarga kartuKeluarga);
	
	public List<KartuKeluarga> getAllKartuKeluarga();
	
	public KartuKeluarga deleteKartuKeluarga(int id);
	
	public KartuKeluarga updateKartuKeluarga(int id, KartuKeluarga kartuKeluarga);
	
	public KartuKeluarga getKartuKeluarga(int id);
}
