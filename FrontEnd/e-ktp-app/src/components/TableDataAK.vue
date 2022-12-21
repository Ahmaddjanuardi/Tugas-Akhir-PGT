<template>
  <div class="">
    <!-- Table Anggota keluarga -->
    <div class="tableAK" v-show="isDisabled">
      <h1 class="text-center my-5">Daftar Anggota Keluarga</h1>
      <router-link :to="`/detailKK/${id}`">
        <button type="button" class="btn m-3 btn-back">Back</button>
      </router-link>
      <button type="button" class="btn btn-tmbhAK m-3" @click="tambahAKFunc">
        Tambah Anggota Keluarga
      </button>
      <!-- <router-link :to="`/detailKK/${id}/listAnggota`">
      </router-link> -->
      <table class="table table-striped">
        <thead>
          <tr style="background-color: #bcead5">
            <th scope="col">No.</th>
            <th scope="col">NIK</th>
            <th scope="col">NAMA</th>
            <th scope="col">Jenis Kelamin</th>
            <th scope="col">Kepala Keluarga</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody v-if="aKDataTable.length == 0">
          <tr>
            <td colspan="6">Data Tidak Tersedia</td>
          </tr>
        </tbody>
        <tbody>
          <tr v-for="(item, index) in aKDataTable" :key="item.id">
            <th>{{ index + 1 }}</th>
            <td>{{ item.nik }}</td>
            <td>{{ item.nama }}</td>
            <td>{{ item.jenis_kelamin }}</td>
            <td>{{ item.kepala_keluarga }}</td>
            <td class="d-flex">
              <router-link
                :to="{ name: 'formDetailAK', params: { idAnggota: item.id } }"
              >
                <button class="btn btn-sm btn-submit mr-2">Detail</button>
              </router-link>
              <button
                type="submit"
                class="btn btn-sm btn-delete mr-2"
                @click.prevent="deleteAnggotaKeluarga(item.id)"
              >
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <!-- <SuccessFormVue v-show="success"></SuccessFormVue> -->
    </div>

    <!-- Form Tambah Anggota Keluarga -->
    <div class="form" v-show="!isDisabled">
      <h1 class="my-5">Tambah Anggota</h1>
      <button
        @click="reload"
        type="submit"
        class="btn btn-back m-3"
        v-show="!success"
      >
        Back
      </button>
      <div class="d-flex justify-content-cemter my-5">
        <div class="col-md-10">
          <form action="" @submit.prevent="insertAK">
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
                    required
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
                    required
                  />
                </div>
                <div class="col-auto d-flex justify-content-between my-3">
                  <label for="name">Jenis Kelamin</label>
                  <select
                    class="custom-select"
                    id="inputGroupSelect01"
                    v-model="akData.jenis_kelamin"
                    style="width: 50%"
                    required
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
                    required
                  />
                </div>
                <p style="color: red" v-if="isValid">Nik Sudah Terdaftar</p>
                <button type="submit" class="btn btn-submit" @click="addIdAK">
                  Submit
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
                    required
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
                    required
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
                    required
                  />
                </div>
                <div class="col-auto d-flex justify-content-between my-3">
                  <label for="name">Kepala Keluarga</label>
                  <select
                    class="custom-select"
                    id="inputGroupSelect01"
                    v-model="akData.kepala_keluarga"
                    style="width: 50%"
                    required
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
  </div>
</template>

<script>
import eKtpKKService from "@/service/eKtpKKService";
// import SuccessFormVue from "./SuccessForm.vue";
export default {
  name: "tableDataAk",
  components: {
    // SuccessFormVue,
  },
  data() {
    return {
      akData: {
        nik: null,
        nama: null,
        id_kk: null,
        jenis_kelamin: null,
        tempat_lahir: null,
        tanggal_lahir: null,
        agama: null,
        pendidikan: null,
        kepala_keluarga: null,
      },
      aKDataTable: null,
      success: false,
      isDisabled: true,
      id: this.$route.params.id,
      isValid: false,
    };
  },
  methods: {
    getAK() {
      let id_kk = this.$route.params.id;
      eKtpKKService
        .getAK(id_kk)
        .then((response) => {
          this.aKDataTable = response.data;
          console.log(this.aKDataTable);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    insertAK() {
      let data = this.akData;
      eKtpKKService
        .createAK(data)
        .then((response) => {
          console.log(response.data);
          // this.success = true;
          this.$swal({
            title: "Submit",
            text: "Data Anggota Keluarga kamu sudah terkirim",
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
    deleteAnggotaKeluarga(id) {
      // if (confirm("Apakah ingin menghapus data ini")) {
      this.$swal({
        title: "Hapus",
        text: "Apakah anda ingin menghapus data ini?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: "Yes Delete it!",
        cancelButtonText: "No, Keep it!",
        showCloseButton: true,
        showLoaderOnConfirm: true,
      }).then((result) => {
        if (result.value) {
          this.$swal(
            "Hapus",
            "Kamu berhasil menghapus data Anggota Keluarga!"
          ).then(function () {
            window.location.reload();
          });
          eKtpKKService
            .deleteAK(id)
            .then((response) => {
              console.log(response.data);
              // location.reload();
            })
            .catch((e) => {
              console.log(e);
            });
        } else {
          this.$swal("Batal", "Hapus Dibatalkan!");
        }
      });
      // } else {
      //   alert("Hapus dibatalkan");
      // }
    },
    tambahAKFunc() {
      this.isDisabled = false;
    },
    addIdAK() {
      this.akData.id_kk = this.$route.params.id;
    },

    reload() {
      location.reload();
    },
  },
  mounted() {
    this.getAK();
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
.btn-tmbhAK {
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
