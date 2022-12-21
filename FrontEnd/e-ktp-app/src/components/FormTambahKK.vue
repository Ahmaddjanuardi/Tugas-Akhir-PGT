<template>
  <div class="form">
    <h1 class="my-5">Tambah Kartu Keluarga</h1>
    <router-link to="/home">
      <button type="button" class="btn btn-back m-3" v-show="!success">
        Back
      </button>
    </router-link>
    <div class="d-flex justify-content-cemter my-5">
      <div class="col-md-10">
        <form action="" @submit.prevent="insertKK">
          <div class="d-flex">
            <div class="col-md-6 p-3">
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Nomor Kartu Keluarga</label>
                <input
                  class="form-control"
                  type="number"
                  placeholder="Nomor Kartu Keluarga"
                  style="width: 50%"
                  v-model="kkData.nomor_kk"
                  required
                />
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="">Alamat</label>
                <textarea
                  class="form-control"
                  name=""
                  id=""
                  placeholder="Alamat"
                  rows="3"
                  cols="30"
                  style="width: 50%"
                  v-model="kkData.alamat"
                  required
                ></textarea>
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">RT</label>
                <input
                  class="form-control"
                  type="number"
                  placeholder="RT"
                  style="width: 50%"
                  v-model="kkData.rt"
                  required
                />
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">RW</label>
                <input
                  class="form-control"
                  type="number"
                  placeholder="RW"
                  style="width: 50%"
                  v-model="kkData.rw"
                  required
                />
              </div>
              <p style="color: red" v-if="isValid">No KK Sudah Digunakan</p>
              <button type="submit" class="btn btn-submit">Submit</button>
            </div>
            <div class="col-md-6 p-3">
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Desa/Kelurahan</label>
                <input
                  class="form-control"
                  type="text"
                  placeholder="Desa/Kelurahan"
                  style="width: 50%"
                  v-model="kkData.desa_kelurahan"
                  required
                />
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Kecamatan</label>
                <input
                  class="form-control"
                  type="text"
                  placeholder="Kecamatan"
                  style="width: 50%"
                  v-model="kkData.kecamatan"
                  required
                />
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Kabupaten/Kota</label>
                <input
                  class="form-control"
                  type="text"
                  placeholder="Kabupaten/Kota"
                  style="width: 50%"
                  v-model="kkData.kabupaten_kota"
                  required
                />
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Provinsi</label>
                <input
                  class="form-control"
                  type="text"
                  placeholder="Provinsi"
                  style="width: 50%"
                  v-model="kkData.provinsi"
                  required
                />
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Kode Pos</label>
                <input
                  class="form-control"
                  type="number"
                  placeholder="Kode Pos"
                  style="width: 50%"
                  v-model="kkData.kode_pos"
                  required
                />
              </div>
            </div>
          </div>
        </form>
        <!-- Success Section -->
        <!-- <SuccessFormVue v-show="success"></SuccessFormVue> -->
      </div>
    </div>
  </div>
</template>

<script>
import eKtpKKService from "@/service/eKtpKKService";
// import SuccessFormVue from "./SuccessForm.vue";
export default {
  name: "formTambahKKPage",
  components: {
    // SuccessFormVue,
  },
  data() {
    return {
      // buttonlink: this.$route.path,
      kkData: {
        nomor_kk: null,
        alamat: null,
        rt: null,
        rw: null,
        desa_kelurahan: null,
        kecamatan: null,
        kabupaten_kota: null,
        provinsi: null,
        kode_pos: null,
      },
      success: false,
      isValid: false,
    };
  },
  methods: {
    insertKK() {
      let data = this.kkData;
      eKtpKKService
        .create(data)
        .then((response) => {
          console.log(response.data);
          // this.success = true;
          this.$swal({
            title: "Submit",
            text: "Data Kartu Keluarga kamu sudah terkirim",
            icon: "success",
          }).then(function () {
            window.location.reload();
          });
        })
        .catch((e) => {
          // console.log(e);
          // console.log(e.response.data.trace.includes("Duplicate entry"));
          let duplicate = e.response.data.trace.includes("Duplicate entry");
          if (duplicate) {
            this.isValid = true;
          } else {
            console.log(e);
          }
        });
    },
  },
};
</script>

<style scoped>
/* .form {
  margin-left: 300px;
} */
form {
  border-radius: 30px;
  border: 3px solid #9ed5c5;
  background-color: #bcead5;
}
.btn-back {
  background-color: #404258;
  color: white;
}
.btn-submit {
  border-radius: 1.125rem;
  min-width: 110px;
  background-color: #5fd068;
  color: white;
}
</style>
