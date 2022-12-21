<template>
  <!-- Card -->
  <div class="d-flex Card">
    <div class="card jlmh-kk mr-5">
      <div class="card-body">
        <div>
          <span>Jumlah Kartu Keluarga</span>
          <div class="img-card">
            <p>
              <img src="@/assets/img/card-checklist.svg" alt="" />{{
                dataKK.length
              }}
            </p>
          </div>
        </div>
      </div>
    </div>
    <div class="card jlmh-seluruh-warga">
      <div class="card-body">
        <div>
          <span>Jumlah Seluruh Warga</span>
          <div class="img-card">
            <p>
              <img src="@/assets/img/people-fill.svg" alt="" />{{
                dataAK.length
              }}
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import eKtpKKService from "@/service/eKtpKKService";
export default {
  name: "cardComponent",
  data() {
    return {
      dataKK: [],
      dataAK: [],
    };
  },
  methods: {
    getAllKK() {
      eKtpKKService.getAll().then((response) => {
        this.dataKK = response.data;
        console.log(this.dataKK);
      });
    },

    getAllAK() {
      eKtpKKService.getAllAK().then((response) => {
        this.dataAK = response.data;
        console.log(this.dataAK);
      });
    },
  },

  mounted() {
    this.getAllKK();
    this.getAllAK();
  },
};
</script>

<style scoped>
.Card {
  margin-top: 80px;
  /* margin-left: 300px; */
}
.card {
  width: 30%;
  border-radius: 30px;
}
.jlmh-kk {
  background-color: #f7a76c;
}
.jlmh-seluruh-warga {
  background-color: #d0b8a8;
}
.img-card {
  font-size: 60px;
  text-align: center;
}
img {
  width: 30%;
  margin-right: 10px;
}
.card-body {
  font-size: 25px;
  /* color: white; */
}
</style>
