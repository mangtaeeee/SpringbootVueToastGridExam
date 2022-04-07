import Vue from "vue";
import App from "@/App.vue";
import router from "@/router";
import store from "@/store";
import Vuetify from "vuetify";

import "tui-grid/dist/tui-grid.css";
import "tui-date-picker/dist/tui-date-picker.css";
import "tui-time-picker/dist/tui-time-picker.css";
import "tui-pagination/dist/tui-pagination.css";
import "vuetify/dist/vuetify.min.css";
import BootstrapVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import VueTableDynamic from "vue-table-dynamic";
Vue.use(BootstrapVue);
import { Grid } from "@toast-ui/vue-grid";
Vue.use(VueTableDynamic);

Vue.component("grid", Grid);

Vue.config.productionTip = false;

Vue.use(Vuetify);

new Vue({
    Vuetify,
    router,
    store,
  
    render: h => h(App)
}).$mount("#app");
 