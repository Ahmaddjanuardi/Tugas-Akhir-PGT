<template>
  <div class="">
    <SideBarVue></SideBarVue>
    <div class="container">
      <FormTambahKKVue></FormTambahKKVue>
      <CopyrightVue></CopyrightVue>
    </div>
  </div>
</template>

<script>
import SideBarVue from "@/components/SideBar.vue";
import FormTambahKKVue from "@/components/FormTambahKK.vue";
import CopyrightVue from "@/components/Copyright.vue";
export default {
  name: "tambahKK",
  components: {
    SideBarVue,
    FormTambahKKVue,
    CopyrightVue,
  },
};
</script>

<style scoped>
/* .container {
  width: 65%;
} */
.container {
  margin-left: 300px;
}
</style>
