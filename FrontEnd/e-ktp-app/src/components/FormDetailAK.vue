<template>
  <div class="form">
    <h1 class="my-5">Detail Anggota Keluarga</h1>

    <button
      @click="back"
      type="button"
      class="btn btn-back m-3"
      v-show="!success"
    >
      Back
    </button>

    <button
      type="button"
      class="btn btn-upAK m-3"
      @click="modeEdit"
      v-if="isDisabled"
    >
      Update Anggota
    </button>
    <router-link :to="`/detailKK/${id}/listAnggota/detailAnggota/${id}`">
    </router-link>
    <div class="d-flex justify-content-cemter my-5">
      <div class="col-md-10">
        <form action="" @submit.prevent="updateAK">
          <div class="d-flex">
            <div class="col-md-6 p-3">
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">NIK</label>
                <input
                  class="form-control"
                  type="number"
                  placeholder="NIK"
                  style="width: 50%"
                  v-model="akData.nik"
                  :disabled="isDisabled"
                />
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Nama</label>
                <input
                  class="form-control"
                  type="text"
                  placeholder="Nama Lengkap"
                  style="width: 50%"
                  v-model="akData.nama"
                  :disabled="isDisabled"
                />
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Jenis Kelamin</label>
                <select
                  class="custom-select"
                  id="inputGroupSelect01"
                  v-model="akData.jenis_kelamin"
                  style="width: 50%"
                  :disabled="isDisabled"
                >
                  <option selected></option>
                  <option value="Laki-laki">Laki-laki</option>
                  <option value="Perempuan">Perempuan</option>
                </select>
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Tempat Lahir</label>
                <input
                  class="form-control"
                  type="text"
                  placeholder="Tempat Lahir"
                  style="width: 50%"
                  v-model="akData.tempat_lahir"
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
              <button type="submit" class="btn btn-submit" v-if="!isDisabled">
                Update
              </button>
            </div>
            <div class="col-md-6 p-3">
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Tanggal Lahir</label>
                <input
                  class="form-control"
                  type="Date"
                  style="width: 50%"
                  v-model="akData.tanggal_lahir"
                  :disabled="isDisabled"
                />
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Agama</label>
                <input
                  class="form-control"
                  type="text"
                  placeholder="Agama"
                  style="width: 50%"
                  v-model="akData.agama"
                  :disabled="isDisabled"
                />
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Pendidikan</label>
                <input
                  class="form-control"
                  type="text"
                  placeholder="Pendidikan Terakhir"
                  style="width: 50%"
                  v-model="akData.pendidikan"
                  :disabled="isDisabled"
                />
              </div>
              <div class="col-auto d-flex justify-content-between my-3">
                <label for="name">Kepala Keluarga</label>
                <select
                  class="custom-select"
                  id="inputGroupSelect01"
                  v-model="akData.kepala_keluarga"
                  style="width: 50%"
                  :disabled="isDisabled"
                >
                  <option selected></option>
                  <option value="Yes">Yes</option>
                  <option value="No">No</option>
                </select>
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
  name: "formDetailAKPage",
  components: {
    // SuccessFormVue,
  },
  data() {
    return {
      akData: {
        nik: null,
        nama: null,
        jenis_kelamin: null,
        tempat_lahir: null,
        tanggal_lahir: null,
        agama: null,
        pendidikan: null,
        kepala_keluarga: null,
      },
      success: false,
      isDisabled: true,
      id: this.$route.params.idAnggota,
    };
  },
  methods: {
    insertAK() {
      let data = this.akData;
      eKtpKKService
        .createAK(data)
        .then((response) => {
          console.log(response.data);
          // this.success = true;
          this.$swal({
            title: "Update",
            text: "Berhasil update data Anggota Keluarga!",
            icon: "success",
          }).then(function () {
            window.location.reload();
          });
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getAKedit() {
      let id = this.$route.params.idAnggota;
      eKtpKKService
        .getAKedit(id)
        .then((response) => {
          this.akData = response.data;
          console.log(this.akData);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    updateAK() {
      let data = this.akData;
      let id = this.$route.params.idAnggota;
      eKtpKKService
        .updateAK(id, data)
        .then((response) => {
          this.akData = response.data;
          console.log(this.akData);
          // this.success = true;
          this.$swal({
            title: "Update",
            text: "Berhasil update data Anggota Keluarga!",
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

    back() {
      window.history.back();
    },

    reload() {
      window.location.reload();
    },
  },
  mounted() {
    this.getAKedit();
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
.btn-upAK {
  background-color: #62b6b7;
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
