package com.ktp.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ktp.model.AnggotaKeluarga;
import com.ktp.repository.IAnggotaKeluargaRepository;

@Repository
public class AnggotaKeluargaRepository implements IAnggotaKeluargaRepository {
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public AnggotaKeluarga insertAKeluarga(AnggotaKeluarga akeluarga) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_anggota_keluarga(agama, id_kk, "
				+ "jenis_kelamin, kepala_keluarga, nama, nik, pendidikan, "
				+ "tanggal_lahir, tempat_lahir)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query, new Object[] 
				{akeluarga.getAgama(), akeluarga.getId_kk(), akeluarga.getJenis_kelamin(), 
						akeluarga.getKepala_keluarga(), akeluarga.getNama(), akeluarga.getNik(), 
						akeluarga.getPendidikan(), akeluarga.getTanggal_lahir(), akeluarga.getTempat_lahir()});
		return akeluarga;
	}

	@Override
	public List<AnggotaKeluarga> getAllAnggotaKeluarga() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class));
	}

	@Override
	public AnggotaKeluarga deleteAKeluarga(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class),id);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id = ?";
		jdbcTemplate.update(query, id);
		return result;
	}

	@Override
	public AnggotaKeluarga updateAkeluarga(int id, AnggotaKeluarga akeluarga) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_anggota_keluarga SET agama = ?, id_kk = ?, jenis_kelamin = ?, "
				+ "kepala_keluarga = ?, nama = ?, nik = ?, pendidikan = ?,"
				+ "tanggal_lahir = ?, tempat_lahir = ? WHERE id = ?";
		jdbcTemplate.update(query, new Object[]{akeluarga.getAgama(), akeluarga.getId_kk(), akeluarga.getJenis_kelamin(),
				akeluarga.getKepala_keluarga(), akeluarga.getNama(), akeluarga.getNik(), akeluarga.getPendidikan(),
				akeluarga.getTanggal_lahir(), akeluarga.getTempat_lahir(), id});
		return akeluarga;
	}

	@Override
	public AnggotaKeluarga getAnggotaKeluarga(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class),id);
		return result;
	}

	@Override
	public List<AnggotaKeluarga> getAllAnggotaKeluargaID(String id_kk) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id_kk);
	}

	@Override
	public List<AnggotaKeluarga> deleteAllAKeluargaID(String id_kk) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id_kk);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id_kk = ?";
		jdbcTemplate.update(query, id_kk);
		return result;
	}

}
