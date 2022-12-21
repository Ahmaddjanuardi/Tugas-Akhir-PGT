import Vue from 'vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import routes from './routes'
import VueSweetalert2 from 'vue-sweetalert2'
import VueSession from 'vue-session'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'sweetalert2/dist/sweetalert2.min.css'

Vue.config.productionTip = false

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(VueRouter);
Vue.use(VueSweetalert2);
Vue.use(VueSession);

const router = new VueRouter({
  routes : routes,
  mode : "history"
})
// router.replace({path:'/'}) session
new Vue({
  render: h => h(App),
  router: router,
}).$mount('#app')
