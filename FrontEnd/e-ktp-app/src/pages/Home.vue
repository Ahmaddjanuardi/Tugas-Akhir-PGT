<template>
  <div class="">
    <SideBarVue></SideBarVue>
    <div class="container">
      <h1 class="my-5">{{ $route.name }}</h1>
      <CardVue></CardVue>
      <TableDataKK></TableDataKK>
      <CopyrightVue></CopyrightVue>
    </div>
  </div>
</template>

<script>
import SideBarVue from "@/components/SideBar.vue";
import CardVue from "@/components/Card.vue";
import TableDataKK from "@/components/TableDataKK.vue";
import CopyrightVue from "@/components/Copyright.vue";
export default {
  name: "homePage",
  components: {
    SideBarVue,
    CardVue,
    TableDataKK,
    CopyrightVue,
  },
};
</script>

<style scoped>
.container {
  margin-left: 300px;
}
</style>
