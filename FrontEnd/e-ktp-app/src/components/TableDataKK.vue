<template>
  <!-- Table List KK -->
  <div class="tableKK">
    <h1 class="text-center my-5">Data Kartu Keluarga</h1>
    <table class="table table-striped">
      <!-- <h1 v-if="dataKosong">Data Tidak Tersedia</h1> -->
      <thead>
        <tr style="background-color: #bcead5">
          <th scope="col">No.</th>
          <th scope="col">Nomor KK</th>
          <th scope="col">Alamat</th>
          <th scope="col">Kota</th>
          <th scope="col">Kode Pos</th>
          <th scope="col">Action</th>
        </tr>
      </thead>
      <tbody v-if="kkData.length == 0">
        <tr>
          <td colspan="6">Data Tidak Tersedia</td>
        </tr>
      </tbody>
      <tbody>
        <tr v-for="(item, index) in kkData" :key="item.id">
          <th>{{ index + 1 }}</th>
          <td>{{ item.nomor_kk }}</td>
          <td>{{ item.alamat }}</td>
          <td>{{ item.kabupaten_kota }}</td>
          <td>{{ item.kode_pos }}</td>
          <td class="d-flex">
            <router-link :to="{ path: '/detailKK/' + item.id }">
              <button class="btn btn-sm btn-submit mr-2">Detail</button>
            </router-link>
            <button
              type="submit"
              class="btn btn-sm btn-delete mr-2"
              @click.prevent="deletekartuKeluarga(item.id)"
            >
              Delete
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <!-- <SuccessFormVue v-show="success"></SuccessFormVue> -->
  </div>
</template>

<script>
import eKtpKKService from "@/service/eKtpKKService";
// import SuccessFormVue from "./SuccessForm.vue";
export default {
  name: "tableDataKK",
  components: {
    // SuccessFormVue,
  },
  methods: {
    getKK() {
      eKtpKKService
        .getAll()
        .then((response) => {
          this.kkData = response.data;
          console.log(this.kkData);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    deletekartuKeluarga(id) {
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
            "Kamu berhasil menghapus data Kartu Keluarga"
          ).then(function () {
            window.location.reload();
          });
          eKtpKKService
            .deleteKK(id)
            .then((response) => {
              eKtpKKService.deleteAllAK(id);
              console.log(response.data);
              // this.success = true;
            })
            .catch((e) => {
              console.log(e);
            });
        } else {
          this.$swal("Batal", "Hapus Dibatalkan!");
        }
      });
      // } else {
      //   alert("Hapus Dibatalkan");
      // }
    },
  },
  mounted() {
    this.getKK();
  },
  data() {
    return {
      kkData: null,
      success: false,
    };
  },
};
</script>

<style scoped>
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
