<template>
  <div class="">
    <SideBarVue></SideBarVue>
    <div class="container">
      <TableDataAKVue></TableDataAKVue>
      <CopyrightVue></CopyrightVue>
    </div>
  </div>
</template>

<script>
import SideBarVue from "@/components/SideBar.vue";
import TableDataAKVue from "@/components/TableDataAK.vue";
import CopyrightVue from "@/components/Copyright.vue";
export default {
  name: "detailAK",
  components: {
    SideBarVue,
    TableDataAKVue,
    CopyrightVue,
  },
  // created() {
  //   console.log(this.$route.params.id);
  // },
};
</script>

<style scoped>
.container {
  margin-left: 300px;
}
</style>
