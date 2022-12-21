import http from "@/http-common";

class kartuKeluargaService{
    // Service KK
    create(data){
        return http.post("/kartuKeluarga/insert", data);
    }
    getAll(){
        return http.get("/kartuKeluarga/getAll");
    }
    deleteKK(id){
        return http.delete(`/kartuKeluarga/delete/${id}`)
    }
    updateKK(id, data){
        return http.put(`/kartuKeluarga/update/${id}`,data)
    }
    getKK(id){
        return http.get(`/kartuKeluarga/getKK/${id}`)
    }

    // Service AK
    createAK(data){
        return http.post("/anggotaKeluarga/insert", data);
    }
    getAllAK(){
        return http.get("/anggotaKeluarga/getAll");
    }
    deleteAK(id){
        return http.delete(`/anggotaKeluarga/delete/${id}`)
    }
    updateAK(id, data){
        return http.put(`/anggotaKeluarga/update/${id}`,data)
    }
    getAKedit(id){
        return http.get(`/anggotaKeluarga/getAKedit/${id}`)
    }
    getAK(id_kk){
        return http.get(`/anggotaKeluarga/getAK/${id_kk}`)
    }
    
    deleteAllAK(id_kk){
        return http.delete(`/anggotaKeluaga/deleteAllAnggotaK/${id_kk}`)
    }
    

    // Service Login
    login(data){
        return http.post('/userLogin/login',data)
    }
    register(data){
        return http.post('/userLogin/register', data)
    }
}
export default new kartuKeluargaService();