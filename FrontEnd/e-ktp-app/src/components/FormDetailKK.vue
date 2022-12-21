<template>
  <div class="form">
    <h1 class="my-5">Detail Kartu Keluarga</h1>
    <router-link to="/home">
      <button type="button" class="btn btn-back m-3">Back</button>
    </router-link>
    <button
      type="button"
      class="btn btn-upKK m-3"
      @click="modeEdit"
      v-if="isDisabled"
    >
      Update Kartu Keluarga
    </button>
    <router-link :to="`/detailKK/${id}/listAnggota`">
      <button type="button" class="btn btn-lhtAK">
        Lihat Anggota Keluarga
      </button>
    </router-link>

    <div class="d-flex justify-content-cemter my-5">
      <div class="col-md-10">
        <form action="" @submit.prevent="updateKK">
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
                  :disabled="isDisabled"
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
                  :disabled="isDisabled"
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
                  :disabled="isDisabled"
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
                  :disabled="isDisabled"
                />
              </div>
              <button
                class="btn btn-delete mr-3"
                v-if="!isDisabled"
                @click="modeEdit"
              >
                Cancel
              </button>
              <button class="btn btn-submit" v-if="!isDisabled">Update</button>
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
                  :disabled="isDisabled"
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
                  :disabled="isDisabled"
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
                  :disabled="isDisabled"
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
                  :disabled="isDisabled"
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
                  :disabled="isDisabled"
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
  name: "formDetailKKPage",
  components: {
    // SuccessFormVue,
  },
  data() {
    return {
      buttonlink: this.$route.path,
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
      isDisabled: true,
      id: this.$route.params.id,
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
            title: "Update",
            text: "Berhasil update data Kartu Keluarga!",
            icon: "success",
          }).then(function () {
            window.location.reload();
          });
        })
        .catch((e) => {
          console.log(e);
        });
    },

    getKK() {
      let id = this.$route.params.id;
      eKtpKKService
        .getKK(id)
        .then((response) => {
          this.kkData = response.data;
          console.log(this.kkData);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    updateKK() {
      let data = this.kkData;
      let id = this.$route.params.id;
      eKtpKKService
        .updateKK(id, data)
        .then((response) => {
          this.kkData = response.data;
          console.log(this.kkData);
          // this.success = true;
          this.$swal({
            title: "Update",
            text: "Berhasil update data Kartu Keluarga!",
            icon: "success",
          }).then(function () {
            window.location.reload();
          });
        })
        .catch((e) => {
          console.log(e);
        });
    },
    modeEdit() {
      this.isDisabled = !this.isDisabled;
    },
  },

  mounted() {
    this.getKK();
  },
};
</script>

<style scoped>
form {
  border-radius: 30px;
  border: 3px solid #9ed5c5;
  background-color: #bcead5;
}
.btn-back {
  background-color: #404258;
  color: white;
  border-radius: 1.125rem;
  min-width: 110px;
}
.btn-upKK {
  background-color: #62b6b7;
  color: white;
  border-radius: 1.125rem;
  min-width: 110px;
}
.btn-lhtAK {
  background-color: #f49d1a;
  color: white;
  border-radius: 1.125rem;
  min-width: 110px;
}
.btn-submit {
  border-radius: 1.125rem;
  min-width: 110px;
  background-color: #5fd068;
  color: white;
}
.btn-delete {
  border-radius: 1.125rem;
  min-width: 110px;
  background-color: #d61c4e;
  color: white;
}
</style>
