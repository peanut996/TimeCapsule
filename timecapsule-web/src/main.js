import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'

Vue.config.productionTip = false

// // 添加路由钩子
// router.beforeEach((to, from, next) => {
//   // 根据字段判断是否路由过滤
//   if (to.matched.some(record => record.meta.auth)) {
//     if (store.state.islogin === true) {
//       next()
//     } else {
//       // 防止无限循环
//       if (to.name === 'user-login') {
//         next()
//         return
//       }
//       next({
//         path: '/user-login'
//       })
//     }
//   } else {
//     next()// 若点击的是不需要验证的页面,则进行正常的路由跳转
//   }
// })

// 根节点注入router,store
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
