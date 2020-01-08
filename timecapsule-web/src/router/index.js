import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Admin from '../views/Admin.vue'
import User from '../views/User.vue'
import Put from '../components/user/Put.vue'
import Open from '../components/user/Open.vue'
import Login from '../components/user/Login.vue'
import Register from '../components/user/Register.vue'
import Profile from '../components/user/Profile.vue'
import About from '../views/About.vue'
import store from '../store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/user',
    name: 'user',
    component: User
  },
  {
    path: '/user-put',
    name: 'user-put',
    component: Put,
    meta: {
      auth: true
    }
  },
  {
    path: '/user-login',
    name: 'user-login',
    component: Login
  },
  {
    path: '/user-register',
    name: 'user-register',
    component: Register
  },
  {
    path: '/user-profile',
    name: 'user-profile',
    component: Profile
  },
  {
    path: '/user-open',
    component: Open,
    meta: {
      auth: false
    }
  },
  {
    path: '/admin',
    component: Admin
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: About
  }
]

const router = new VueRouter({
  linkActiveClass: 'active',
  routes
})

// 添加路由钩子
router.beforeEach((to, from, next) => {
  // 根据字段判断是否路由过滤
  if (to.matched.some(record => record.meta.auth)) {
    if (store.state.islogin === true) {
      next()
    } else {
      // 防止无限循环
      if (to.name === 'user-login') {
        next()
        return
      }
      ElementUI.Message.error('尚未登录...')
      next({
        path: '/user-login'
      })
    }
  } else {
    next()// 若点击的是不需要验证的页面,则进行正常的路由跳转
  }
})

export default router
