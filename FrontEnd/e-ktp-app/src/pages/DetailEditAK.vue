<template>
  <div class="">
    <SideBarVue></SideBarVue>
    <div class="container">
      <FormDetailAKVue></FormDetailAKVue>
      <CopyrightVue></CopyrightVue>
    </div>
  </div>
</template>

<script>
import SideBarVue from "@/components/SideBar.vue";
import FormDetailAKVue from "@/components/FormDetailAK.vue";
import CopyrightVue from "@/components/Copyright.vue";
export default {
  name: "detailAK",
  components: {
    SideBarVue,
    FormDetailAKVue,
    CopyrightVue,
  },
};
</script>

<style scoped>
.container {
  margin-left: 300px;
}
</style>
