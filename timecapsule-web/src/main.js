import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import axios from 'axios'
import UUID from 'vue-uuid'

Vue.use(UUID)
Vue.config.productionTip = false

// 根节点注入router,store,axios,uuid
new Vue({
  axios,
  router,
  store,
  render: h => h(App)
}).$mount('#app')
