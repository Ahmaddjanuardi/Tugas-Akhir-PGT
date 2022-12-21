<template>
  <div class="">
    <SideBarVue></SideBarVue>
    <div class="container">
      <FormDetailKKVue> </FormDetailKKVue>
      <CopyrightVue></CopyrightVue>
    </div>
  </div>
</template>

<script>
import SideBarVue from "@/components/SideBar.vue";
import FormDetailKKVue from "@/components/FormDetailKK.vue";
import CopyrightVue from "@/components/Copyright.vue";
export default {
  name: "detailKK",
  components: {
    SideBarVue,
    FormDetailKKVue,
    CopyrightVue,
  },
};
</script>

<style scoped>
.container {
  margin-left: 300px;
}
</style>
