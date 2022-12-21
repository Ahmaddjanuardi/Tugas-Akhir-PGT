<template>
  <!-- Sidebar -->
  <nav id="sidebarMenu" class="sidebar">
    <div class="list-group list-group-flush mx-3 mt-4">
      <h2 style="text-align: center">E-KTP APP</h2>
      <br />
      <router-link
        to="/home"
        href="#"
        class="list-group-item list-group-item-action py-2 ripple"
        ><img src="@/assets/img/houses-fill.svg" alt="" />
        <span>Home</span>
      </router-link>
      <router-link
        to="/addKK"
        href="#"
        class="list-group-item list-group-item-action py-2 ripple"
        ><img src="@/assets/img/file-earmark-plus-fill.svg" alt="" /><span
          >Tambah KK</span
        ></router-link
      >
      <router-link
        to="/"
        href="#"
        class="list-group-item list-group-item-action py-2 ripple mt-5"
        ><img src="@/assets/img/lock-fill.svg" alt="" /><span
          >Sign Out</span
        ></router-link
      >
    </div>
    <!-- <div class="position-sticky">
    </div> -->
  </nav>
  <!-- Sidebar -->
</template>

<script>
export default {
  name: "sideBar",
};
</script>

<style scoped>
/* Sidebar */
.sidebar {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  padding: 58px 0 0; /* Height of navbar */
  margin: 15px;
  border-radius: 20px;
  background-image: linear-gradient(45deg, #bcead5, #bcead5);
  box-shadow: 0 2px 5px 0 rgb(0 0 0 / 5%), 0 2px 10px 0 rgb(0 0 0 / 5%);
  width: 240px;
  z-index: 600;
}

.list-group-item {
  background-color: #bcead5;
}

/* @media (max-width: 991.98px) {
  .sidebar {
    width: 100%;
  }
} */
/* .sidebar .active {
  border-radius: 5px;
  box-shadow: 0 2px 5px 0 rgb(0 0 0 / 16%), 0 2px 10px 0 rgb(0 0 0 / 12%);
} */
</style>
